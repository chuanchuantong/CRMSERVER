package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmApplyoutlibraryEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmApplyoutlibraryMapper;
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
 * 申请出库Service接口
 * @author: yhli
 * @date 2020-06-23 14:05
 */
@Service
public class bpmCrmApplyoutlibraryService extends ServiceImpl<bpmCrmApplyoutlibraryMapper,bpmCrmApplyoutlibraryEntity> {

	@Resource
	private bpmCrmApplyoutlibraryMapper bpmCrmApplyoutlibraryMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmApplyoutlibraryEntity> r = new QueryWrapper<bpmCrmApplyoutlibraryEntity>();                  
				String saleCode = (String) params.get("saleCode");        
				r.eq(ToolUtil.isNotEmpty(saleCode), "sale_code", saleCode);                                                            
				String saleUserid = (String) params.get("saleUserid");        
				r.eq(ToolUtil.isNotEmpty(saleUserid), "sale_userid", saleUserid);                  
				String saleOrderNumber = (String) params.get("saleOrderNumber");        
				r.eq(ToolUtil.isNotEmpty(saleOrderNumber), "sale_order_number", saleOrderNumber);                  
				String orderContractPrice = (String) params.get("orderContractPrice");        
				r.eq(ToolUtil.isNotEmpty(orderContractPrice), "order_contract_price", orderContractPrice);                  
				String orderIsTax = (String) params.get("orderIsTax");        
				r.eq(ToolUtil.isNotEmpty(orderIsTax), "order_is_tax", orderIsTax);                  
				String orderIsTransport = (String) params.get("orderIsTransport");        
				r.eq(ToolUtil.isNotEmpty(orderIsTransport), "order_is_transport", orderIsTransport);                  
				String orderIsGuarantee = (String) params.get("orderIsGuarantee");        
				r.eq(ToolUtil.isNotEmpty(orderIsGuarantee), "order_is_guarantee", orderIsGuarantee);                  
				String orderOtherProject = (String) params.get("orderOtherProject");        
				r.eq(ToolUtil.isNotEmpty(orderOtherProject), "order_other_project", orderOtherProject);                  
				String carStockId = (String) params.get("carStockId");        
				r.eq(ToolUtil.isNotEmpty(carStockId), "car_stock_id", carStockId);                  
				String carVin = (String) params.get("carVin");        
				r.eq(ToolUtil.isNotEmpty(carVin), "car_vin", carVin);                  
				String carVehicle = (String) params.get("carVehicle");        
				r.eq(ToolUtil.isNotEmpty(carVehicle), "car_vehicle", carVehicle);                  
				String carStockCost = (String) params.get("carStockCost");        
				r.eq(ToolUtil.isNotEmpty(carStockCost), "car_stock_cost", carStockCost);                  
				String approvalIsCross = (String) params.get("approvalIsCross");        
				r.eq(ToolUtil.isNotEmpty(approvalIsCross), "approval_is_cross", approvalIsCross);                        
				String approvalTime = (String) params.get("approvalTime");        
				r.eq(ToolUtil.isNotEmpty(approvalTime), "approval_time", approvalTime);            
				Page<bpmCrmApplyoutlibraryEntity> page = this.baseMapper.selectPage(new Query<bpmCrmApplyoutlibraryEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmApplyoutlibraryByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmApplyoutlibraryById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmApplyoutlibrary(bpmCrmApplyoutlibraryEntity bpmCrmApplyoutlibrary){
        return this.save(bpmCrmApplyoutlibrary);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmApplyoutlibraryById(bpmCrmApplyoutlibraryEntity bpmCrmApplyoutlibrary) {
		return this.updateById(bpmCrmApplyoutlibrary);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmApplyoutlibraryEntity getbpmCrmApplyoutlibraryById(String id){
		return this.getById(id);
	}
}
