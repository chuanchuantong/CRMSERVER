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
import com.j2eefast.flowable.bpm.entity.bpmCrmMaintenanceEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmMaintenanceService;

/**
 * 维修页面控制器
 * @author yhli
 * @date 2020-06-23 11:51
 */
@Controller
@RequestMapping("/bpm/maintenance")
public class bpmCrmMaintenanceController extends BaseController{

    private String prefix = "modules/bpm/maintenance";
    @Autowired
    private bpmCrmMaintenanceService bpmCrmMaintenanceService;

    @RequiresPermissions("bpm:maintenance:view")
    @GetMapping()
    public String maintenance(){
        return prefix + "/maintenance";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:maintenance:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmMaintenanceService.findPage(params);
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
    @RequiresPermissions("bpm:maintenance:add")
    @BussinessLog(title = "维修", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmMaintenance(@Validated bpmCrmMaintenanceEntity bpmCrmMaintenance){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmMaintenance);
        return bpmCrmMaintenanceService.savebpmCrmMaintenance(bpmCrmMaintenance)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:maintenance:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmMaintenanceEntity bpmCrmMaintenance = bpmCrmMaintenanceService.getbpmCrmMaintenanceById(id);
        mmap.put("bpmCrmMaintenance", bpmCrmMaintenance);
        return prefix + "/edit";
    }

    /**
     * 修改保存维修
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:maintenance:edit")
    @BussinessLog(title = "维修", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmMaintenance(bpmCrmMaintenanceEntity bpmCrmMaintenance){
		ValidatorUtil.validateEntity(bpmCrmMaintenance);
        return bpmCrmMaintenanceService.updatebpmCrmMaintenanceById(bpmCrmMaintenance)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "维修", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:maintenance:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmMaintenanceService.deletebpmCrmMaintenanceByIds(ids)? success(): error("删除失败!");
    }    
}
