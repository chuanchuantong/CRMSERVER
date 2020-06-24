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
 * bpm_crm_transfer
 * @author: yhli
 * @date 2020-06-23 10:48
 */
@Data
@TableName("bpm_crm_transfer")
public class bpmCrmTransferEntity extends BaseEntity{

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

    /** 特殊备注 */
    @NotBlank(message = "参数值不能为空")
    private String orderSpecialRemark;

    /** 出纳审核 */
    @NotNull(message = "参数值不能为空")
    private Long orderCashierReview;

    /** 财务经理审核 */
    @NotNull(message = "参数值不能为空")
    private Long orderFinanceManagerReview;

    /** 客户ssn */
    @NotBlank(message = "参数值不能为空")
    private String orderCustomerSsn;

    /** 客户I-20附件 */
    @NotBlank(message = "参数值不能为空")
    private String orderCustomerIFilepath;

    /** 注册人姓名 */
    @NotBlank(message = "参数值不能为空")
    private String orderRegistrantName;

    /** 注册人地址 */
    @NotBlank(message = "参数值不能为空")
    private String orderRegistrantAddress;

    /** 注册人手机 */
    @NotBlank(message = "参数值不能为空")
    private String orderRegistrantPhone;

    /** 是否需要邮件 */
    @NotNull(message = "参数值不能为空")
    private Long orderIsNeedMail;

    /** 收件人是否同注册人 */
    @NotNull(message = "参数值不能为空")
    private Long orderRecipientisregistrant;

    /** 收件人姓名 */
    @NotBlank(message = "参数值不能为空")
    private String orderRecipientName;

    /** 收件人地址 */
    @NotBlank(message = "参数值不能为空")
    private String orderRecipientAddress;

    /** 收件人手机 */
    @NotBlank(message = "参数值不能为空")
    private String orderRecipientPhone;

    /** 邮件备注 */
    @NotBlank(message = "参数值不能为空")
    private String orderRecipientMailMemo;

    /** 税 */
    @NotNull(message = "参数值不能为空")
    private Double taxAmount;

    /** 手续费 */
    @NotNull(message = "参数值不能为空")
    private Double taxServiceCharge;

    /** 运费 */
    @NotNull(message = "参数值不能为空")
    private Double taxFreight;

    /** 航运信息 */
    @NotBlank(message = "参数值不能为空")
    private String taxShippingInfo;

    /** 过户日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date taxTransferDate;

    /** 选择出库单 */
    @NotBlank(message = "参数值不能为空")
    private String outboundPrimarkKey;

}
