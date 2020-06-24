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

/**
 * bpm_crm_backcar
 * @author: yhli
 * @date 2020-06-22 18:31
 */
@Data
@TableName("bpm_crm_backcar")
public class bpmCrmBackcarEntity extends BaseEntity{

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

    /** 原因 */
    @NotBlank(message = "参数值不能为空")
    private String outCarReason;

    /** 经理审批 */
    @NotNull(message = "参数值不能为空")
    private Long salesDirectorReview;

    /** 审核备注 */
    @NotBlank(message = "参数值不能为空")
    private String salesReviewMemo;

    /** 库管-盘点 */
    @NotNull(message = "参数值不能为空")
    private Long warehouseInventoryReview;

    /** 库管-审核备注 */
    @NotBlank(message = "参数值不能为空")
    private String warehouseReviewMemo;

    /** 库管-估价金额 */
    @NotNull(message = "参数值不能为空")
    private Double warehouseAppraisalAmount;

    /** 库管-退车成本 */
    @NotNull(message = "参数值不能为空")
    private Double warehouseReturnCost;

    /** 销售总监最终审核 */
    @NotNull(message = "参数值不能为空")
    private Long salesDirectorFinalReview;

    /** 销售总监最终审核备注 */
    @NotBlank(message = "参数值不能为空")
    private String salesDirectorFinalMemo;

}
