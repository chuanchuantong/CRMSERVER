package com.j2eefast.flowable.bpm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.j2eefast.flowable.bpm.entity.BpmCrmFindListEntity;
import com.j2eefast.flowable.bpm.entity.bpmCrmSaleorderEntity;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 * bpm_crm_saleorderDAO接口
 * @author: yhli
 * @date 2020-06-15 16:42
 */
public interface bpmCrmSaleorderMapper extends BaseMapper<bpmCrmSaleorderEntity> {

    Page<BpmCrmFindListEntity> findPage(IPage<?> params,@Param("sql_filter") String sql_filter);
    
}
