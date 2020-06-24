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
import com.j2eefast.flowable.bpm.entity.bpmCrmApplyoutlibraryEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmApplyoutlibraryService;

/**
 * 申请出库页面控制器
 * @author yhli
 * @date 2020-06-23 14:05
 */
@Controller
@RequestMapping("/bpm/applyoutlibrary")
public class bpmCrmApplyoutlibraryController extends BaseController{

    private String prefix = "modules/bpm/applyoutlibrary";
    @Autowired
    private bpmCrmApplyoutlibraryService bpmCrmApplyoutlibraryService;

    @RequiresPermissions("bpm:applyoutlibrary:view")
    @GetMapping()
    public String applyoutlibrary(){
        return prefix + "/applyoutlibrary";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:applyoutlibrary:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmApplyoutlibraryService.findPage(params);
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
    @RequiresPermissions("bpm:applyoutlibrary:add")
    @BussinessLog(title = "申请出库", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmApplyoutlibrary(@Validated bpmCrmApplyoutlibraryEntity bpmCrmApplyoutlibrary){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmApplyoutlibrary);
        return bpmCrmApplyoutlibraryService.savebpmCrmApplyoutlibrary(bpmCrmApplyoutlibrary)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:applyoutlibrary:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmApplyoutlibraryEntity bpmCrmApplyoutlibrary = bpmCrmApplyoutlibraryService.getbpmCrmApplyoutlibraryById(id);
        mmap.put("bpmCrmApplyoutlibrary", bpmCrmApplyoutlibrary);
        return prefix + "/edit";
    }

    /**
     * 修改保存申请出库
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:applyoutlibrary:edit")
    @BussinessLog(title = "申请出库", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmApplyoutlibrary(bpmCrmApplyoutlibraryEntity bpmCrmApplyoutlibrary){
		ValidatorUtil.validateEntity(bpmCrmApplyoutlibrary);
        return bpmCrmApplyoutlibraryService.updatebpmCrmApplyoutlibraryById(bpmCrmApplyoutlibrary)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "申请出库", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:applyoutlibrary:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmApplyoutlibraryService.deletebpmCrmApplyoutlibraryByIds(ids)? success(): error("删除失败!");
    }    
}
