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
import com.j2eefast.flowable.bpm.entity.bpmCrmPreparationEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmPreparationService;

/**
 * 整备页面控制器
 * @author yhli
 * @date 2020-06-23 11:26
 */
@Controller
@RequestMapping("/bpm/preparation")
public class bpmCrmPreparationController extends BaseController{

    private String prefix = "modules/bpm/preparation";
    @Autowired
    private bpmCrmPreparationService bpmCrmPreparationService;

    @RequiresPermissions("bpm:preparation:view")
    @GetMapping()
    public String preparation(){
        return prefix + "/preparation";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:preparation:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmPreparationService.findPage(params);
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
    @RequiresPermissions("bpm:preparation:add")
    @BussinessLog(title = "整备", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmPreparation(@Validated bpmCrmPreparationEntity bpmCrmPreparation){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmPreparation);
        return bpmCrmPreparationService.savebpmCrmPreparation(bpmCrmPreparation)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:preparation:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmPreparationEntity bpmCrmPreparation = bpmCrmPreparationService.getbpmCrmPreparationById(id);
        mmap.put("bpmCrmPreparation", bpmCrmPreparation);
        return prefix + "/edit";
    }

    /**
     * 修改保存整备
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:preparation:edit")
    @BussinessLog(title = "整备", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmPreparation(bpmCrmPreparationEntity bpmCrmPreparation){
		ValidatorUtil.validateEntity(bpmCrmPreparation);
        return bpmCrmPreparationService.updatebpmCrmPreparationById(bpmCrmPreparation)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "整备", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:preparation:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmPreparationService.deletebpmCrmPreparationByIds(ids)? success(): error("删除失败!");
    }    
}
