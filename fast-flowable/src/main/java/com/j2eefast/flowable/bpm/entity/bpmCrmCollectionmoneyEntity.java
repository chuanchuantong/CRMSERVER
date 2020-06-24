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
 * bpm_crm_collectionmoney
 * @author: yhli
 * @date 2020-06-22 11:36
 */
@Data
@TableName("bpm_crm_collectionmoney")
public class bpmCrmCollectionmoneyEntity extends BaseEntity{

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

    /** 付款方式 */
    @NotNull(message = "参数值不能为空")
    private Long paymentMethod;

    /** 交易日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date transactionDate;

    /** 输入金额 */
    @NotNull(message = "参数值不能为空")
    private Double enterAmount;

    /** 付款人姓名 */
    @NotBlank(message = "参数值不能为空")
    private String payerName;

    /** 证明/收据 */
    @NotBlank(message = "参数值不能为空")
    private String payerProofFilepath;

    /** 备注 */
    @NotBlank(message = "参数值不能为空")
    private String payerMemo;

    /** 收到金额 */
    @NotNull(message = "参数值不能为空")
    private Double amountReceived;

    /** 出纳备注 */
    @NotBlank(message = "参数值不能为空")
    private String cashierMemo;

    /** 出纳证明 */
    @NotBlank(message = "参数值不能为空")
    private String cashierProofFilepath;

    /** 收据编号 */
    @NotBlank(message = "参数值不能为空")
    private String checkmoneyReceiptnumber;

    /** 接收日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date receivedDate;

    /** 出纳审核 */
    @NotNull(message = "参数值不能为空")
    private Long cashierReview;

    /** 订单生效日 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date orderTakeEffectTime;

    /** 收款日 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date collectionTime;

    /** 间隔日 */
    private Long intervalDay;

    /** 利息率 */
    @NotNull(message = "参数值不能为空")
    private Double interestRate;

    /** 资金成本 */
    @NotNull(message = "参数值不能为空")
    private Double costOfCapital;

    /** 财务经理审核 */
    @NotNull(message = "参数值不能为空")
    private Long financeManagerReview;

    /** 经理复核 */
    @NotBlank(message = "参数值不能为空")
    private String managerReview;

}
