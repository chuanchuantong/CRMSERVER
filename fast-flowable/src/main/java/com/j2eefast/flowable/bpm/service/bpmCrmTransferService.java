package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmTransferEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmTransferMapper;
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
 * 过户Service接口
 * @author: yhli
 * @date 2020-06-23 10:48
 */
@Service
public class bpmCrmTransferService extends ServiceImpl<bpmCrmTransferMapper,bpmCrmTransferEntity> {

	@Resource
	private bpmCrmTransferMapper bpmCrmTransferMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmTransferEntity> r = new QueryWrapper<bpmCrmTransferEntity>();                  
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
				String orderSpecialRemark = (String) params.get("orderSpecialRemark");        
				r.eq(ToolUtil.isNotEmpty(orderSpecialRemark), "order_special_remark", orderSpecialRemark);                  
				String orderCashierReview = (String) params.get("orderCashierReview");        
				r.eq(ToolUtil.isNotEmpty(orderCashierReview), "order_cashier_review", orderCashierReview);                  
				String orderFinanceManagerReview = (String) params.get("orderFinanceManagerReview");        
				r.eq(ToolUtil.isNotEmpty(orderFinanceManagerReview), "order_finance_manager_review", orderFinanceManagerReview);                  
				String orderCustomerSsn = (String) params.get("orderCustomerSsn");        
				r.eq(ToolUtil.isNotEmpty(orderCustomerSsn), "order_customer_ssn", orderCustomerSsn);                  
				String orderCustomerIFilepath = (String) params.get("orderCustomerIFilepath");        
				r.eq(ToolUtil.isNotEmpty(orderCustomerIFilepath), "order_customer_i_filepath", orderCustomerIFilepath);                  
				String orderRegistrantName = (String) params.get("orderRegistrantName");        
				r.like(ToolUtil.isNotEmpty(orderRegistrantName), "order_registrant_name", orderRegistrantName);                		          
				String orderRegistrantAddress = (String) params.get("orderRegistrantAddress");        
				r.eq(ToolUtil.isNotEmpty(orderRegistrantAddress), "order_registrant_address", orderRegistrantAddress);                  
				String orderRegistrantPhone = (String) params.get("orderRegistrantPhone");        
				r.eq(ToolUtil.isNotEmpty(orderRegistrantPhone), "order_registrant_phone", orderRegistrantPhone);                  
				String orderIsNeedMail = (String) params.get("orderIsNeedMail");        
				r.eq(ToolUtil.isNotEmpty(orderIsNeedMail), "order_is_need_mail", orderIsNeedMail);                  
				String orderRecipientisregistrant = (String) params.get("orderRecipientisregistrant");        
				r.eq(ToolUtil.isNotEmpty(orderRecipientisregistrant), "order_recipientisregistrant", orderRecipientisregistrant);                  
				String orderRecipientName = (String) params.get("orderRecipientName");        
				r.like(ToolUtil.isNotEmpty(orderRecipientName), "order_recipient_name", orderRecipientName);                		          
				String orderRecipientAddress = (String) params.get("orderRecipientAddress");        
				r.eq(ToolUtil.isNotEmpty(orderRecipientAddress), "order_recipient_address", orderRecipientAddress);                  
				String orderRecipientPhone = (String) params.get("orderRecipientPhone");        
				r.eq(ToolUtil.isNotEmpty(orderRecipientPhone), "order_recipient_phone", orderRecipientPhone);                  
				String orderRecipientMailMemo = (String) params.get("orderRecipientMailMemo");        
				r.eq(ToolUtil.isNotEmpty(orderRecipientMailMemo), "order_recipient_mail_memo", orderRecipientMailMemo);                  
				String taxAmount = (String) params.get("taxAmount");        
				r.eq(ToolUtil.isNotEmpty(taxAmount), "tax_amount", taxAmount);                  
				String taxServiceCharge = (String) params.get("taxServiceCharge");        
				r.eq(ToolUtil.isNotEmpty(taxServiceCharge), "tax_service_charge", taxServiceCharge);                  
				String taxFreight = (String) params.get("taxFreight");        
				r.eq(ToolUtil.isNotEmpty(taxFreight), "tax_freight", taxFreight);                  
				String taxShippingInfo = (String) params.get("taxShippingInfo");        
				r.eq(ToolUtil.isNotEmpty(taxShippingInfo), "tax_shipping_info", taxShippingInfo);                  
				String taxTransferDate = (String) params.get("taxTransferDate");        
				r.eq(ToolUtil.isNotEmpty(taxTransferDate), "tax_transfer_date", taxTransferDate);                  
				Page<bpmCrmTransferEntity> page = this.baseMapper.selectPage(new Query<bpmCrmTransferEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmTransferByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmTransferById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmTransfer(bpmCrmTransferEntity bpmCrmTransfer){
        return this.save(bpmCrmTransfer);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmTransferById(bpmCrmTransferEntity bpmCrmTransfer) {
		return this.updateById(bpmCrmTransfer);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmTransferEntity getbpmCrmTransferById(String id){
		return this.getById(id);
	}
}
