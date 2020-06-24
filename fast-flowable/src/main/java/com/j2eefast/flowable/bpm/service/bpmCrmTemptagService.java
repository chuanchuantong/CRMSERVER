package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.bpmCrmTemptagEntity;
import com.j2eefast.flowable.bpm.mapper.bpmCrmTemptagMapper;
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
 * 临牌Service接口
 * @author: yhli
 * @date 2020-06-23 18:17
 */
@Service
public class bpmCrmTemptagService extends ServiceImpl<bpmCrmTemptagMapper,bpmCrmTemptagEntity> {

	@Resource
	private bpmCrmTemptagMapper bpmCrmTemptagMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<bpmCrmTemptagEntity> r = new QueryWrapper<bpmCrmTemptagEntity>();                  
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
				r.like(ToolUtil.isNotEmpty(orderRecipientAddress), "order_recipient_address", orderRecipientAddress);                		          
				String orderRecipientPhone = (String) params.get("orderRecipientPhone");        
				r.like(ToolUtil.isNotEmpty(orderRecipientPhone), "order_recipient_phone", orderRecipientPhone);                		                
				String selectTempTagNumber = (String) params.get("selectTempTagNumber");        
				r.eq(ToolUtil.isNotEmpty(selectTempTagNumber), "select_temp_tag_number", selectTempTagNumber);                  
				String shippingInfo = (String) params.get("shippingInfo");        
				r.eq(ToolUtil.isNotEmpty(shippingInfo), "shipping_info", shippingInfo);                  
				String shippingFee = (String) params.get("shippingFee");        
				r.eq(ToolUtil.isNotEmpty(shippingFee), "shipping_fee", shippingFee);                  
				String tempTagFee = (String) params.get("tempTagFee");        
				r.eq(ToolUtil.isNotEmpty(tempTagFee), "temp_tag_fee", tempTagFee);                  
				String totalFee = (String) params.get("totalFee");        
				r.eq(ToolUtil.isNotEmpty(totalFee), "total_fee", totalFee);            
				Page<bpmCrmTemptagEntity> page = this.baseMapper.selectPage(new Query<bpmCrmTemptagEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deletebpmCrmTemptagByIds(String[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deletebpmCrmTemptagById(String id) {
		return this.removeById(id);
	}

	/**
     * 保存
     */
	public boolean savebpmCrmTemptag(bpmCrmTemptagEntity bpmCrmTemptag){
        return this.save(bpmCrmTemptag);
    }

	/**
     * 修改根居ID
     */
	public boolean updatebpmCrmTemptagById(bpmCrmTemptagEntity bpmCrmTemptag) {
		return this.updateById(bpmCrmTemptag);
	}

	/**
     * 根居ID获取对象
     */
	public bpmCrmTemptagEntity getbpmCrmTemptagById(String id){
		return this.getById(id);
	}
}
