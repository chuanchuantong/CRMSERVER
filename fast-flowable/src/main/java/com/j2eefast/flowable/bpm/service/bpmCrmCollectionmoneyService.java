package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmCollectionmoneyEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmCollectionmoneyMapper;
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
 * 收款信息Service接口
 * @author: yhli
 * @date 2020-06-22 11:36
 */
@Service
public class bpmCrmCollectionmoneyService extends ServiceImpl<bpmCrmCollectionmoneyMapper,bpmCrmCollectionmoneyEntity> {

	@Resource
	private bpmCrmCollectionmoneyMapper bpmCrmCollectionmoneyMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmCollectionmoneyEntity> r = new QueryWrapper<bpmCrmCollectionmoneyEntity>();                  
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
				String paymentMethod = (String) params.get("paymentMethod");        
				r.eq(ToolUtil.isNotEmpty(paymentMethod), "payment_method", paymentMethod);                  
				String transactionDate = (String) params.get("transactionDate");        
				r.eq(ToolUtil.isNotEmpty(transactionDate), "transaction_date", transactionDate);                  
				String enterAmount = (String) params.get("enterAmount");        
				r.eq(ToolUtil.isNotEmpty(enterAmount), "enter_amount", enterAmount);                  
				String payerName = (String) params.get("payerName");        
				r.like(ToolUtil.isNotEmpty(payerName), "payer_name", payerName);                		          
				String payerProofFilepath = (String) params.get("payerProofFilepath");        
				r.eq(ToolUtil.isNotEmpty(payerProofFilepath), "payer_proof_filepath", payerProofFilepath);                  
				String payerMemo = (String) params.get("payerMemo");        
				r.eq(ToolUtil.isNotEmpty(payerMemo), "payer_memo", payerMemo);                  
				String amountReceived = (String) params.get("amountReceived");        
				r.eq(ToolUtil.isNotEmpty(amountReceived), "amount_received", amountReceived);                  
				String cashierMemo = (String) params.get("cashierMemo");        
				r.eq(ToolUtil.isNotEmpty(cashierMemo), "cashier_memo", cashierMemo);                  
				String cashierProofFilepath = (String) params.get("cashierProofFilepath");        
				r.eq(ToolUtil.isNotEmpty(cashierProofFilepath), "cashier_proof_filepath", cashierProofFilepath);                  
				String checkmoneyReceiptnumber = (String) params.get("checkmoneyReceiptnumber");        
				r.eq(ToolUtil.isNotEmpty(checkmoneyReceiptnumber), "checkmoney_receiptnumber", checkmoneyReceiptnumber);                  
				String receivedDate = (String) params.get("receivedDate");        
				r.eq(ToolUtil.isNotEmpty(receivedDate), "received_date", receivedDate);                  
				String cashierReview = (String) params.get("cashierReview");        
				r.eq(ToolUtil.isNotEmpty(cashierReview), "cashier_review", cashierReview);                  
				String orderTakeEffectTime = (String) params.get("orderTakeEffectTime");        
				r.eq(ToolUtil.isNotEmpty(orderTakeEffectTime), "order_take_effect_time", orderTakeEffectTime);                  
				String collectionTime = (String) params.get("collectionTime");        
				r.eq(ToolUtil.isNotEmpty(collectionTime), "collection_time", collectionTime);                  
				String intervalDay = (String) params.get("intervalDay");        
				r.eq(ToolUtil.isNotEmpty(intervalDay), "interval_day", intervalDay);                        
				String costOfCapital = (String) params.get("costOfCapital");        
				r.eq(ToolUtil.isNotEmpty(costOfCapital), "cost_of_capital", costOfCapital);                  
				String financeManagerReview = (String) params.get("financeManagerReview");        
				r.eq(ToolUtil.isNotEmpty(financeManagerReview), "finance_manager_review", financeManagerReview);                  
				String managerReview = (String) params.get("managerReview");        
				r.eq(ToolUtil.isNotEmpty(managerReview), "manager_review", managerReview);            
				Page<bpmCrmCollectionmoneyEntity> page = this.baseMapper.selectPage(new Query<bpmCrmCollectionmoneyEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmCollectionmoneyByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmCollectionmoneyById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmCollectionmoney(bpmCrmCollectionmoneyEntity bpmCrmCollectionmoney){
        return this.save(bpmCrmCollectionmoney);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmCollectionmoneyById(bpmCrmCollectionmoneyEntity bpmCrmCollectionmoney) {
		return this.updateById(bpmCrmCollectionmoney);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmCollectionmoneyEntity getbpmCrmCollectionmoneyById(String id){
		return this.getById(id);
	}
}
