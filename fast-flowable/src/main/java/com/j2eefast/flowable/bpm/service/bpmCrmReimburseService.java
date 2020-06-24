package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmReimburseEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmReimburseMapper;
import com.j2eefast.common.core.page.Query;
import com.j2eefast.common.core.utils.PageUtil;
import com.j2eefast.common.core.utils.ToolUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;
import java.util.Arrays;
/**
 *
 * 报销Service接口
 * @author: yhli
 * @date 2020-06-22 14:13
 */
@Service
public class bpmCrmReimburseService extends ServiceImpl<bpmCrmReimburseMapper,bpmCrmReimburseEntity> {

	@Resource
	private bpmCrmReimburseMapper bpmCrmReimburseMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmReimburseEntity> r = new QueryWrapper<bpmCrmReimburseEntity>();                  
				String saleCode = (String) params.get("saleCode");        
				r.eq(ToolUtil.isNotEmpty(saleCode), "sale_code", saleCode);                                                            
				String saleUserid = (String) params.get("saleUserid");        
				r.eq(ToolUtil.isNotEmpty(saleUserid), "sale_userid", saleUserid);                  
				String saleOrderNumber = (String) params.get("saleOrderNumber");        
				r.eq(ToolUtil.isNotEmpty(saleOrderNumber), "sale_order_number", saleOrderNumber);                  
				String outCarVin = (String) params.get("outCarVin");        
				r.eq(ToolUtil.isNotEmpty(outCarVin), "out_car_vin", outCarVin);                  
				String outCarVehicle = (String) params.get("outCarVehicle");        
				r.eq(ToolUtil.isNotEmpty(outCarVehicle), "out_car_vehicle", outCarVehicle);                  
				String reimburseTime = (String) params.get("reimburseTime");        
				r.eq(ToolUtil.isNotEmpty(reimburseTime), "reimburse_time", reimburseTime);                  
				String reimburseAmount = (String) params.get("reimburseAmount");        
				r.eq(ToolUtil.isNotEmpty(reimburseAmount), "reimburse_amount", reimburseAmount);                  
				String reimburseAttaFilepath = (String) params.get("reimburseAttaFilepath");        
				r.eq(ToolUtil.isNotEmpty(reimburseAttaFilepath), "reimburse_atta_filepath", reimburseAttaFilepath);                  
				String cashierAmount = (String) params.get("cashierAmount");        
				r.eq(ToolUtil.isNotEmpty(cashierAmount), "cashier_amount", cashierAmount);                  
				String cashierApproval = (String) params.get("cashierApproval");        
				r.eq(ToolUtil.isNotEmpty(cashierApproval), "cashier_approval", cashierApproval);                  
				String cashierRemark = (String) params.get("cashierRemark");        
				r.eq(ToolUtil.isNotEmpty(cashierRemark), "cashier_remark", cashierRemark);                  
				String financeProportion = (String) params.get("financeProportion");        
				r.eq(ToolUtil.isNotEmpty(financeProportion), "finance_proportion", financeProportion);                  
				String financeAmount = (String) params.get("financeAmount");        
				r.eq(ToolUtil.isNotEmpty(financeAmount), "finance_amount", financeAmount);                  
				String financeApproval = (String) params.get("financeApproval");        
				r.eq(ToolUtil.isNotEmpty(financeApproval), "finance_approval", financeApproval);                  
				String financeRemark = (String) params.get("financeRemark");        
				r.eq(ToolUtil.isNotEmpty(financeRemark), "finance_remark", financeRemark);                  
				String accountingApproval = (String) params.get("accountingApproval");        
				r.eq(ToolUtil.isNotEmpty(accountingApproval), "accounting_approval", accountingApproval);                  
				String accountingRemark = (String) params.get("accountingRemark");        
				r.eq(ToolUtil.isNotEmpty(accountingRemark), "accounting_remark", accountingRemark);            
				Page<bpmCrmReimburseEntity> page = this.baseMapper.selectPage(new Query<bpmCrmReimburseEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmReimburseByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmReimburseById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmReimburse(bpmCrmReimburseEntity bpmCrmReimburse){
        return this.save(bpmCrmReimburse);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmReimburseById(bpmCrmReimburseEntity bpmCrmReimburse) {
		return this.updateById(bpmCrmReimburse);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmReimburseEntity getbpmCrmReimburseById(String id){
		return this.getById(id);
	}
}
