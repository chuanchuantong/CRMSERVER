package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmPreparationEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmPreparationMapper;
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
 * 整备Service接口
 * @author: yhli
 * @date 2020-06-23 11:26
 */
@Service
public class bpmCrmPreparationService extends ServiceImpl<bpmCrmPreparationMapper,bpmCrmPreparationEntity> {

	@Resource
	private bpmCrmPreparationMapper bpmCrmPreparationMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmPreparationEntity> r = new QueryWrapper<bpmCrmPreparationEntity>();                  
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
				String orderMemo = (String) params.get("orderMemo");        
				r.eq(ToolUtil.isNotEmpty(orderMemo), "order_memo", orderMemo);                  
				String preparationServicePlace = (String) params.get("preparationServicePlace");        
				r.eq(ToolUtil.isNotEmpty(preparationServicePlace), "preparation_service_place", preparationServicePlace);                  
				String preparationServiceType = (String) params.get("preparationServiceType");        
				r.eq(ToolUtil.isNotEmpty(preparationServiceType), "preparation_service_type", preparationServiceType);                        
				String preparationInvoiceNumber = (String) params.get("preparationInvoiceNumber");        
				r.eq(ToolUtil.isNotEmpty(preparationInvoiceNumber), "preparation_invoice_number", preparationInvoiceNumber);                  
				String preparationInvoiceFilepath = (String) params.get("preparationInvoiceFilepath");        
				r.eq(ToolUtil.isNotEmpty(preparationInvoiceFilepath), "preparation_invoice_filepath", preparationInvoiceFilepath);                  
				String preparationActualAmount = (String) params.get("preparationActualAmount");        
				r.eq(ToolUtil.isNotEmpty(preparationActualAmount), "preparation_actual_amount", preparationActualAmount);            
				Page<bpmCrmPreparationEntity> page = this.baseMapper.selectPage(new Query<bpmCrmPreparationEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmPreparationByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmPreparationById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmPreparation(bpmCrmPreparationEntity bpmCrmPreparation){
        return this.save(bpmCrmPreparation);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmPreparationById(bpmCrmPreparationEntity bpmCrmPreparation) {
		return this.updateById(bpmCrmPreparation);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmPreparationEntity getbpmCrmPreparationById(String id){
		return this.getById(id);
	}
}
