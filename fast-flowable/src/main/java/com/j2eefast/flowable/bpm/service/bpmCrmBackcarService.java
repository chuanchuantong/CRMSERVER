package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmBackcarEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmBackcarMapper;
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
 * 退车Service接口
 * @author: yhli
 * @date 2020-06-22 18:31
 */
@Service
public class bpmCrmBackcarService extends ServiceImpl<bpmCrmBackcarMapper,bpmCrmBackcarEntity> {

	@Resource
	private bpmCrmBackcarMapper bpmCrmBackcarMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmBackcarEntity> r = new QueryWrapper<bpmCrmBackcarEntity>();                  
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
				String salesDirectorReview = (String) params.get("salesDirectorReview");        
				r.eq(ToolUtil.isNotEmpty(salesDirectorReview), "sales_director_review", salesDirectorReview);                        
				String warehouseInventoryReview = (String) params.get("warehouseInventoryReview");        
				r.eq(ToolUtil.isNotEmpty(warehouseInventoryReview), "warehouse_inventory_review", warehouseInventoryReview);                        
				String warehouseAppraisalAmount = (String) params.get("warehouseAppraisalAmount");        
				r.eq(ToolUtil.isNotEmpty(warehouseAppraisalAmount), "warehouse_appraisal_amount", warehouseAppraisalAmount);                  
				String warehouseReturnCost = (String) params.get("warehouseReturnCost");        
				r.eq(ToolUtil.isNotEmpty(warehouseReturnCost), "warehouse_return_cost", warehouseReturnCost);                  
				String salesDirectorFinalReview = (String) params.get("salesDirectorFinalReview");        
				r.eq(ToolUtil.isNotEmpty(salesDirectorFinalReview), "sales_director_final_review", salesDirectorFinalReview);                  
				String salesDirectorFinalMemo = (String) params.get("salesDirectorFinalMemo");        
				r.eq(ToolUtil.isNotEmpty(salesDirectorFinalMemo), "sales_director_final_memo", salesDirectorFinalMemo);            
				Page<bpmCrmBackcarEntity> page = this.baseMapper.selectPage(new Query<bpmCrmBackcarEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmBackcarByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmBackcarById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmBackcar(bpmCrmBackcarEntity bpmCrmBackcar){
        return this.save(bpmCrmBackcar);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmBackcarById(bpmCrmBackcarEntity bpmCrmBackcar) {
		return this.updateById(bpmCrmBackcar);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmBackcarEntity getbpmCrmBackcarById(String id){
		return this.getById(id);
	}
}
