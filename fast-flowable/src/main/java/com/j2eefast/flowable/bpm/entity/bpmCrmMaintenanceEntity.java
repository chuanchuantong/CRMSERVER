package com.j2eefast.flowable.bpm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.validation.constraints.NotBlank;
import com.baomidou.mybatisplus.annotation.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import com.j2eefast.common.core.base.entity.BaseEntity;
import java.util.Date;

/**
 * bpm_crm_maintenance
 * @author: yhli
 * @date 2020-06-23 11:51
 */
@Data
@TableName("bpm_crm_maintenance")
public class bpmCrmMaintenanceEntity extends BaseEntity{

    /** 主键 */ 
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private String id;
    /** 流程实例id */
    private String processInstanceId;

    /** 订单号 */
    private String saleCode;

    /** 创建人 */
    private Long userId;

    /** 是否删除 */
    @TableLogic
    private String delFlag;

    /** 销售员 */
    @NotNull(message = "参数值不能为空")
    private Long saleUserid;

    /** 销售订单编号 */
    @NotBlank(message = "参数值不能为空")
    private String saleOrderNumber;

    /** 车辆识别号 */
    @NotBlank(message = "参数值不能为空")
    private String outCarVin;

    /** 车型 */
    @NotBlank(message = "参数值不能为空")
    private String outCarVehicle;

    /** 联系人 */
    @NotBlank(message = "参数值不能为空")
    private String orderCarContacts;

    /** 计划入厂时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date orderCarPlanInTime;

    /** 最晚交车时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date orderCarLastDeliveryTime;

    /** 车辆位置 */
    @NotBlank(message = "参数值不能为空")
    private String orderCarPosition;

    /** 要求或问题描述 */
    @NotBlank(message = "参数值不能为空")
    private String orderCarRemark;

    /** 车辆损失图片 */
    @NotBlank(message = "参数值不能为空")
    private String orderCarLossFilepath;

    /** 预计交车时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date commissionerPlanGiveTime;

    /** 维修方法 */
    @NotBlank(message = "参数值不能为空")
    private String commissionerRepairMethod;

    /** 报价 */
    @NotNull(message = "参数值不能为空")
    private Double commissionerOffer;

    /** 报价单 */
    @NotBlank(message = "参数值不能为空")
    private String commissionerOfferFilepath;

    /** 入场检查文件 */
    @NotBlank(message = "参数值不能为空")
    private String maintenanceCheckFilepath;

    /** 维修状态 */
    @NotBlank(message = "参数值不能为空")
    private String maintenanceStatus;

    /** 维修结算单 */
    @NotBlank(message = "参数值不能为空")
    private String maintenanceSettlementFilepath;

    /** 总价 */
    @NotNull(message = "参数值不能为空")
    private Double maintenanceTotalPrice;

    /** 结算备注 */
    @NotBlank(message = "参数值不能为空")
    private String maintenanceSettlementMemo;

}
