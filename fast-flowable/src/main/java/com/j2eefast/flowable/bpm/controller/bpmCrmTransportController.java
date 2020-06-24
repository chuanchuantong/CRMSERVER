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
import com.j2eefast.flowable.bpm.entity.bpmCrmTransportEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmTransportService;

/**
 * 运输页面控制器
 * @author yhli
 * @date 2020-06-23 13:39
 */
@Controller
@RequestMapping("/bpm/transport")
public class bpmCrmTransportController extends BaseController{

    private String prefix = "modules/bpm/transport";
    @Autowired
    private bpmCrmTransportService bpmCrmTransportService;

    @RequiresPermissions("bpm:transport:view")
    @GetMapping()
    public String transport(){
        return prefix + "/transport";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:transport:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmTransportService.findPage(params);
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
    @RequiresPermissions("bpm:transport:add")
    @BussinessLog(title = "运输", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmTransport(@Validated bpmCrmTransportEntity bpmCrmTransport){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmTransport);
        return bpmCrmTransportService.savebpmCrmTransport(bpmCrmTransport)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:transport:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmTransportEntity bpmCrmTransport = bpmCrmTransportService.getbpmCrmTransportById(id);
        mmap.put("bpmCrmTransport", bpmCrmTransport);
        return prefix + "/edit";
    }

    /**
     * 修改保存运输
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:transport:edit")
    @BussinessLog(title = "运输", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmTransport(bpmCrmTransportEntity bpmCrmTransport){
		ValidatorUtil.validateEntity(bpmCrmTransport);
        return bpmCrmTransportService.updatebpmCrmTransportById(bpmCrmTransport)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "运输", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:transport:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmTransportService.deletebpmCrmTransportByIds(ids)? success(): error("删除失败!");
    }    
}
