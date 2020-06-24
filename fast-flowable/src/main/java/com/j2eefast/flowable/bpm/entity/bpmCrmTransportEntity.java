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
 * bpm_crm_transport
 * @author: yhli
 * @date 2020-06-23 13:39
 */
@Data
@TableName("bpm_crm_transport")
public class bpmCrmTransportEntity extends BaseEntity{

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

    /** 提车地点 */
    @NotNull(message = "参数值不能为空")
    private Long transportTakeCarPlace;

    /** 选择同事 */
    @NotBlank(message = "参数值不能为空")
    private String transportSelectColleague;

    /** 提车地址 */
    @NotBlank(message = "参数值不能为空")
    private String transportTakeCarAddress;

    /** 提车电话 */
    @NotBlank(message = "参数值不能为空")
    private String transportTakeCarPhone;

    /** 送车地点 */
    @NotNull(message = "参数值不能为空")
    private Long transportGiveCarPlace;

    /** 选择同事 */
    @NotBlank(message = "参数值不能为空")
    private String transportGiveSelectColleague;

    /** 送车地址 */
    @NotBlank(message = "参数值不能为空")
    private String transportGiveCarAddress;

    /** 送车电话 */
    @NotBlank(message = "参数值不能为空")
    private String transportGiveCarPhone;

    /** 运输状态 */
    @NotNull(message = "参数值不能为空")
    private Long approvalCurrentStatus;

    /** 状态备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalCurrentStatusMemo;

    /** 计划提车时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date approvalPlanTakeCarTime;

    /** 预计到达日 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date approvalPlanArriveTime;

    /** 订单ID */
    @NotBlank(message = "参数值不能为空")
    private String approvalOrderid;

    /** 调度费用 */
    @NotNull(message = "参数值不能为空")
    private Double approvalCentralDispatchFee;

    /** 运输公司名字 */
    @NotBlank(message = "参数值不能为空")
    private String transportCompanyName;

    /** 运输公司支票接收地址 */
    @NotBlank(message = "参数值不能为空")
    private String transportCompanyCheckAddress;

    /** 邮寄方式 */
    @NotNull(message = "参数值不能为空")
    private Long transportMail;

    /** 备注 */
    @NotBlank(message = "参数值不能为空")
    private String transportRemark;

    /** 付款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date cashierPayTime;

    /** 汇款方式 */
    @NotNull(message = "参数值不能为空")
    private Long cashierPayMethod;

    /** 证明 */
    @NotBlank(message = "参数值不能为空")
    private String cashierPayProofFilepath;

    /** 收据单号 */
    @NotBlank(message = "参数值不能为空")
    private String cashierReceiptNumber;

    /** 备注 */
    @NotBlank(message = "参数值不能为空")
    private String cashierPayMemo;

    /** 支付结果 */
    @NotNull(message = "参数值不能为空")
    private Long confirmPayMethod;

    /** 金额 */
    @NotNull(message = "参数值不能为空")
    private Double confirmPayAmount;

    /** 备注 */
    @NotBlank(message = "参数值不能为空")
    private String confirmPayMemo;

    /** 付款总额 */
    @NotNull(message = "参数值不能为空")
    private Double confirmPaySum;

    /** 运输备注 */
    @NotBlank(message = "参数值不能为空")
    private String transportMemo;

    /** 运输总费用 */
    @NotNull(message = "参数值不能为空")
    private Double transportTotalCost;

}
