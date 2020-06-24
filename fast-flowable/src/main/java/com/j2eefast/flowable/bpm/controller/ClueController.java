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
import com.j2eefast.flowable.bpm.entity.ClueEntity;
import com.j2eefast.flowable.bpm.service.ClueService;

/**
 * 线索池页面控制器
 * @author yhli
 * @date 2020-06-19 14:19
 */
@Controller
@RequestMapping("/bpm/Clue")
public class ClueController extends BaseController{

    private String prefix = "modules/bpm/Clue";
    @Autowired
    private ClueService clueService;

    @RequiresPermissions("bpm:Clue:view")
    @GetMapping()
    public String Clue(){
        return prefix + "/Clue";
    }
        
    @RequestMapping("/list")
    @RequiresPermissions("bpm:Clue:list")
    @ResponseBody
    public ResponseData list(@RequestParam Map<String, Object> params) {
		PageUtil page = clueService.findPage(params);
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
    @RequiresPermissions("bpm:Clue:add")
    @BussinessLog(title = "线索池", businessType = BusinessType.INSERT)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData addClue(@Validated ClueEntity clue){
        //校验参数
        ValidatorUtil.validateEntity(clue);
        return clueService.saveClue(clue)? success(): error("新增失败!");
    }    
    
    /**
     * 修改
     */
    @RequiresPermissions("bpm:Clue:edit")
    @GetMapping("/edit/{Id}")
    public String edit(@PathVariable("Id") Long Id, ModelMap mmap){
        ClueEntity clue = clueService.getClueById(Id);
        mmap.put("clue", clue);
        return prefix + "/edit";
    }

    /**
     * 修改保存线索池
     */
    @RepeatSubmit
    @RequiresPermissions("bpm:Clue:edit")
    @BussinessLog(title = "线索池", businessType = BusinessType.UPDATE)
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData editClue(ClueEntity clue){
		ValidatorUtil.validateEntity(clue);
        return clueService.updateClueById(clue)? success(): error("修改失败!");
    }    

    /**
     * 删除
     */
    @RepeatSubmit
    @BussinessLog(title = "线索池", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("bpm:Clue:del")
    @ResponseBody
    public ResponseData del(Long[] ids) {
      return clueService.deleteClueByIds(ids)? success(): error("删除失败!");
    }    
}
