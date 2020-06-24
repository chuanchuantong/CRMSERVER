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
 * bpm_crm_endorder
 * @author: yhli
 * @date 2020-06-23 10:48
 */
@Data
@TableName("bpm_crm_endorder")
public class bpmCrmEndorderEntity extends BaseEntity{

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

    /** 车辆识别号 */
    @NotBlank(message = "参数值不能为空")
    private String outCarVin;

    /** 车型 */
    @NotBlank(message = "参数值不能为空")
    private String outCarVehicle;

    /** 结束类型  正常结束/取消订单 */
    @NotNull(message = "参数值不能为空")
    private Long orderEndType;

    /** 备注 */
    @NotBlank(message = "参数值不能为空")
    private String orderMemo;

    /** 实收总和 */
    @NotNull(message = "参数值不能为空")
    private Double creditRealitySum;

    /** 收款单据 */
    @NotBlank(message = "参数值不能为空")
    private String creditBillFilepath;

    /** 类别 */
    @NotBlank(message = "参数值不能为空")
    private String costType;

    /** 金额 */
    @NotNull(message = "参数值不能为空")
    private Long costAmount;

    /** 流程单据 */
    @NotBlank(message = "参数值不能为空")
    private String costAllBusinessFilepath;

    /** 实收总和 */
    @NotNull(message = "参数值不能为空")
    private Long commissionRealitySum;

    /** 目前成本 */
    @NotNull(message = "参数值不能为空")
    private Double commissionCurrentCost;

    /** 最终利润 */
    @NotNull(message = "参数值不能为空")
    private Double commissionFinalProfit;

    /** 最终业绩 */
    @NotNull(message = "参数值不能为空")
    private Double commissionFinalAchievement;

    /** 提成比例 */
    @NotNull(message = "参数值不能为空")
    private Double commissionPercentage;

    /** 最终提成 */
    @NotNull(message = "参数值不能为空")
    private Double commissionFinalCommission;

    /** 销售总监审核 */
    @NotNull(message = "参数值不能为空")
    private Long approvalSalesDirector;

    /** 审查备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalSalesDirectorMemo;

    /** 整修评审/复盘/整理评审意见（pass return） */
    @NotNull(message = "参数值不能为空")
    private Long approvalReconditioning;

    /** 审查备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalReconditioningMemo;

    /** 维修中心审核 */
    @NotNull(message = "参数值不能为空")
    private Long approvalMaintenanceCenter;

    /** 审查备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalMaintenanceCenterMemo;

    /** 运输审核 */
    @NotNull(message = "参数值不能为空")
    private Long approvalTransport;

    /** 审查备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalTransportMemo;

    /** 出纳审核 */
    @NotNull(message = "参数值不能为空")
    private Long approvalCashier;

    /** 审查备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalCashierMemo;

    /** 盘点 */
    @NotNull(message = "参数值不能为空")
    private Long approvalInventory;

    /** 审查备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalInventoryMemo;

    /** 税务审核 */
    @NotNull(message = "参数值不能为空")
    private Long approvalTax;

    /** 审查备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalTaxMemo;

    /** 会计审核 */
    @NotNull(message = "参数值不能为空")
    private Long approvalAccounting;

    /** 审查备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalAccountingMemo;

    /** 销售总监审核 */
    @NotNull(message = "参数值不能为空")
    private Long approvalSalesDirectorReview;

    /** 审查备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalSalesDirectorReviewMemo;

}
