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
import com.j2eefast.flowable.bpm.entity.bpmCrmEndorderEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmEndorderService;

/**
 * 结束订单页面控制器
 * @author yhli
 * @date 2020-06-23 10:48
 */
@Controller
@RequestMapping("/bpm/endorder")
public class bpmCrmEndorderController extends BaseController{

    private String prefix = "modules/bpm/endorder";
    @Autowired
    private bpmCrmEndorderService bpmCrmEndorderService;

    @RequiresPermissions("bpm:endorder:view")
    @GetMapping()
    public String endorder(){
        return prefix + "/endorder";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:endorder:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmEndorderService.findPage(params);
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
    @RequiresPermissions("bpm:endorder:add")
    @BussinessLog(title = "结束订单", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmEndorder(@Validated bpmCrmEndorderEntity bpmCrmEndorder){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmEndorder);
        return bpmCrmEndorderService.savebpmCrmEndorder(bpmCrmEndorder)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:endorder:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmEndorderEntity bpmCrmEndorder = bpmCrmEndorderService.getbpmCrmEndorderById(id);
        mmap.put("bpmCrmEndorder", bpmCrmEndorder);
        return prefix + "/edit";
    }

    /**
     * 修改保存结束订单
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:endorder:edit")
    @BussinessLog(title = "结束订单", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmEndorder(bpmCrmEndorderEntity bpmCrmEndorder){
		ValidatorUtil.validateEntity(bpmCrmEndorder);
        return bpmCrmEndorderService.updatebpmCrmEndorderById(bpmCrmEndorder)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "结束订单", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:endorder:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmEndorderService.deletebpmCrmEndorderByIds(ids)? success(): error("删除失败!");
    }    
}
