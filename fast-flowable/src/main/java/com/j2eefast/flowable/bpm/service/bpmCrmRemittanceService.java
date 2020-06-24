package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmRemittanceEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmRemittanceMapper;
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
 * 汇款信息Service接口
 * @author: yhli
 * @date 2020-06-22 13:38
 */
@Service
public class bpmCrmRemittanceService extends ServiceImpl<bpmCrmRemittanceMapper,bpmCrmRemittanceEntity> {

	@Resource
	private bpmCrmRemittanceMapper bpmCrmRemittanceMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmRemittanceEntity> r = new QueryWrapper<bpmCrmRemittanceEntity>();                  
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
				String remittanceCostTime = (String) params.get("remittanceCostTime");        
				r.eq(ToolUtil.isNotEmpty(remittanceCostTime), "remittance_cost_time", remittanceCostTime);                  
				String remittancereimburseAmount = (String) params.get("remittancereimburseAmount");        
				r.eq(ToolUtil.isNotEmpty(remittancereimburseAmount), "remittance_reimburse_amount", remittancereimburseAmount);
				String remittanceVoucherFilepath = (String) params.get("remittanceVoucherFilepath");        
				r.eq(ToolUtil.isNotEmpty(remittanceVoucherFilepath), "remittance_voucher_filepath", remittanceVoucherFilepath);                  
				String remittanceRemark = (String) params.get("remittanceRemark");        
				r.eq(ToolUtil.isNotEmpty(remittanceRemark), "remittance_remark", remittanceRemark);                  
				String remittanceFirstPaymethod = (String) params.get("remittanceFirstPaymethod");        
				r.eq(ToolUtil.isNotEmpty(remittanceFirstPaymethod), "remittance_first_paymethod", remittanceFirstPaymethod);                  
				String remittanceMemo = (String) params.get("remittanceMemo");        
				r.eq(ToolUtil.isNotEmpty(remittanceMemo), "remittance_memo", remittanceMemo);                  
				String remittanceRecipientName = (String) params.get("remittanceRecipientName");        
				r.like(ToolUtil.isNotEmpty(remittanceRecipientName), "remittance_recipient_name", remittanceRecipientName);                		          
				String remittanceRecipientAddress = (String) params.get("remittanceRecipientAddress");        
				r.eq(ToolUtil.isNotEmpty(remittanceRecipientAddress), "remittance_recipient_address", remittanceRecipientAddress);                  
				String remittanceRecipientPhone = (String) params.get("remittanceRecipientPhone");        
				r.eq(ToolUtil.isNotEmpty(remittanceRecipientPhone), "remittance_recipient_phone", remittanceRecipientPhone);                  
				String remittanceAccount = (String) params.get("remittanceAccount");        
				r.eq(ToolUtil.isNotEmpty(remittanceAccount), "remittance_account", remittanceAccount);                  
				String remittanceRouting = (String) params.get("remittanceRouting");        
				r.eq(ToolUtil.isNotEmpty(remittanceRouting), "remittance_routing", remittanceRouting);                  
				String remittanceBankaddress = (String) params.get("remittanceBankaddress");        
				r.eq(ToolUtil.isNotEmpty(remittanceBankaddress), "remittance_bankaddress", remittanceBankaddress);                  
				String remittanceRmbPaymethod = (String) params.get("remittanceRmbPaymethod");        
				r.eq(ToolUtil.isNotEmpty(remittanceRmbPaymethod), "remittance_rmb_paymethod", remittanceRmbPaymethod);                  
				String remittanceRmbBankname = (String) params.get("remittanceRmbBankname");        
				r.like(ToolUtil.isNotEmpty(remittanceRmbBankname), "remittance_rmb_bankname", remittanceRmbBankname);                		          
				String remittanceRmbBankaccount = (String) params.get("remittanceRmbBankaccount");        
				r.eq(ToolUtil.isNotEmpty(remittanceRmbBankaccount), "remittance_rmb_bankaccount", remittanceRmbBankaccount);                  
				String remittanceRmbAccountname = (String) params.get("remittanceRmbAccountname");        
				r.like(ToolUtil.isNotEmpty(remittanceRmbAccountname), "remittance_rmb_accountname", remittanceRmbAccountname);                		          
				String approvalAmount = (String) params.get("approvalAmount");        
				r.eq(ToolUtil.isNotEmpty(approvalAmount), "approval_amount", approvalAmount);                  
				String approvalCashier = (String) params.get("approvalCashier");        
				r.eq(ToolUtil.isNotEmpty(approvalCashier), "approval_cashier", approvalCashier);                  
				String approvalCashierRemark = (String) params.get("approvalCashierRemark");        
				r.eq(ToolUtil.isNotEmpty(approvalCashierRemark), "approval_cashier_remark", approvalCashierRemark);                  
				String reimburseProportion = (String) params.get("reimburseProportion");        
				r.eq(ToolUtil.isNotEmpty(reimburseProportion), "reimburse_proportion", reimburseProportion);                  
				String reimburseAmount = (String) params.get("reimburseAmount");        
				r.eq(ToolUtil.isNotEmpty(reimburseAmount), "reimburse_amount", reimburseAmount);                  
				String reimburseFinanceapproval = (String) params.get("reimburseFinanceapproval");        
				r.eq(ToolUtil.isNotEmpty(reimburseFinanceapproval), "reimburse_financeapproval", reimburseFinanceapproval);                  
				String reimburseFinanceremark = (String) params.get("reimburseFinanceremark");        
				r.eq(ToolUtil.isNotEmpty(reimburseFinanceremark), "reimburse_financeremark", reimburseFinanceremark);                  
				String payTime = (String) params.get("payTime");        
				r.eq(ToolUtil.isNotEmpty(payTime), "pay_time", payTime);                  
				String payMethod = (String) params.get("payMethod");        
				r.eq(ToolUtil.isNotEmpty(payMethod), "pay_method", payMethod);                  
				String payProofFilepath = (String) params.get("payProofFilepath");        
				r.eq(ToolUtil.isNotEmpty(payProofFilepath), "pay_proof_filepath", payProofFilepath);                  
				String payReceiptNumber = (String) params.get("payReceiptNumber");        
				r.eq(ToolUtil.isNotEmpty(payReceiptNumber), "pay_receipt_number", payReceiptNumber);                  
				String payMemo = (String) params.get("payMemo");        
				r.eq(ToolUtil.isNotEmpty(payMemo), "pay_memo", payMemo);                  
				String cashierResult = (String) params.get("cashierResult");        
				r.eq(ToolUtil.isNotEmpty(cashierResult), "cashier_result", cashierResult);                  
				String cashierAmount = (String) params.get("cashierAmount");        
				r.eq(ToolUtil.isNotEmpty(cashierAmount), "cashier_amount", cashierAmount);                  
				String cashierMemo = (String) params.get("cashierMemo");        
				r.eq(ToolUtil.isNotEmpty(cashierMemo), "cashier_memo", cashierMemo);                  
				String cashierPaysumamount = (String) params.get("cashierPaysumamount");        
				r.eq(ToolUtil.isNotEmpty(cashierPaysumamount), "cashier_paysumamount", cashierPaysumamount);                  
				String memo = (String) params.get("memo");        
				r.eq(ToolUtil.isNotEmpty(memo), "memo", memo);            
				Page<bpmCrmRemittanceEntity> page = this.baseMapper.selectPage(new Query<bpmCrmRemittanceEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmRemittanceByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmRemittanceById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmRemittance(bpmCrmRemittanceEntity bpmCrmRemittance){
        return this.save(bpmCrmRemittance);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmRemittanceById(bpmCrmRemittanceEntity bpmCrmRemittance) {
		return this.updateById(bpmCrmRemittance);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmRemittanceEntity getbpmCrmRemittanceById(String id){
		return this.getById(id);
	}
}
