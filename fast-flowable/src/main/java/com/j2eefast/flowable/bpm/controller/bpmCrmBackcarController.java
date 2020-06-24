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
import com.j2eefast.flowable.bpm.entity.bpmCrmBackcarEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmBackcarService;

/**
 * 退车页面控制器
 * @author yhli
 * @date 2020-06-22 18:31
 */
@Controller
@RequestMapping("/bpm/backcar")
public class bpmCrmBackcarController extends BaseController{

    private String prefix = "modules/bpm/backcar";
    @Autowired
    private bpmCrmBackcarService bpmCrmBackcarService;

    @RequiresPermissions("bpm:backcar:view")
    @GetMapping()
    public String backcar(){
        return prefix + "/backcar";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:backcar:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmBackcarService.findPage(params);
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
    @RequiresPermissions("bpm:backcar:add")
    @BussinessLog(title = "退车", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmBackcar(@Validated bpmCrmBackcarEntity bpmCrmBackcar){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmBackcar);
        return bpmCrmBackcarService.savebpmCrmBackcar(bpmCrmBackcar)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:backcar:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmBackcarEntity bpmCrmBackcar = bpmCrmBackcarService.getbpmCrmBackcarById(id);
        mmap.put("bpmCrmBackcar", bpmCrmBackcar);
        return prefix + "/edit";
    }

    /**
     * 修改保存退车
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:backcar:edit")
    @BussinessLog(title = "退车", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmBackcar(bpmCrmBackcarEntity bpmCrmBackcar){
		ValidatorUtil.validateEntity(bpmCrmBackcar);
        return bpmCrmBackcarService.updatebpmCrmBackcarById(bpmCrmBackcar)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "退车", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:backcar:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmBackcarService.deletebpmCrmBackcarByIds(ids)? success(): error("删除失败!");
    }    
}
