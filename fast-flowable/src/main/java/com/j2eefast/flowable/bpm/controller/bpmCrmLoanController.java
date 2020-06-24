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
import com.j2eefast.flowable.bpm.entity.bpmCrmLoanEntity;
import com.j2eefast.flowable.bpm.service.bpmCrmLoanService;

/**
 * 贷款信息表页面控制器
 * @author yhli
 * @date 2020-06-23 22:30
 */
@Controller
@RequestMapping("/bpm/loan")
public class bpmCrmLoanController extends BaseController{

    private String prefix = "modules/bpm/loan";
    @Autowired
    private bpmCrmLoanService bpmCrmLoanService;

    @RequiresPermissions("bpm:loan:view")
    @GetMapping()
    public String loan(){
        return prefix + "/loan";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:loan:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = bpmCrmLoanService.findPage(params);
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
    @RequiresPermissions("bpm:loan:add")
    @BussinessLog(title = "贷款信息表", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addbpmCrmLoan(@Validated bpmCrmLoanEntity bpmCrmLoan){
        //校验参数
        ValidatorUtil.validateEntity(bpmCrmLoan);
        return bpmCrmLoanService.savebpmCrmLoan(bpmCrmLoan)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:loan:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap){
        bpmCrmLoanEntity bpmCrmLoan = bpmCrmLoanService.getbpmCrmLoanById(id);
        mmap.put("bpmCrmLoan", bpmCrmLoan);
        return prefix + "/edit";
    }

    /**
     * 修改保存贷款信息表
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:loan:edit")
    @BussinessLog(title = "贷款信息表", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editbpmCrmLoan(bpmCrmLoanEntity bpmCrmLoan){
		ValidatorUtil.validateEntity(bpmCrmLoan);
        return bpmCrmLoanService.updatebpmCrmLoanById(bpmCrmLoan)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "贷款信息表", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:loan:del")
    @ResponseBody
    public ResponseData del(String[] ids) {
      return bpmCrmLoanService.deletebpmCrmLoanByIds(ids)? success(): error("删除失败!");
    }    
}
