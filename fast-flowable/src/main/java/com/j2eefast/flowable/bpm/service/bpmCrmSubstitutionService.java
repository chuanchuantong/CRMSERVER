package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmSubstitutionEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmSubstitutionMapper;
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
 * 置换信息表Service接口
 * @author: yhli
 * @date 2020-06-22 10:42
 */
@Service
public class bpmCrmSubstitutionService extends ServiceImpl<bpmCrmSubstitutionMapper,bpmCrmSubstitutionEntity> {

	@Resource
	private bpmCrmSubstitutionMapper bpmCrmSubstitutionMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmSubstitutionEntity> r = new QueryWrapper<bpmCrmSubstitutionEntity>();            
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
				String outCarVin = (String) params.get("outCarVin");        
				r.eq(ToolUtil.isNotEmpty(outCarVin), "out_car_vin", outCarVin);                  
				String outCarVehicle = (String) params.get("outCarVehicle");        
				r.eq(ToolUtil.isNotEmpty(outCarVehicle), "out_car_vehicle", outCarVehicle);                  
				String inCarVin = (String) params.get("inCarVin");        
				r.eq(ToolUtil.isNotEmpty(inCarVin), "in_car_vin", inCarVin);                  
				String inCarVehicle = (String) params.get("inCarVehicle");        
				r.eq(ToolUtil.isNotEmpty(inCarVehicle), "in_car_vehicle", inCarVehicle);                  
				String inCarMileage = (String) params.get("inCarMileage");        
				r.eq(ToolUtil.isNotEmpty(inCarMileage), "in_car_mileage", inCarMileage);                  
				String inCarAskprice = (String) params.get("inCarAskprice");        
				r.eq(ToolUtil.isNotEmpty(inCarAskprice), "in_car_askprice", inCarAskprice);                  
				String inCarTradememo = (String) params.get("inCarTradememo");        
				r.eq(ToolUtil.isNotEmpty(inCarTradememo), "in_car_tradememo", inCarTradememo);                  
				String purchaseRemark = (String) params.get("purchaseRemark");        
				r.eq(ToolUtil.isNotEmpty(purchaseRemark), "purchase_remark", purchaseRemark);                  
				String purchaseIsbuy = (String) params.get("purchaseIsbuy");        
				r.eq(ToolUtil.isNotEmpty(purchaseIsbuy), "purchase_isbuy", purchaseIsbuy);                  
				String purchaseEvaluation = (String) params.get("purchaseEvaluation");        
				r.eq(ToolUtil.isNotEmpty(purchaseEvaluation), "purchase_evaluation", purchaseEvaluation);                  
				String warehouseInCheck = (String) params.get("warehouseInCheck");        
				r.eq(ToolUtil.isNotEmpty(warehouseInCheck), "warehouse_in_check", warehouseInCheck);                  
				String warehouseInEvaluation = (String) params.get("warehouseInEvaluation");        
				r.eq(ToolUtil.isNotEmpty(warehouseInEvaluation), "warehouse_in_evaluation", warehouseInEvaluation);                  
				String warehouseInRemark = (String) params.get("warehouseInRemark");        
				r.eq(ToolUtil.isNotEmpty(warehouseInRemark), "warehouse_in_remark", warehouseInRemark);                  
				String warehouseInFile = (String) params.get("warehouseInFile");        
				r.eq(ToolUtil.isNotEmpty(warehouseInFile), "warehouse_in_file", warehouseInFile);                  
				String filehumanInFilepath = (String) params.get("filehumanInFilepath");        
				r.eq(ToolUtil.isNotEmpty(filehumanInFilepath), "filehuman_in_filepath", filehumanInFilepath);                  
				String filehumanInRemark = (String) params.get("filehumanInRemark");        
				r.eq(ToolUtil.isNotEmpty(filehumanInRemark), "filehuman_in_remark", filehumanInRemark);                  
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
				Page<bpmCrmSubstitutionEntity> page = this.baseMapper.selectPage(new Query<bpmCrmSubstitutionEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmSubstitutionByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmSubstitutionById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmSubstitution(bpmCrmSubstitutionEntity bpmCrmSubstitution){
        return this.save(bpmCrmSubstitution);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmSubstitutionById(bpmCrmSubstitutionEntity bpmCrmSubstitution) {
		return this.updateById(bpmCrmSubstitution);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmSubstitutionEntity getbpmCrmSubstitutionById(String id){
		return this.getById(id);
	}
}
