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
 * bpm_crm_temptag
 * @author: yhli
 * @date 2020-06-23 18:17
 */
@Data
@TableName("bpm_crm_temptag")
public class bpmCrmTemptagEntity extends BaseEntity{

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
    private String orderRecipientName;

    /** 收件人地址 */
    private String orderRecipientAddress;

    /** 收件人手机 */
    private String orderRecipientPhone;

    /** 邮件备注 */
    private String orderRecipientMailMemo;

    /** 选择临时号牌 */
    @NotBlank(message = "参数值不能为空")
    private String selectTempTagNumber;

    /** 发货信息 */
    @NotBlank(message = "参数值不能为空")
    private String shippingInfo;

    /** 运费 */
    @NotNull(message = "参数值不能为空")
    private Double shippingFee;

    /** 临牌费 */
    @NotNull(message = "参数值不能为空")
    private Double tempTagFee;

    /** 总费用 */
    @NotNull(message = "参数值不能为空")
    private Double totalFee;

}
