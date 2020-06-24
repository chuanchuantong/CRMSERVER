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
import com.j2eefast.flowable.bpm.entity.bpmCrmSubstitutionEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmSubstitutionService;

/**
 * 置换信息表页面控制器
 * @author yhli
 * @date 2020-06-22 10:42
 */
@Controller
@RequestMapping("/bpm/substitution")
public class bpmCrmSubstitutionController extends BaseController{

    private String prefix = "modules/bpm/substitution";
    @Autowired
    private bpmCrmSubstitutionService bpmCrmSubstitutionService;

    @RequiresPermissions("bpm:substitution:view")
    @GetMapping()
    public String substitution(){
        return prefix + "/substitution";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:substitution:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmSubstitutionService.findPage(params);
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
    @RequiresPermissions("bpm:substitution:add")
    @BussinessLog(title = "置换信息表", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmSubstitution(@Validated bpmCrmSubstitutionEntity bpmCrmSubstitution){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmSubstitution);
        return bpmCrmSubstitutionService.savebpmCrmSubstitution(bpmCrmSubstitution)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:substitution:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmSubstitutionEntity bpmCrmSubstitution = bpmCrmSubstitutionService.getbpmCrmSubstitutionById(id);
        mmap.put("bpmCrmSubstitution", bpmCrmSubstitution);
        return prefix + "/edit";
    }

    /**
     * 修改保存置换信息表
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:substitution:edit")
    @BussinessLog(title = "置换信息表", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmSubstitution(bpmCrmSubstitutionEntity bpmCrmSubstitution){
		ValidatorUtil.validateEntity(bpmCrmSubstitution);
        return bpmCrmSubstitutionService.updatebpmCrmSubstitutionById(bpmCrmSubstitution)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "置换信息表", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:substitution:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmSubstitutionService.deletebpmCrmSubstitutionByIds(ids)? success(): error("删除失败!");
    }    
}
