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
import com.j2eefast.flowable.bpm.entity.bpmCrmCollectionmoneyEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmCollectionmoneyService;

/**
 * 收款信息页面控制器
 * @author yhli
 * @date 2020-06-22 11:36
 */
@Controller
@RequestMapping("/bpm/collectionmoney")
public class bpmCrmCollectionmoneyController extends BaseController{

    private String prefix = "modules/bpm/collectionmoney";
    @Autowired
    private bpmCrmCollectionmoneyService bpmCrmCollectionmoneyService;

    @RequiresPermissions("bpm:collectionmoney:view")
    @GetMapping()
    public String collectionmoney(){
        return prefix + "/collectionmoney";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:collectionmoney:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmCollectionmoneyService.findPage(params);
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
    @RequiresPermissions("bpm:collectionmoney:add")
    @BussinessLog(title = "收款信息", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmCollectionmoney(@Validated bpmCrmCollectionmoneyEntity bpmCrmCollectionmoney){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmCollectionmoney);
        return bpmCrmCollectionmoneyService.savebpmCrmCollectionmoney(bpmCrmCollectionmoney)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:collectionmoney:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmCollectionmoneyEntity bpmCrmCollectionmoney = bpmCrmCollectionmoneyService.getbpmCrmCollectionmoneyById(id);
        mmap.put("bpmCrmCollectionmoney", bpmCrmCollectionmoney);
        return prefix + "/edit";
    }

    /**
     * 修改保存收款信息
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:collectionmoney:edit")
    @BussinessLog(title = "收款信息", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmCollectionmoney(bpmCrmCollectionmoneyEntity bpmCrmCollectionmoney){
		ValidatorUtil.validateEntity(bpmCrmCollectionmoney);
        return bpmCrmCollectionmoneyService.updatebpmCrmCollectionmoneyById(bpmCrmCollectionmoney)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "收款信息", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:collectionmoney:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmCollectionmoneyService.deletebpmCrmCollectionmoneyByIds(ids)? success(): error("删除失败!");
    }    
}
