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
import com.j2eefast.flowable.bpm.entity.bpmCrmTemptagEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmTemptagService;

/**
 * 临牌页面控制器
 * @author yhli
 * @date 2020-06-23 18:17
 */
@Controller
@RequestMapping("/bpm/temptag")
public class bpmCrmTemptagController extends BaseController{

    private String prefix = "modules/bpm/temptag";
    @Autowired
    private bpmCrmTemptagService bpmCrmTemptagService;

    @RequiresPermissions("bpm:temptag:view")
    @GetMapping()
    public String temptag(){
        return prefix + "/temptag";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:temptag:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmTemptagService.findPage(params);
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
    @RequiresPermissions("bpm:temptag:add")
    @BussinessLog(title = "临牌", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmTemptag(@Validated bpmCrmTemptagEntity bpmCrmTemptag){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmTemptag);
        return bpmCrmTemptagService.savebpmCrmTemptag(bpmCrmTemptag)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:temptag:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmTemptagEntity bpmCrmTemptag = bpmCrmTemptagService.getbpmCrmTemptagById(id);
        mmap.put("bpmCrmTemptag", bpmCrmTemptag);
        return prefix + "/edit";
    }

    /**
     * 修改保存临牌
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:temptag:edit")
    @BussinessLog(title = "临牌", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmTemptag(bpmCrmTemptagEntity bpmCrmTemptag){
		ValidatorUtil.validateEntity(bpmCrmTemptag);
        return bpmCrmTemptagService.updatebpmCrmTemptagById(bpmCrmTemptag)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "临牌", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:temptag:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmTemptagService.deletebpmCrmTemptagByIds(ids)? success(): error("删除失败!");
    }    
}
