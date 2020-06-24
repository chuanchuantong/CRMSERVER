package com.j2eefast.flowable.bpm.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.j2eefast.flowable.bpm.enums.CommentOSSType;
import com.j2eefast.system.oss.entity.SysOssEntity;
import com.j2eefast.system.oss.service.SysOssService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Oss工具类
 * @author liyah
 */
@Service
public class CommontOSSUtils {
    @Autowired
    @Lazy(value = true)
    private  SysOssService sysOssService;

    /**
     * 根据参数获取上传地址
     * @param updateStatus
     * @param saleCode
     * @return
     */
    public  List<SysOssEntity> selectListByType(Integer updateStatus,String saleCode){
        try{
            QueryWrapper<SysOssEntity> ew = new QueryWrapper<SysOssEntity>();
            ew.eq("update_status", updateStatus)
                    .eq("crm_sale_code",saleCode);
            return  sysOssService.queryParams(ew);
        }catch (Exception ex){
            return new ArrayList<>();
        }

    }
}
