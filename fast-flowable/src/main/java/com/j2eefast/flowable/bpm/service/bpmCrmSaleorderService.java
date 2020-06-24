package com.j2eefast.flowable.bpm.service;

import cn.hutool.core.util.IdUtil;
import com.j2eefast.common.core.utils.ResponseData;
import com.j2eefast.flowable.bpm.entity.*;
import com.j2eefast.flowable.bpm.mapper.bpmCrmSaleorderMapper;
import com.j2eefast.common.core.page.Query;
import com.j2eefast.common.core.utils.PageUtil;
import com.j2eefast.common.core.utils.ToolUtil;
import com.j2eefast.framework.utils.Constant;
import com.j2eefast.framework.utils.UserUtils;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 * 创建申请单Service接口
 *
 * @author: yhli
 * @date 2020-06-15 16:42
 */
@Service
public class bpmCrmSaleorderService extends ServiceImpl<bpmCrmSaleorderMapper, bpmCrmSaleorderEntity> {

    @Resource
    private bpmCrmSaleorderMapper bpmCrmSaleorderMapper;
    @Autowired
    private FlowableProcessInstanceService flowableProcessInstanceService;

    @Autowired
    private FlowableCommentService flowableCommentService;

    @Resource
    @Lazy
    private bpmCrmSaleorderService bpmCrmSaleorderService;

    /**
     * 页面分页查询
     */
    public PageUtil findPage(Map<String, Object> params) {
        QueryWrapper<bpmCrmSaleorderEntity> r = new QueryWrapper<bpmCrmSaleorderEntity>();
        String processInstanceId = (String) params.get("processInstanceId");
        r.eq(ToolUtil.isNotEmpty(processInstanceId), "process_instance_id", processInstanceId);
        String saleCode = (String) params.get("saleCode");
        r.eq(ToolUtil.isNotEmpty(saleCode), "sale_code", saleCode);
        String saleStatus = (String) params.get("saleStatus");
        r.eq(ToolUtil.isNotEmpty(saleStatus), "sale_status", saleStatus);
        String saleCustomername = (String) params.get("saleCustomername");
        r.like(ToolUtil.isNotEmpty(saleCustomername), "sale_customername", saleCustomername);
        String saleAddress = (String) params.get("saleAddress");
        r.eq(ToolUtil.isNotEmpty(saleAddress), "sale_address", saleAddress);
        String salePhone = (String) params.get("salePhone");
        r.eq(ToolUtil.isNotEmpty(salePhone), "sale_phone", salePhone);
        String saleEmail = (String) params.get("saleEmail");
        r.eq(ToolUtil.isNotEmpty(saleEmail), "sale_email", saleEmail);
        String saleWechat = (String) params.get("saleWechat");
        r.eq(ToolUtil.isNotEmpty(saleWechat), "sale_wechat", saleWechat);
        String saleId = (String) params.get("saleId");
        r.eq(ToolUtil.isNotEmpty(saleId), "sale_id", saleId);
        String saleDriverlicense = (String) params.get("saleDriverlicense");
        r.eq(ToolUtil.isNotEmpty(saleDriverlicense), "sale_driverlicense", saleDriverlicense);
        String salePassport = (String) params.get("salePassport");
        r.eq(ToolUtil.isNotEmpty(salePassport), "sale_passport", salePassport);
        String saleResidenceinfo = (String) params.get("saleResidenceinfo");
        r.eq(ToolUtil.isNotEmpty(saleResidenceinfo), "sale_residenceinfo", saleResidenceinfo);
        String salePerson = (String) params.get("salePerson");
        r.eq(ToolUtil.isNotEmpty(salePerson), "sale_person", salePerson);
        String saleTeam = (String) params.get("saleTeam");
        r.eq(ToolUtil.isNotEmpty(saleTeam), "sale_team", saleTeam);
        String saleManager = (String) params.get("saleManager");
        r.eq(ToolUtil.isNotEmpty(saleManager), "sale_manager", saleManager);
        String userId = (String) params.get("userId");
        r.eq(ToolUtil.isNotEmpty(userId), "user_id", userId);
        //Page<bpmCrmSaleorderEntity> page = this.baseMapper.selectPage(new Query<bpmCrmSaleorderEntity>(params).getPage(), r);
        Page<BpmCrmFindListEntity> page = bpmCrmSaleorderMapper.findPage(new Query<bpmCrmSaleorderEntity>(params).getPage(),(String) params.get(Constant.SQL_FILTER));
        return new PageUtil(page);
    }

    /**
     * 保存
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseData savebpmCrmSaleorder(bpmCrmSaleorderEntity bpmCrmSaleorder) {

        bpmCrmSaleorder.setId(IdUtil.fastSimpleUUID());
        StartProcessInstanceEntity startProcessInstanceVo = new StartProcessInstanceEntity();
        startProcessInstanceVo.setBusinessKey(bpmCrmSaleorder.getId());
        startProcessInstanceVo.setCreator(String.valueOf(UserUtils.getUserId()));
        startProcessInstanceVo.setCurrentUserCode(String.valueOf(UserUtils.getUserId()));
        startProcessInstanceVo.setFormName(bpmCrmSaleorder.getFromName());
        startProcessInstanceVo.setSystemSn("system");
        startProcessInstanceVo.setProcessDefinitionKey(bpmCrmSaleorder.getModelKey());
        Map<String, Object> variables = new HashMap<>();
//		variables.put("leaveDays", bpmCrmSaleorder.getLeaveDays());
        startProcessInstanceVo.setVariables(variables);
        ResponseData returnStart = flowableProcessInstanceService.startProcessInstanceByKey(startProcessInstanceVo);
        if (returnStart.get("code").equals("00000")) {
            String processInstanceId = ((ProcessInstance) returnStart.get("data")).getProcessInstanceId();
            CommentEntity commentEntity = new CommentEntity();
            commentEntity.setTaskId(processInstanceId);
            commentEntity.setUserId(String.valueOf(UserUtils.getUserId()));
            commentEntity.setUserName(bpmCrmSaleorder.getFromName());
            commentEntity.setType("1");
            commentEntity.setMessage("测试意见");
            flowableCommentService.addComment(commentEntity);
            bpmCrmSaleorder.setProcessInstanceId(processInstanceId);
            return bpmCrmSaleorderService.add(bpmCrmSaleorder) ? ResponseData.success() : ResponseData.error("数据插入失败!");
        } else {
            return returnStart;
        }
    }

    /**
     * 批量删除
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean deletebpmCrmSaleorderByIds(String[] ids) {
        return this.removeByIds(Arrays.asList(ids));
    }

    /**
     * 单个删除
     */
    public boolean deletebpmCrmSaleorderById(String id) {
        return this.removeById(id);
    }

    /**
     * 保存
     */
    public boolean add(bpmCrmSaleorderEntity bpmCrmSaleorder) {
        return this.save(bpmCrmSaleorder);
    }

    /**
     * 修改根居ID
     */
    public boolean updatebpmCrmSaleorderById(bpmCrmSaleorderEntity bpmCrmSaleorder) {
        return this.updateById(bpmCrmSaleorder);
    }

    /**
     * 根居ID获取对象
     */
    public bpmCrmSaleorderEntity getbpmCrmSaleorderById(String id) {
        return this.getById(id);
    }
}
