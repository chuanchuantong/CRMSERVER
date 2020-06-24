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
import com.j2eefast.flowable.bpm.entity.bpmCrmPurchaseEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmPurchaseService;

/**
 * 采购订单页面控制器
 * @author yhli
 * @date 2020-06-19 13:29
 */
@Controller
@RequestMapping("/bpm/purchase")
public class bpmCrmPurchaseController extends BaseController{

    private String prefix = "modules/bpm/purchase";
    @Autowired
    private bpmCrmPurchaseService bpmCrmPurchaseService;

    @RequiresPermissions("bpm:purchase:view")
    @GetMapping()
    public String purchase(){
        return prefix + "/purchase";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:purchase:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmPurchaseService.findPage(params);
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
    @RequiresPermissions("bpm:purchase:add")
    @BussinessLog(title = "采购订单", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmPurchase(@Validated bpmCrmPurchaseEntity bpmCrmPurchase){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmPurchase);
        return bpmCrmPurchaseService.savebpmCrmPurchase(bpmCrmPurchase)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:purchase:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmPurchaseEntity bpmCrmPurchase = bpmCrmPurchaseService.getbpmCrmPurchaseById(id);
        mmap.put("bpmCrmPurchase", bpmCrmPurchase);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购订单
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:purchase:edit")
    @BussinessLog(title = "采购订单", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmPurchase(bpmCrmPurchaseEntity bpmCrmPurchase){
		ValidatorUtil.validateEntity(bpmCrmPurchase);
        return bpmCrmPurchaseService.updatebpmCrmPurchaseById(bpmCrmPurchase)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "采购订单", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:purchase:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmPurchaseService.deletebpmCrmPurchaseByIds(ids)? success(): error("删除失败!");
    }    
}
