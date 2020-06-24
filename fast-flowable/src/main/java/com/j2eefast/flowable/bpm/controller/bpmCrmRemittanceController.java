package com.j2eefast.flowable.bpm.controller;

import com.j2eefast.common.core.business.annotaion.BussinessLog;
import com.j2eefast.common.core.enums.BusinessType;
import com.j2eefast.common.core.utils.*;
import com.j2eefast.framework.annotation.RepeatSubmit;
import com.j2eefast.common.core.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.ui.ModelMap;
import java.util.Map;
import java.util.Date;
import org.springframework.web.bind.annotation.*;
import com.j2eefast.flowable.bpm.entity.bpmCrmRemittanceEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmRemittanceService;

/**
 * 汇款信息页面控制器
 * @author yhli
 * @date 2020-06-22 13:38
 */
@Controller
@RequestMapping("/bpm/remittance")
public class bpmCrmRemittanceController extends BaseController{

    private String prefix = "modules/bpm/remittance";
    @Autowired
    private bpmCrmRemittanceService bpmCrmRemittanceService;

    @RequiresPermissions("bpm:remittance:view")
    @GetMapping()
    public String remittance(){
        return prefix + "/remittance";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:remittance:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmRemittanceService.findPage(params);
		return success(page);
    }    
            
    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    /**
     * 新增
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:remittance:add")
    @BussinessLog(title = "汇款信息", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmRemittance(@Validated bpmCrmRemittanceEntity bpmCrmRemittance){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmRemittance);
        return bpmCrmRemittanceService.savebpmCrmRemittance(bpmCrmRemittance)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:remittance:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmRemittanceEntity bpmCrmRemittance = bpmCrmRemittanceService.getbpmCrmRemittanceById(id);
        mmap.put("bpmCrmRemittance", bpmCrmRemittance);
        return prefix + "/edit";
    }

    /**
     * 修改保存汇款信息
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:remittance:edit")
    @BussinessLog(title = "汇款信息", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmRemittance(bpmCrmRemittanceEntity bpmCrmRemittance){
		ValidatorUtil.validateEntity(bpmCrmRemittance);
        return bpmCrmRemittanceService.updatebpmCrmRemittanceById(bpmCrmRemittance)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "汇款信息", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:remittance:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmRemittanceService.deletebpmCrmRemittanceByIds(ids)? success(): error("删除失败!");
    }    
}
