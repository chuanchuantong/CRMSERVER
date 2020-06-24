package com.j2eefast.flowable.bpm.service;

import com.j2eefast.flowable.bpm.entity.ClueEntity;
import com.j2eefast.flowable.bpm.mapper.ClueMapper;
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
 * 线索池Service接口
 * @author: yhli
 * @date 2020-06-19 14:19
 */
@Service
public class ClueService extends ServiceImpl<ClueMapper,ClueEntity> {

	@Resource
	private ClueMapper clueMapper;

	/**
	 * 页面分页查询
     */
	public PageUtil findPage(Map<String, Object> params) {
				QueryWrapper<ClueEntity> r = new QueryWrapper<ClueEntity>();            
				String ShortHand = (String) params.get("ShortHand");        
				r.eq(ToolUtil.isNotEmpty(ShortHand), "ShortHand", ShortHand);                  
				String Source = (String) params.get("Source");        
				r.eq(ToolUtil.isNotEmpty(Source), "Source", Source);                  
				String CustomerName = (String) params.get("CustomerName");        
				r.like(ToolUtil.isNotEmpty(CustomerName), "CustomerName", CustomerName);                		          
				String CustomerAddress = (String) params.get("CustomerAddress");        
				r.eq(ToolUtil.isNotEmpty(CustomerAddress), "CustomerAddress", CustomerAddress);                  
				String ContactInfo = (String) params.get("ContactInfo");        
				r.eq(ToolUtil.isNotEmpty(ContactInfo), "ContactInfo", ContactInfo);                  
				String Industry = (String) params.get("Industry");        
				r.eq(ToolUtil.isNotEmpty(Industry), "Industry", Industry);                  
				String IntentionCar = (String) params.get("IntentionCar");        
				r.eq(ToolUtil.isNotEmpty(IntentionCar), "IntentionCar", IntentionCar);                  
				String Needs = (String) params.get("Needs");        
				r.eq(ToolUtil.isNotEmpty(Needs), "Needs", Needs);                  
				String Budget = (String) params.get("Budget");        
				r.eq(ToolUtil.isNotEmpty(Budget), "Budget", Budget);                  
				String IsHoldCash = (String) params.get("IsHoldCash");        
				r.eq(ToolUtil.isNotEmpty(IsHoldCash), "IsHoldCash", IsHoldCash);                  
				String ExitsCar = (String) params.get("ExitsCar");        
				r.eq(ToolUtil.isNotEmpty(ExitsCar), "ExitsCar", ExitsCar);                  
				String PlanTime = (String) params.get("PlanTime");        
				r.eq(ToolUtil.isNotEmpty(PlanTime), "PlanTime", PlanTime);                  
				String CStatus = (String) params.get("CStatus");        
				r.eq(ToolUtil.isNotEmpty(CStatus), "CStatus", CStatus);                  
				String Royalty = (String) params.get("Royalty");        
				r.eq(ToolUtil.isNotEmpty(Royalty), "Royalty", Royalty);                  
				String OAId = (String) params.get("OAId");        
				r.eq(ToolUtil.isNotEmpty(OAId), "OAId", OAId);                  
				String Level = (String) params.get("Level");        
				r.eq(ToolUtil.isNotEmpty(Level), "Level", Level);                  
				String CuStyles = (String) params.get("CuStyles");        
				r.eq(ToolUtil.isNotEmpty(CuStyles), "CuStyles", CuStyles);                  
				String CreateTime = (String) params.get("CreateTime");        
				r.eq(ToolUtil.isNotEmpty(CreateTime), "CreateTime", CreateTime);                  
				String CreateId = (String) params.get("CreateId");        
				r.eq(ToolUtil.isNotEmpty(CreateId), "CreateId", CreateId);                  
				String UpdateTime = (String) params.get("UpdateTime");        
				r.eq(ToolUtil.isNotEmpty(UpdateTime), "UpdateTime", UpdateTime);                  
				String UpdateId = (String) params.get("UpdateId");        
				r.eq(ToolUtil.isNotEmpty(UpdateId), "UpdateId", UpdateId);                  
				String FCode = (String) params.get("FCode");        
				r.eq(ToolUtil.isNotEmpty(FCode), "FCode", FCode);                  
				String UserId = (String) params.get("UserId");        
				r.eq(ToolUtil.isNotEmpty(UserId), "UserId", UserId);                  
				String Remarks = (String) params.get("Remarks");        
				r.eq(ToolUtil.isNotEmpty(Remarks), "Remarks", Remarks);                  
				String Trusts = (String) params.get("Trusts");        
				r.eq(ToolUtil.isNotEmpty(Trusts), "Trusts", Trusts);            
				Page<ClueEntity> page = this.baseMapper.selectPage(new Query<ClueEntity>(params).getPage(), r);
				return new PageUtil(page);
    }

	/**
     * 批量删除
     */
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteClueByIds(Long[] ids) {
		return this.removeByIds(Arrays.asList(ids));
	}

	/**
     * 单个删除
     */
	public boolean deleteClueById(Long Id) {
		return this.removeById(Id);
	}

	/**
     * 保存
     */
	public boolean saveClue(ClueEntity clue){
        return this.save(clue);
    }

	/**
     * 修改根居ID
     */
	public boolean updateClueById(ClueEntity clue) {
		return this.updateById(clue);
	}

	/**
     * 根居ID获取对象
     */
	public ClueEntity getClueById(Long Id){
		return this.getById(Id);
	}
}
