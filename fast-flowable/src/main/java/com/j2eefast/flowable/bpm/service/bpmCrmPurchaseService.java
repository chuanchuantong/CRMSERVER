package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmPurchaseEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmPurchaseMapper;
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
 * 采购订单Service接口
 * @author: yhli
 * @date 2020-06-19 13:29
 */
@Service
public class bpmCrmPurchaseService extends ServiceImpl<bpmCrmPurchaseMapper,bpmCrmPurchaseEntity> {

	@Resource
	private bpmCrmPurchaseMapper bpmCrmPurchaseMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmPurchaseEntity> r = new QueryWrapper<bpmCrmPurchaseEntity>();            
				String processInstanceId = (String) params.get("processInstanceId");        
				r.eq(ToolUtil.isNotEmpty(processInstanceId), "process_instance_id", processInstanceId);                  
				String saleCode = (String) params.get("saleCode");        
				r.eq(ToolUtil.isNotEmpty(saleCode), "sale_code", saleCode);                                                
				String userId = (String) params.get("userId");        
				r.eq(ToolUtil.isNotEmpty(userId), "user_id", userId);                        
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
				String orderOtherItem = (String) params.get("orderOtherItem");        
				r.eq(ToolUtil.isNotEmpty(orderOtherItem), "order_other_item", orderOtherItem);                  
				String carVin = (String) params.get("carVin");        
				r.eq(ToolUtil.isNotEmpty(carVin), "car_vin", carVin);                  
				String carVehicle = (String) params.get("carVehicle");        
				r.eq(ToolUtil.isNotEmpty(carVehicle), "car_vehicle", carVehicle);                  
				String carMileage = (String) params.get("carMileage");        
				r.eq(ToolUtil.isNotEmpty(carMileage), "car_mileage", carMileage);                  
				String carTranmission = (String) params.get("carTranmission");        
				r.eq(ToolUtil.isNotEmpty(carTranmission), "car_tranmission", carTranmission);                  
				String carDrivertrain = (String) params.get("carDrivertrain");        
				r.eq(ToolUtil.isNotEmpty(carDrivertrain), "car_drivertrain", carDrivertrain);                  
				String carStatus = (String) params.get("carStatus");        
				r.eq(ToolUtil.isNotEmpty(carStatus), "car_status", carStatus);                        
				String channelPurchaseSource = (String) params.get("channelPurchaseSource");        
				r.eq(ToolUtil.isNotEmpty(channelPurchaseSource), "channel_purchase_source", channelPurchaseSource);                  
				String channelIsOpenSale = (String) params.get("channelIsOpenSale");        
				r.eq(ToolUtil.isNotEmpty(channelIsOpenSale), "channel_is_open_sale", channelIsOpenSale);                  
				String channelAuction = (String) params.get("channelAuction");        
				r.eq(ToolUtil.isNotEmpty(channelAuction), "channel_auction", channelAuction);                  
				String channelAuctionType = (String) params.get("channelAuctionType");        
				r.eq(ToolUtil.isNotEmpty(channelAuctionType), "channel_auction_type", channelAuctionType);                  
				String channelAuctionTimeType = (String) params.get("channelAuctionTimeType");        
				r.eq(ToolUtil.isNotEmpty(channelAuctionTimeType), "channel_auction_time_type", channelAuctionTimeType);                  
				String channelAuctionTime = (String) params.get("channelAuctionTime");        
				r.eq(ToolUtil.isNotEmpty(channelAuctionTime), "channel_auction_time", channelAuctionTime);                  
				String channelSellerName = (String) params.get("channelSellerName");        
				r.like(ToolUtil.isNotEmpty(channelSellerName), "channel_seller_name", channelSellerName);                		          
				String channelSellerContactinfo = (String) params.get("channelSellerContactinfo");        
				r.eq(ToolUtil.isNotEmpty(channelSellerContactinfo), "channel_seller_contactinfo", channelSellerContactinfo);                  
				String channelPurchaseMemo = (String) params.get("channelPurchaseMemo");        
				r.eq(ToolUtil.isNotEmpty(channelPurchaseMemo), "channel_purchase_memo", channelPurchaseMemo);                  
				String managerPurchaseSpecialist = (String) params.get("managerPurchaseSpecialist");        
				r.eq(ToolUtil.isNotEmpty(managerPurchaseSpecialist), "manager_purchase_specialist", managerPurchaseSpecialist);                  
				String managerReview = (String) params.get("managerReview");        
				r.eq(ToolUtil.isNotEmpty(managerReview), "manager_review", managerReview);                  
				String managerReviewMemo = (String) params.get("managerReviewMemo");        
				r.eq(ToolUtil.isNotEmpty(managerReviewMemo), "manager_review_memo", managerReviewMemo);                  
				String managerIsPurchase = (String) params.get("managerIsPurchase");        
				r.eq(ToolUtil.isNotEmpty(managerIsPurchase), "manager_is_purchase", managerIsPurchase);                  
				String purchaseResult = (String) params.get("purchaseResult");        
				r.eq(ToolUtil.isNotEmpty(purchaseResult), "purchase_result", purchaseResult);                  
				String purchaseResultTime = (String) params.get("purchaseResultTime");        
				r.eq(ToolUtil.isNotEmpty(purchaseResultTime), "purchase_result_time", purchaseResultTime);                  
				String purchaseResultMemo = (String) params.get("purchaseResultMemo");        
				r.eq(ToolUtil.isNotEmpty(purchaseResultMemo), "purchase_result_memo", purchaseResultMemo);                  
				String isWarehousing = (String) params.get("isWarehousing");        
				r.eq(ToolUtil.isNotEmpty(isWarehousing), "is_warehousing", isWarehousing);                  
				String cashierPaySentTime = (String) params.get("cashierPaySentTime");        
				r.eq(ToolUtil.isNotEmpty(cashierPaySentTime), "cashier_pay_sent_time", cashierPaySentTime);                  
				String cashierPayMethod = (String) params.get("cashierPayMethod");        
				r.eq(ToolUtil.isNotEmpty(cashierPayMethod), "cashier_pay_method", cashierPayMethod);                  
				String cashierProofFilepath = (String) params.get("cashierProofFilepath");        
				r.eq(ToolUtil.isNotEmpty(cashierProofFilepath), "cashier_proof_filepath", cashierProofFilepath);                  
				String cashierReceiptNumber = (String) params.get("cashierReceiptNumber");        
				r.eq(ToolUtil.isNotEmpty(cashierReceiptNumber), "cashier_receipt_number", cashierReceiptNumber);                  
				String cashierMemo = (String) params.get("cashierMemo");        
				r.eq(ToolUtil.isNotEmpty(cashierMemo), "cashier_memo", cashierMemo);                  
				String confirmPayMethod = (String) params.get("confirmPayMethod");        
				r.eq(ToolUtil.isNotEmpty(confirmPayMethod), "confirm_pay_method", confirmPayMethod);                  
				String confirmPayAmount = (String) params.get("confirmPayAmount");        
				r.eq(ToolUtil.isNotEmpty(confirmPayAmount), "confirm_pay_amount", confirmPayAmount);                  
				String confirmMemo = (String) params.get("confirmMemo");        
				r.eq(ToolUtil.isNotEmpty(confirmMemo), "confirm_memo", confirmMemo);                  
				String purchasePaySum = (String) params.get("purchasePaySum");        
				r.eq(ToolUtil.isNotEmpty(purchasePaySum), "purchase_pay_sum", purchasePaySum);                  
				String purchaseRemark = (String) params.get("purchaseRemark");        
				r.eq(ToolUtil.isNotEmpty(purchaseRemark), "purchase_remark", purchaseRemark);            
				Page<bpmCrmPurchaseEntity> page = this.baseMapper.selectPage(new Query<bpmCrmPurchaseEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmPurchaseByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmPurchaseById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmPurchase(bpmCrmPurchaseEntity bpmCrmPurchase){
        return this.save(bpmCrmPurchase);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmPurchaseById(bpmCrmPurchaseEntity bpmCrmPurchase) {
		return this.updateById(bpmCrmPurchase);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmPurchaseEntity getbpmCrmPurchaseById(String id){
		return this.getById(id);
	}
}
