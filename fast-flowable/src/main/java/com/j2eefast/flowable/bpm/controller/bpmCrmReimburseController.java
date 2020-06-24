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
import com.j2eefast.flowable.bpm.entity.bpmCrmReimburseEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmReimburseService;

/**
 * 报销页面控制器
 * @author yhli
 * @date 2020-06-22 14:13
 */
@Controller
@RequestMapping("/bpm/reimburse")
public class bpmCrmReimburseController extends BaseController{

    private String prefix = "modules/bpm/reimburse";
    @Autowired
    private bpmCrmReimburseService bpmCrmReimburseService;

    @RequiresPermissions("bpm:reimburse:view")
    @GetMapping()
    public String reimburse(){
        return prefix + "/reimburse";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:reimburse:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmReimburseService.findPage(params);
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
    @RequiresPermissions("bpm:reimburse:add")
    @BussinessLog(title = "报销", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmReimburse(@Validated bpmCrmReimburseEntity bpmCrmReimburse){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmReimburse);
        return bpmCrmReimburseService.savebpmCrmReimburse(bpmCrmReimburse)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:reimburse:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmReimburseEntity bpmCrmReimburse = bpmCrmReimburseService.getbpmCrmReimburseById(id);
        mmap.put("bpmCrmReimburse", bpmCrmReimburse);
        return prefix + "/edit";
    }

    /**
     * 修改保存报销
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:reimburse:edit")
    @BussinessLog(title = "报销", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmReimburse(bpmCrmReimburseEntity bpmCrmReimburse){
		ValidatorUtil.validateEntity(bpmCrmReimburse);
        return bpmCrmReimburseService.updatebpmCrmReimburseById(bpmCrmReimburse)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "报销", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:reimburse:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmReimburseService.deletebpmCrmReimburseByIds(ids)? success(): error("删除失败!");
    }    
}
