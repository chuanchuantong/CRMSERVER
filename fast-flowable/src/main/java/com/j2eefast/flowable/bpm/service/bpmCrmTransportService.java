package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmTransportEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmTransportMapper;
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
 * 运输Service接口
 * @author: yhli
 * @date 2020-06-23 13:39
 */
@Service
public class bpmCrmTransportService extends ServiceImpl<bpmCrmTransportMapper,bpmCrmTransportEntity> {

	@Resource
	private bpmCrmTransportMapper bpmCrmTransportMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmTransportEntity> r = new QueryWrapper<bpmCrmTransportEntity>();                  
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
				String transportTakeCarPlace = (String) params.get("transportTakeCarPlace");        
				r.eq(ToolUtil.isNotEmpty(transportTakeCarPlace), "transport_take_car_place", transportTakeCarPlace);                  
				String transportSelectColleague = (String) params.get("transportSelectColleague");        
				r.eq(ToolUtil.isNotEmpty(transportSelectColleague), "transport_select_colleague", transportSelectColleague);                  
				String transportTakeCarAddress = (String) params.get("transportTakeCarAddress");        
				r.eq(ToolUtil.isNotEmpty(transportTakeCarAddress), "transport_take_car_address", transportTakeCarAddress);                  
				String transportTakeCarPhone = (String) params.get("transportTakeCarPhone");        
				r.eq(ToolUtil.isNotEmpty(transportTakeCarPhone), "transport_take_car_phone", transportTakeCarPhone);                  
				String transportGiveCarPlace = (String) params.get("transportGiveCarPlace");        
				r.eq(ToolUtil.isNotEmpty(transportGiveCarPlace), "transport_give_car_place", transportGiveCarPlace);                  
				String transportGiveSelectColleague = (String) params.get("transportGiveSelectColleague");        
				r.eq(ToolUtil.isNotEmpty(transportGiveSelectColleague), "transport_give_select_colleague", transportGiveSelectColleague);                  
				String transportGiveCarAddress = (String) params.get("transportGiveCarAddress");        
				r.eq(ToolUtil.isNotEmpty(transportGiveCarAddress), "transport_give_car_address", transportGiveCarAddress);                  
				String transportGiveCarPhone = (String) params.get("transportGiveCarPhone");        
				r.eq(ToolUtil.isNotEmpty(transportGiveCarPhone), "transport_give_car_phone", transportGiveCarPhone);                  
				String approvalCurrentStatus = (String) params.get("approvalCurrentStatus");        
				r.eq(ToolUtil.isNotEmpty(approvalCurrentStatus), "approval_current_status", approvalCurrentStatus);                        
				String approvalPlanTakeCarTime = (String) params.get("approvalPlanTakeCarTime");        
				r.eq(ToolUtil.isNotEmpty(approvalPlanTakeCarTime), "approval_plan_take_car_time", approvalPlanTakeCarTime);                  
				String approvalPlanArriveTime = (String) params.get("approvalPlanArriveTime");        
				r.eq(ToolUtil.isNotEmpty(approvalPlanArriveTime), "approval_plan_arrive_time", approvalPlanArriveTime);                  
				String approvalOrderid = (String) params.get("approvalOrderid");        
				r.eq(ToolUtil.isNotEmpty(approvalOrderid), "approval_orderid", approvalOrderid);                  
				String approvalCentralDispatchFee = (String) params.get("approvalCentralDispatchFee");        
				r.eq(ToolUtil.isNotEmpty(approvalCentralDispatchFee), "approval_central_dispatch_fee", approvalCentralDispatchFee);                  
				String transportCompanyName = (String) params.get("transportCompanyName");        
				r.like(ToolUtil.isNotEmpty(transportCompanyName), "transport_company_name", transportCompanyName);                		          
				String transportCompanyCheckAddress = (String) params.get("transportCompanyCheckAddress");        
				r.eq(ToolUtil.isNotEmpty(transportCompanyCheckAddress), "transport_company_check_address", transportCompanyCheckAddress);                  
				String transportMail = (String) params.get("transportMail");        
				r.eq(ToolUtil.isNotEmpty(transportMail), "transport_mail", transportMail);                        
				String cashierPayTime = (String) params.get("cashierPayTime");        
				r.eq(ToolUtil.isNotEmpty(cashierPayTime), "cashier_pay_time", cashierPayTime);                  
				String cashierPayMethod = (String) params.get("cashierPayMethod");        
				r.eq(ToolUtil.isNotEmpty(cashierPayMethod), "cashier_pay_method", cashierPayMethod);                  
				String cashierPayProofFilepath = (String) params.get("cashierPayProofFilepath");        
				r.eq(ToolUtil.isNotEmpty(cashierPayProofFilepath), "cashier_pay_proof_filepath", cashierPayProofFilepath);                  
				String cashierReceiptNumber = (String) params.get("cashierReceiptNumber");        
				r.eq(ToolUtil.isNotEmpty(cashierReceiptNumber), "cashier_receipt_number", cashierReceiptNumber);                  
				String cashierPayMemo = (String) params.get("cashierPayMemo");        
				r.eq(ToolUtil.isNotEmpty(cashierPayMemo), "cashier_pay_memo", cashierPayMemo);                  
				String confirmPayMethod = (String) params.get("confirmPayMethod");        
				r.eq(ToolUtil.isNotEmpty(confirmPayMethod), "confirm_pay_method", confirmPayMethod);                  
				String confirmPayAmount = (String) params.get("confirmPayAmount");        
				r.eq(ToolUtil.isNotEmpty(confirmPayAmount), "confirm_pay_amount", confirmPayAmount);                        
				String confirmPaySum = (String) params.get("confirmPaySum");        
				r.eq(ToolUtil.isNotEmpty(confirmPaySum), "confirm_pay_sum", confirmPaySum);                        
				String transportTotalCost = (String) params.get("transportTotalCost");        
				r.eq(ToolUtil.isNotEmpty(transportTotalCost), "transport_total_cost", transportTotalCost);            
				Page<bpmCrmTransportEntity> page = this.baseMapper.selectPage(new Query<bpmCrmTransportEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmTransportByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmTransportById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmTransport(bpmCrmTransportEntity bpmCrmTransport){
        return this.save(bpmCrmTransport);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmTransportById(bpmCrmTransportEntity bpmCrmTransport) {
		return this.updateById(bpmCrmTransport);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmTransportEntity getbpmCrmTransportById(String id){
		return this.getById(id);
	}
}
