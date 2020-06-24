package com.j2eefast.flowable.bpm.service.impl;

import cn.hutool.core.util.IdUtil;
import com.j2eefast.common.core.utils.ResponseData;
import com.j2eefast.flowable.bpm.entity.CommentEntity;
import com.j2eefast.flowable.bpm.entity.CompleteTaskEntity;
import com.j2eefast.flowable.bpm.enums.CommentTypeEnum;
import com.j2eefast.flowable.bpm.mapper.ProcessInstanceMapper;
import com.j2eefast.flowable.bpm.service.FlowableActinstService;
import com.j2eefast.flowable.bpm.service.FlowableCommentService;
import com.j2eefast.flowable.bpm.service.IFlowableBpmnModelService;
import com.j2eefast.flowable.bpm.utils.FlowableUtils;
import org.flowable.bpmn.model.EndEvent;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.Process;
import org.flowable.bpmn.model.UserTask;
import org.flowable.common.engine.api.FlowableException;
import org.flowable.common.engine.api.FlowableObjectNotFoundException;
import org.flowable.engine.*;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ActivityInstance;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.service.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.flowable.engine.impl.persistence.entity.ActivityInstanceEntity;
import org.flowable.editor.language.json.converter.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public abstract class BaseProcessService {

	@Autowired
	@Lazy(value = true)
	protected RepositoryService repositoryService;
	@Autowired
	@Lazy(value = true)
	protected ManagementService managementService;
	@Autowired
	@Lazy(value = true)
	protected IdentityService identityService;
	@Autowired
	@Lazy(value = true)
	protected RuntimeService runtimeService;
	@Autowired
	@Lazy(value = true)
	protected HistoryService historyService;
	@Autowired
	@Lazy(value = true)
	protected FlowableCommentService flowableCommentService;
	@Autowired
	protected TaskService taskService;

	@Resource
	protected ProcessInstanceMapper processInstanceMapper;
	@Resource
	protected FlowableActinstService flowableActinstService;

	@Autowired
	@Lazy(value = true)
	protected IFlowableBpmnModelService flowableBpmnModelService;



//	@Autowired
//	protected IHisFlowableActinstMapper hisFlowableActinstMapper;
//	@Autowired
//	protected IRunFlowableActinstMapper runFlowableActinstMapper;

	/**
	 * 添加审批意见
	 *
	 * @param taskId            任务id
	 * @param userCode          处理人工号
	 * @param processInstanceId 流程实例id
	 * @param type              审批类型
	 * @param message           审批意见
	 */
	protected void addComment(String taskId, String userCode, String processInstanceId, String type, String message) {
		//1.添加备注
		CommentEntity commentVo = new CommentEntity(taskId, userCode, processInstanceId, type, message);
		flowableCommentService.addComment(commentVo);
		//TODO 2.修改扩展的流程实例表的状态以备查询待办的时候能带出来状态
		//TODO 3.发送mongodb的数据到消息队列里面
	}


	/**
	 * 添加审批意见
	 *
	 * @param userCode          处理人工号
	 * @param processInstanceId 流程实例id
	 * @param type              审批类型
	 * @param message           审批意见
	 */
	protected void addComment(String userCode, String processInstanceId, String type, String message) {
		this.addComment(null, userCode, processInstanceId, type, message);
	}

	protected TaskEntity createSubTask(TaskEntity ptask, String assignee) {
		return this.createSubTask(ptask, ptask.getId(), assignee);
	}



	/**
	 * 删除跳转的历史节点信息
	 *
	 * @param disActivityId     跳转的节点id
	 * @param processInstanceId 流程实例id
	 */
	protected void deleteActivity(String disActivityId, String processInstanceId) {
		String tableName = managementService.getTableName(ActivityInstanceEntity.class);
		String sql = "select t.* from " + tableName + " t where t.PROC_INST_ID_=#{processInstanceId} and t.ACT_ID_ = #{disActivityId} " +
				" order by t.END_TIME_ ASC";
		List<ActivityInstance> disActivities = runtimeService.createNativeActivityInstanceQuery().sql(sql)
				.parameter("processInstanceId", processInstanceId)
				.parameter("disActivityId", disActivityId).list();
		//删除运行时和历史节点信息
		if (CollectionUtils.isNotEmpty(disActivities)) {
			ActivityInstance activityInstance = disActivities.get(0);
			sql = "select t.* from " + tableName + " t where t.PROC_INST_ID_=#{processInstanceId} and (t.END_TIME_ >= #{endTime} or t.END_TIME_ is null)";
			List<ActivityInstance> datas = runtimeService.createNativeActivityInstanceQuery().sql(sql).parameter("processInstanceId", processInstanceId)
					.parameter("endTime", activityInstance.getEndTime()).list();
			List<String> runActivityIds = new ArrayList<>();
			if (CollectionUtils.isNotEmpty(datas)) {
				datas.forEach(ai -> runActivityIds.add(ai.getId()));
				flowableActinstService.deleteRunActinstsByIds(runActivityIds);
				flowableActinstService.deleteHisActinstsByIds(runActivityIds);
			}
		}
	}

	/**
	 * 执行跳转
	 */
	protected void moveExecutionsToSingleActivityId(List<String> executionIds, String activityId) {
		runtimeService.createChangeActivityStateBuilder()
				.moveExecutionsToSingleActivityId(executionIds, activityId)
				.changeState();
	}

	/**
	 * 创建子任务
	 *
	 * @param ptask    创建子任务
	 * @param assignee 子任务的执行人
	 * @return
	 */
	protected TaskEntity createSubTask(TaskEntity ptask, String ptaskId, String assignee) {
		TaskEntity task = null;
		if (ptask != null) {
			//1.生成子任务
			task = (TaskEntity) taskService.newTask(IdUtil.simpleUUID());
			task.setCategory(ptask.getCategory());
			task.setDescription(ptask.getDescription());
			task.setTenantId(ptask.getTenantId());
			task.setAssignee(assignee);
			task.setName(ptask.getName());
			task.setParentTaskId(ptaskId);
			task.setProcessDefinitionId(ptask.getProcessDefinitionId());
			task.setProcessInstanceId(ptask.getProcessInstanceId());
			task.setTaskDefinitionKey(ptask.getTaskDefinitionKey());
			task.setTaskDefinitionId(ptask.getTaskDefinitionId());
			task.setPriority(ptask.getPriority());
			task.setCreateTime(new Date());
			taskService.saveTask(task);
		}
		return task;
	}

	/**
	 * 任务驳回
	 * @param params
	 * @return
	 */
	protected ResponseData flowTackback(CompleteTaskEntity params) {
		//Task task=taskService.createTaskQuery().processInstanceId(taskId).active().singleResult();
		if (taskService.createTaskQuery().taskId(params.getTaskId()).singleResult().isSuspended()) {
			return ResponseData.error("任务处于挂起状态");
		}
//		// 当前任务 task
		Task task = taskService.createTaskQuery().taskId(params.getTaskId()).singleResult();
		// 获取流程定义信息
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(task.getProcessDefinitionId()).singleResult();
		// 获取所有节点信息
		Process process = repositoryService.getBpmnModel(processDefinition.getId()).getProcesses().get(0);
		// 获取全部节点列表，包含子节点
		Collection<FlowElement> allElements = FlowableUtils.getAllElements(process.getFlowElements(), null);
		// 获取当前任务节点元素
		FlowElement source = null;
		if (allElements != null) {
			for (FlowElement flowElement : allElements) {
				// 类型为用户节点
				if (flowElement.getId().equals(task.getTaskDefinitionKey())) {
					// 获取节点信息
					source = flowElement;
				}
			}
		}


		// 目的获取所有跳转到的节点 targetIds
		// 获取当前节点的所有父级用户任务节点
		// 深度优先算法思想：延边迭代深入
		List<UserTask> parentUserTaskList = FlowableUtils.iteratorFindParentUserTasks(source, null, null);
		if (parentUserTaskList == null || parentUserTaskList.size() == 0) {
			return ResponseData.error("当前节点为初始任务节点，不能驳回");
		}
		// 获取活动 ID 即节点 Key
		List<String> parentUserTaskKeyList = new ArrayList<>();
		parentUserTaskList.forEach(item -> parentUserTaskKeyList.add(item.getId()));
		// 获取全部历史节点活动实例，即已经走过的节点历史，数据采用开始时间升序
		List<HistoricTaskInstance> historicTaskInstanceList = historyService.createHistoricTaskInstanceQuery().processInstanceId(task.getProcessInstanceId()).orderByHistoricTaskInstanceStartTime().asc().list();
		// 数据清洗，将回滚导致的脏数据清洗掉
		List<String> lastHistoricTaskInstanceList = FlowableUtils.historicTaskInstanceClean(allElements, historicTaskInstanceList);
		// 此时历史任务实例为倒序，获取最后走的节点
		List<String> targetIds = new ArrayList<>();
		// 循环结束标识，遇到当前目标节点的次数
		int number = 0;
		StringBuilder parentHistoricTaskKey = new StringBuilder();
		for (String historicTaskInstanceKey : lastHistoricTaskInstanceList) {
			// 当会签时候会出现特殊的，连续都是同一个节点历史数据的情况，这种时候跳过
			if (parentHistoricTaskKey.toString().equals(historicTaskInstanceKey)) {
				continue;
			}
			parentHistoricTaskKey = new StringBuilder(historicTaskInstanceKey);
			if (historicTaskInstanceKey.equals(task.getTaskDefinitionKey())) {
				number++;
			}
			// 在数据清洗后，历史节点就是唯一一条从起始到当前节点的历史记录，理论上每个点只会出现一次
			// 在流程中如果出现循环，那么每次循环中间的点也只会出现一次，再出现就是下次循环
			// number == 1，第一次遇到当前节点
			// number == 2，第二次遇到，代表最后一次的循环范围
			if (number == 2) {
				break;
			}
			// 如果当前历史节点，属于父级的节点，说明最后一次经过了这个点，需要退回这个点
			if (parentUserTaskKeyList.contains(historicTaskInstanceKey)) {
				targetIds.add(historicTaskInstanceKey);
			}
		}


		// 目的获取所有需要被跳转的节点 currentIds
		// 取其中一个父级任务，因为后续要么存在公共网关，要么就是串行公共线路
		UserTask oneUserTask = parentUserTaskList.get(0);
		// 获取所有正常进行的任务节点 Key，这些任务不能直接使用，需要找出其中需要撤回的任务
		List<Task> runTaskList = taskService.createTaskQuery().processInstanceId(task.getProcessInstanceId()).list();
		List<String> runTaskKeyList = new ArrayList<>();
		runTaskList.forEach(item -> runTaskKeyList.add(item.getTaskDefinitionKey()));
		// 需驳回任务列表
		List<String> currentIds = new ArrayList<>();
		// 通过父级网关的出口连线，结合 runTaskList 比对，获取需要撤回的任务
		List<UserTask> currentUserTaskList = FlowableUtils.iteratorFindChildUserTasks(oneUserTask, runTaskKeyList, null, null);
		currentUserTaskList.forEach(item -> currentIds.add(item.getId()));


		// 规定：并行网关之前节点必须需存在唯一用户任务节点，如果出现多个任务节点，则并行网关节点默认为结束节点，原因为不考虑多对多情况
		if (targetIds.size() > 1 && currentIds.size() > 1) {
			return ResponseData.error("任务出现多对多情况，无法撤回");
		}

		// 循环获取那些需要被撤回的节点的ID，用来设置驳回原因
		List<String> currentTaskIds = new ArrayList<>();
		currentIds.forEach(currentId -> runTaskList.forEach(runTask -> {
			if (currentId.equals(runTask.getTaskDefinitionKey())) {
				currentTaskIds.add(runTask.getId());
			}
		}));
		// 设置驳回信息
		currentTaskIds.forEach(item -> {
			this.addComment(item, params.getUserId(), params.getProcessInstanceId(), params.getType(), params.getMessage());
			//taskService.addComment(item, task.getProcessInstanceId(), "taskComment", params.getMessage());
		});

		try {
			// 如果父级任务多于 1 个，说明当前节点不是并行节点，原因为不考虑多对多情况
			if (targetIds.size() > 1) {
				// 1 对 多任务跳转，currentIds 当前节点(1)，targetIds 跳转到的节点(多)
				runtimeService.createChangeActivityStateBuilder().processInstanceId(task.getProcessInstanceId()).moveSingleActivityIdToActivityIds(currentIds.get(0), targetIds).changeState();
			}
			// 如果父级任务只有一个，因此当前任务可能为网关中的任务
			if (targetIds.size() == 1) {
				// 1 对 1 或 多 对 1 情况，currentIds 当前要跳转的节点列表(1或多)，targetIds.get(0) 跳转到的节点(1)
				runtimeService.createChangeActivityStateBuilder().processInstanceId(task.getProcessInstanceId()).moveActivityIdsToSingleActivityId(currentIds, targetIds.get(0)).changeState();
			}
		} catch (FlowableObjectNotFoundException e) {
			return ResponseData.error("未找到流程实例，流程可能已发生变化");
		} catch (FlowableException e) {
			return ResponseData.error("无法取消或开始活动");
		}
		return ResponseData.success();
	}

	/**
	 * 流程终止
	 * @param params
	 * @return
	 */
	public ResponseData stopProcessInstanceById(CompleteTaskEntity params) {
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(params.getProcessInstanceId()).singleResult();
		if (processInstance != null) {
			//1、添加审批记录
			this.addComment(params.getTaskId(), params.getUserId(), params.getProcessInstanceId(), CommentTypeEnum.LCZZ.toString(), params.getMessage());
//			this.addComment(params.getUserId(), params.getProcessInstanceId(), CommentTypeEnum.LCZZ.toString(),
//					params.getMessage());
			List<EndEvent> endNodes = flowableBpmnModelService.findEndFlowElement(processInstance.getProcessDefinitionId());
			String endId = endNodes.get(0).getId();
			String processInstanceId = params.getProcessInstanceId();
			//2、执行终止
			List<Execution> executions = runtimeService.createExecutionQuery().parentId(processInstanceId).list();
			List<String> executionIds = new ArrayList<>();
			executions.forEach(execution -> executionIds.add(execution.getId()));
			this.moveExecutionsToSingleActivityId(executionIds, endId);
			return ResponseData.success("终止成功");
		}else {
			return ResponseData.error("不存在运行的流程实例,请确认!");
		}
	}



}
