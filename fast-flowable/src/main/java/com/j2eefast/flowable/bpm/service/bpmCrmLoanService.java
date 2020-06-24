package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmLoanEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmLoanMapper;
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
 * 贷款信息表Service接口
 * @author: yhli
 * @date 2020-06-23 22:30
 */
@Service
public class bpmCrmLoanService extends ServiceImpl<bpmCrmLoanMapper,bpmCrmLoanEntity> {

	@Resource
	private bpmCrmLoanMapper bpmCrmLoanMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmLoanEntity> r = new QueryWrapper<bpmCrmLoanEntity>();                  
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
				String loanApplyMoney = (String) params.get("loanApplyMoney");        
				r.eq(ToolUtil.isNotEmpty(loanApplyMoney), "loan_apply_money", loanApplyMoney);                  
				String loanApplyMemo = (String) params.get("loanApplyMemo");        
				r.eq(ToolUtil.isNotEmpty(loanApplyMemo), "loan_apply_memo", loanApplyMemo);                  
				String loanSpecialistReview = (String) params.get("loanSpecialistReview");        
				r.eq(ToolUtil.isNotEmpty(loanSpecialistReview), "loan_specialist_review", loanSpecialistReview);                  
				String loanContractFilepath = (String) params.get("loanContractFilepath");        
				r.eq(ToolUtil.isNotEmpty(loanContractFilepath), "loan_contract_filepath", loanContractFilepath);                  
				String loanMoney = (String) params.get("loanMoney");        
				r.eq(ToolUtil.isNotEmpty(loanMoney), "loan_money", loanMoney);                  
				String loanTitleSpecialistProcess = (String) params.get("loanTitleSpecialistProcess");        
				r.eq(ToolUtil.isNotEmpty(loanTitleSpecialistProcess), "loan_title_specialist_process", loanTitleSpecialistProcess);                  
				String loanFilepath = (String) params.get("loanFilepath");        
				r.eq(ToolUtil.isNotEmpty(loanFilepath), "loan_filepath", loanFilepath);                  
				String checkmoneyCashierReview = (String) params.get("checkmoneyCashierReview");        
				r.eq(ToolUtil.isNotEmpty(checkmoneyCashierReview), "checkmoney_cashier_review", checkmoneyCashierReview);                  
				String checkmoneyProofpath = (String) params.get("checkmoneyProofpath");        
				r.eq(ToolUtil.isNotEmpty(checkmoneyProofpath), "checkmoney_proofpath", checkmoneyProofpath);                  
				String checkmoneyLoanamountreceived = (String) params.get("checkmoneyLoanamountreceived");        
				r.eq(ToolUtil.isNotEmpty(checkmoneyLoanamountreceived), "checkmoney_loanamountreceived", checkmoneyLoanamountreceived);                  
				String checkmoneyReceiptnumber = (String) params.get("checkmoneyReceiptnumber");        
				r.eq(ToolUtil.isNotEmpty(checkmoneyReceiptnumber), "checkmoney_receiptnumber", checkmoneyReceiptnumber);                  
				String checkmoneyMemo = (String) params.get("checkmoneyMemo");        
				r.eq(ToolUtil.isNotEmpty(checkmoneyMemo), "checkmoney_memo", checkmoneyMemo);                  
				String orderTakeEffectTime = (String) params.get("orderTakeEffectTime");        
				r.eq(ToolUtil.isNotEmpty(orderTakeEffectTime), "order_take_effect_time", orderTakeEffectTime);                  
				String collectionTime = (String) params.get("collectionTime");        
				r.eq(ToolUtil.isNotEmpty(collectionTime), "collection_time", collectionTime);                        
				String interestRate = (String) params.get("interestRate");        
				r.eq(ToolUtil.isNotEmpty(interestRate), "interest_rate", interestRate);                  
				String costOfCapital = (String) params.get("costOfCapital");        
				r.eq(ToolUtil.isNotEmpty(costOfCapital), "cost_of_capital", costOfCapital);                  
				String financeManagerReview = (String) params.get("financeManagerReview");        
				r.eq(ToolUtil.isNotEmpty(financeManagerReview), "finance_manager_review", financeManagerReview);                  
				String managerReview = (String) params.get("managerReview");        
				r.eq(ToolUtil.isNotEmpty(managerReview), "manager_review", managerReview);            
				Page<bpmCrmLoanEntity> page = this.baseMapper.selectPage(new Query<bpmCrmLoanEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmLoanByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmLoanById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmLoan(bpmCrmLoanEntity bpmCrmLoan){
        return this.save(bpmCrmLoan);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmLoanById(bpmCrmLoanEntity bpmCrmLoan) {
		return this.updateById(bpmCrmLoan);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmLoanEntity getbpmCrmLoanById(String id){
		return this.getById(id);
	}
}
