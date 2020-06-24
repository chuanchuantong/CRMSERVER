package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmEndorderEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmEndorderMapper;
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
 * 结束订单Service接口
 * @author: yhli
 * @date 2020-06-23 10:48
 */
@Service
public class bpmCrmEndorderService extends ServiceImpl<bpmCrmEndorderMapper,bpmCrmEndorderEntity> {

	@Resource
	private bpmCrmEndorderMapper bpmCrmEndorderMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmEndorderEntity> r = new QueryWrapper<bpmCrmEndorderEntity>();                  
				String saleCode = (String) params.get("saleCode");        
				r.eq(ToolUtil.isNotEmpty(saleCode), "sale_code", saleCode);                                                            
				String saleUserid = (String) params.get("saleUserid");        
				r.eq(ToolUtil.isNotEmpty(saleUserid), "sale_userid", saleUserid);                  
				String outCarVin = (String) params.get("outCarVin");        
				r.eq(ToolUtil.isNotEmpty(outCarVin), "out_car_vin", outCarVin);                  
				String outCarVehicle = (String) params.get("outCarVehicle");        
				r.eq(ToolUtil.isNotEmpty(outCarVehicle), "out_car_vehicle", outCarVehicle);                  
				String orderEndType = (String) params.get("orderEndType");        
				r.eq(ToolUtil.isNotEmpty(orderEndType), "order_end_type", orderEndType);                        
				String creditRealitySum = (String) params.get("creditRealitySum");        
				r.eq(ToolUtil.isNotEmpty(creditRealitySum), "credit_reality_sum", creditRealitySum);                  
				String creditBillFilepath = (String) params.get("creditBillFilepath");        
				r.eq(ToolUtil.isNotEmpty(creditBillFilepath), "credit_bill_filepath", creditBillFilepath);                  
				String costType = (String) params.get("costType");        
				r.eq(ToolUtil.isNotEmpty(costType), "cost_type", costType);                  
				String costAmount = (String) params.get("costAmount");        
				r.eq(ToolUtil.isNotEmpty(costAmount), "cost_amount", costAmount);                  
				String costAllBusinessFilepath = (String) params.get("costAllBusinessFilepath");        
				r.eq(ToolUtil.isNotEmpty(costAllBusinessFilepath), "cost_all_business_filepath", costAllBusinessFilepath);                  
				String commissionRealitySum = (String) params.get("commissionRealitySum");        
				r.eq(ToolUtil.isNotEmpty(commissionRealitySum), "commission_reality_sum", commissionRealitySum);                  
				String commissionCurrentCost = (String) params.get("commissionCurrentCost");        
				r.eq(ToolUtil.isNotEmpty(commissionCurrentCost), "commission_current_cost", commissionCurrentCost);                  
				String commissionFinalProfit = (String) params.get("commissionFinalProfit");        
				r.eq(ToolUtil.isNotEmpty(commissionFinalProfit), "commission_final_profit", commissionFinalProfit);                  
				String commissionFinalAchievement = (String) params.get("commissionFinalAchievement");        
				r.eq(ToolUtil.isNotEmpty(commissionFinalAchievement), "commission_final_achievement", commissionFinalAchievement);                  
				String commissionPercentage = (String) params.get("commissionPercentage");        
				r.eq(ToolUtil.isNotEmpty(commissionPercentage), "commission_percentage", commissionPercentage);                  
				String commissionFinalCommission = (String) params.get("commissionFinalCommission");        
				r.eq(ToolUtil.isNotEmpty(commissionFinalCommission), "commission_final_commission", commissionFinalCommission);                  
				String approvalSalesDirector = (String) params.get("approvalSalesDirector");        
				r.eq(ToolUtil.isNotEmpty(approvalSalesDirector), "approval_sales_director", approvalSalesDirector);                        
				String approvalReconditioning = (String) params.get("approvalReconditioning");        
				r.eq(ToolUtil.isNotEmpty(approvalReconditioning), "approval_reconditioning", approvalReconditioning);                        
				String approvalMaintenanceCenter = (String) params.get("approvalMaintenanceCenter");        
				r.eq(ToolUtil.isNotEmpty(approvalMaintenanceCenter), "approval_maintenance_center", approvalMaintenanceCenter);                        
				String approvalTransport = (String) params.get("approvalTransport");        
				r.eq(ToolUtil.isNotEmpty(approvalTransport), "approval_transport", approvalTransport);                        
				String approvalCashier = (String) params.get("approvalCashier");        
				r.eq(ToolUtil.isNotEmpty(approvalCashier), "approval_cashier", approvalCashier);                        
				String approvalInventory = (String) params.get("approvalInventory");        
				r.eq(ToolUtil.isNotEmpty(approvalInventory), "approval_inventory", approvalInventory);                        
				String approvalTax = (String) params.get("approvalTax");        
				r.eq(ToolUtil.isNotEmpty(approvalTax), "approval_tax", approvalTax);                        
				String approvalAccounting = (String) params.get("approvalAccounting");        
				r.eq(ToolUtil.isNotEmpty(approvalAccounting), "approval_accounting", approvalAccounting);                        
				String approvalSalesDirectorReview = (String) params.get("approvalSalesDirectorReview");        
				r.eq(ToolUtil.isNotEmpty(approvalSalesDirectorReview), "approval_sales_director_review", approvalSalesDirectorReview);                  
				Page<bpmCrmEndorderEntity> page = this.baseMapper.selectPage(new Query<bpmCrmEndorderEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmEndorderByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmEndorderById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmEndorder(bpmCrmEndorderEntity bpmCrmEndorder){
        return this.save(bpmCrmEndorder);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmEndorderById(bpmCrmEndorderEntity bpmCrmEndorder) {
		return this.updateById(bpmCrmEndorder);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmEndorderEntity getbpmCrmEndorderById(String id){
		return this.getById(id);
	}
}
