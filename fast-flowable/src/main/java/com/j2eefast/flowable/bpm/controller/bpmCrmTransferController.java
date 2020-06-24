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
import com.j2eefast.flowable.bpm.entity.bpmCrmTransferEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmTransferService;

/**
 * 过户页面控制器
 * @author yhli
 * @date 2020-06-23 10:48
 */
@Controller
@RequestMapping("/bpm/transfer")
public class bpmCrmTransferController extends BaseController{

    private String prefix = "modules/bpm/transfer";
    @Autowired
    private bpmCrmTransferService bpmCrmTransferService;

    @RequiresPermissions("bpm:transfer:view")
    @GetMapping()
    public String transfer(){
        return prefix + "/transfer";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:transfer:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmTransferService.findPage(params);
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
    @RequiresPermissions("bpm:transfer:add")
    @BussinessLog(title = "过户", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmTransfer(@Validated bpmCrmTransferEntity bpmCrmTransfer){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmTransfer);
        return bpmCrmTransferService.savebpmCrmTransfer(bpmCrmTransfer)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:transfer:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmTransferEntity bpmCrmTransfer = bpmCrmTransferService.getbpmCrmTransferById(id);
        mmap.put("bpmCrmTransfer", bpmCrmTransfer);
        return prefix + "/edit";
    }

    /**
     * 修改保存过户
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:transfer:edit")
    @BussinessLog(title = "过户", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmTransfer(bpmCrmTransferEntity bpmCrmTransfer){
		ValidatorUtil.validateEntity(bpmCrmTransfer);
        return bpmCrmTransferService.updatebpmCrmTransferById(bpmCrmTransfer)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "过户", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:transfer:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmTransferService.deletebpmCrmTransferByIds(ids)? success(): error("删除失败!");
    }    
}
