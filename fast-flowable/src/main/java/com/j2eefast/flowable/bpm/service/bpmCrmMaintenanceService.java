package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmMaintenanceEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmMaintenanceMapper;
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
 * 维修Service接口
 * @author: yhli
 * @date 2020-06-23 11:51
 */
@Service
public class bpmCrmMaintenanceService extends ServiceImpl<bpmCrmMaintenanceMapper,bpmCrmMaintenanceEntity> {

	@Resource
	private bpmCrmMaintenanceMapper bpmCrmMaintenanceMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmMaintenanceEntity> r = new QueryWrapper<bpmCrmMaintenanceEntity>();                  
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
				String orderCarContacts = (String) params.get("orderCarContacts");        
				r.eq(ToolUtil.isNotEmpty(orderCarContacts), "order_car_contacts", orderCarContacts);                  
				String orderCarPlanInTime = (String) params.get("orderCarPlanInTime");        
				r.eq(ToolUtil.isNotEmpty(orderCarPlanInTime), "order_car_plan_in_time", orderCarPlanInTime);                  
				String orderCarLastDeliveryTime = (String) params.get("orderCarLastDeliveryTime");        
				r.eq(ToolUtil.isNotEmpty(orderCarLastDeliveryTime), "order_car_last_delivery_time", orderCarLastDeliveryTime);                  
				String orderCarPosition = (String) params.get("orderCarPosition");        
				r.eq(ToolUtil.isNotEmpty(orderCarPosition), "order_car_position", orderCarPosition);                        
				String orderCarLossFilepath = (String) params.get("orderCarLossFilepath");        
				r.eq(ToolUtil.isNotEmpty(orderCarLossFilepath), "order_car_loss_filepath", orderCarLossFilepath);                  
				String commissionerPlanGiveTime = (String) params.get("commissionerPlanGiveTime");        
				r.eq(ToolUtil.isNotEmpty(commissionerPlanGiveTime), "commissioner_plan_give_time", commissionerPlanGiveTime);                  
				String commissionerRepairMethod = (String) params.get("commissionerRepairMethod");        
				r.eq(ToolUtil.isNotEmpty(commissionerRepairMethod), "commissioner_repair_method", commissionerRepairMethod);                  
				String commissionerOffer = (String) params.get("commissionerOffer");        
				r.eq(ToolUtil.isNotEmpty(commissionerOffer), "commissioner_offer", commissionerOffer);                  
				String commissionerOfferFilepath = (String) params.get("commissionerOfferFilepath");        
				r.eq(ToolUtil.isNotEmpty(commissionerOfferFilepath), "commissioner_offer_filepath", commissionerOfferFilepath);                  
				String maintenanceCheckFilepath = (String) params.get("maintenanceCheckFilepath");        
				r.eq(ToolUtil.isNotEmpty(maintenanceCheckFilepath), "maintenance_check_filepath", maintenanceCheckFilepath);                  
				String maintenanceStatus = (String) params.get("maintenanceStatus");        
				r.eq(ToolUtil.isNotEmpty(maintenanceStatus), "maintenance_status", maintenanceStatus);                  
				String maintenanceSettlementFilepath = (String) params.get("maintenanceSettlementFilepath");        
				r.eq(ToolUtil.isNotEmpty(maintenanceSettlementFilepath), "maintenance_settlement_filepath", maintenanceSettlementFilepath);                  
				String maintenanceTotalPrice = (String) params.get("maintenanceTotalPrice");        
				r.eq(ToolUtil.isNotEmpty(maintenanceTotalPrice), "maintenance_total_price", maintenanceTotalPrice);                  
				Page<bpmCrmMaintenanceEntity> page = this.baseMapper.selectPage(new Query<bpmCrmMaintenanceEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmMaintenanceByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmMaintenanceById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmMaintenance(bpmCrmMaintenanceEntity bpmCrmMaintenance){
        return this.save(bpmCrmMaintenance);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmMaintenanceById(bpmCrmMaintenanceEntity bpmCrmMaintenance) {
		return this.updateById(bpmCrmMaintenance);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmMaintenanceEntity getbpmCrmMaintenanceById(String id){
		return this.getById(id);
	}
}
