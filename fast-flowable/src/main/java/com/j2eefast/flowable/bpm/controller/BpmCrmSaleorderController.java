package com.j2eefast.flowable.bpm.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.j2eefast.common.core.business.annotaion.BussinessLog;
import com.j2eefast.common.core.enums.BusinessType;
import com.j2eefast.common.core.utils.*;
import com.j2eefast.flowable.bpm.entity.BpmOaFormEntity;
import com.j2eefast.flowable.bpm.entity.BpmTaskFromEntity;
import com.j2eefast.flowable.bpm.enums.CommentOSSType;
import com.j2eefast.flowable.bpm.service.BpmTaskFromService;
import com.j2eefast.flowable.bpm.utils.CommontOSSUtils;
import com.j2eefast.framework.annotation.RepeatSubmit;
import com.j2eefast.common.core.controller.BaseController;
import com.j2eefast.framework.utils.UserUtils;
import com.j2eefast.system.oss.entity.SysOssEntity;
import com.j2eefast.system.oss.service.SysOssService;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.ui.ModelMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import org.springframework.web.bind.annotation.*;
import com.j2eefast.flowable.bpm.entity.bpmCrmSaleorderEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmSaleorderService;

/**
 * 创建申请单页面控制器
 * @author yhli
 * @date 2020-06-15 16:42
 */
@Controller
@RequestMapping("/bpm/sale")
@Api(tags = "订单管理")
public class BpmCrmSaleorderController extends BaseController{

    /**
     * 必须注入实例关联表单服务
     */
    @Autowired
    private BpmTaskFromService bpmTaskFromService;
    private String prefix = "modules/bpm/sale";
    @Autowired
    private bpmCrmSaleorderService bpmCrmSaleorderService;

    @Autowired
    @Lazy(value = true)
    private CommontOSSUtils commontOSSUtils;

    @RequiresPermissions("bpm:sale:view")
    @GetMapping()
    public String sale(){
        return prefix + "/sale";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:sale:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmSaleorderService.findPage(params);
		return success(page);
    }

    /**
     * 表单详情
     * @param taskId
     * @param businessKey
     * @param mmap
     * @return
     */
    @GetMapping("/view")
    public String view(@RequestParam(value="taskId", required=true)String taskId,
                       @RequestParam(value="businessKey", required=true)String businessKey,
                       ModelMap mmap){
        bpmCrmSaleorderEntity bpmCrmSaleorderEntity = bpmCrmSaleorderService.getbpmCrmSaleorderById(businessKey);
        mmap.put("bpmCrmSaleorder", bpmCrmSaleorderEntity);
        mmap.put("taskId", taskId);
        return prefix + "/view";
    }

    /**
     * 定义关联表单申请表单URL对应此处
     */
    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long id, ModelMap mmp){
        //通过页面传入的表单ID查询表单关联信息
        BpmTaskFromEntity bpmTaskFrom = bpmTaskFromService.getTaskFromById(id);
        mmp.put("bpmTaskFrom", bpmTaskFrom);
        mmp.put("user", UserUtils.getUserInfo());
        mmp.put("saleCode",OrderCodeFactory.getOrderCode(UserUtils.getUserId()));
        return prefix + "/add";
    }

    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    /**
     * 新增
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:sale:add")
    @BussinessLog(title = "创建申请单", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmSaleorder(@Validated bpmCrmSaleorderEntity bpmCrmSaleorder){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmSaleorder);
        return bpmCrmSaleorderService.savebpmCrmSaleorder(bpmCrmSaleorder);
    }    
    
//    /**
//     * 修改
//     */
//    @RequiresPermissions("bpm:sale:edit")
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") String id, ModelMap mmap){
//        bpmCrmSaleorderEntity bpmCrmSaleorder = bpmCrmSaleorderService.getbpmCrmSaleorderById(id);
//        mmap.put("bpmCrmSaleorder", bpmCrmSaleorder);
//        return prefix + "/edit";
//    }

    /**
     * 修改保存创建申请单
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:sale:edit")
    @BussinessLog(title = "创建申请单", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmSaleorder(bpmCrmSaleorderEntity bpmCrmSaleorder){
		ValidatorUtil.validateEntity(bpmCrmSaleorder);
        return bpmCrmSaleorderService.updatebpmCrmSaleorderById(bpmCrmSaleorder)? success(): error("修改失败!");
    }

    @GetMapping("/edit")
    public String editBpmForm(@RequestParam(value="taskId", required=true)String taskId,
                       @RequestParam(value="businessKey", required=true)String businessKey,
                       ModelMap mmap){
        bpmCrmSaleorderEntity bpmForm = bpmCrmSaleorderService.getbpmCrmSaleorderById(businessKey);
        mmap.put("bpmCrmSaleorder", bpmForm);
        mmap.put("taskId", taskId);
        List<SysOssEntity> dlList = commontOSSUtils.selectListByType(CommentOSSType.DL.getName(),bpmForm.getSaleCode());
        List<SysOssEntity> PPList = commontOSSUtils.selectListByType(CommentOSSType.PP.getName(),bpmForm.getSaleCode());
        mmap.put("dllist",dlList);
        mmap.put("pplist",PPList);
        return prefix + "/edit";
    }

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "创建申请单", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:sale:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmSaleorderService.deletebpmCrmSaleorderByIds(ids)? success(): error("删除失败!");
    }    
}
