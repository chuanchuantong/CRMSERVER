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
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.j2eefast.common.core.base.entity.BaseEntity;

/**
 * bpm_crm_saleorder
 * @author: yhli
 * @date 2020-06-15 16:42
 */
@Data
@TableName("bpm_crm_saleorder")
public class bpmCrmSaleorderEntity extends BaseEntity{

    /** 主键 */ 
    @TableId(value = "id",type = IdType.INPUT)
    private String id;
    /** 流程实例ID */
    private String processInstanceId;

    /** 订单号 */
    private String saleCode;

    /** 订单状态 */
    private Long saleStatus;

    /** 客户名称 */
    @ApiModelProperty(value = "客户名称")
    @NotBlank(message = "客户名称不能为空")
    private String saleCustomername;

    /** 客户地址 */
    @ApiModelProperty(value = "客户地址")
    @NotBlank(message = "客户地址不能为空")
    private String saleAddress;

    /** 客户手机号 */
    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String salePhone;

    /** 客户邮箱 */
    @ApiModelProperty(value = "客户邮箱")
    @NotBlank(message = "客户邮箱不能为空")
    private String saleEmail;

    /** 客户微信 */
    @ApiModelProperty(value = "客户微信")
    @NotBlank(message = "客户微信不能为空")
    private String saleWechat;

    /** ID */
    @NotNull(message = "参数值不能为空")
    private Long saleId;

    /** 驾照 */
    private String saleDriverlicense;

    /** 护照 */
    private String salePassport;

    /** 房产 */
    private String saleResidenceinfo;

    /** 销售员 */
    private String salePerson;

    /** 销售组 */
    private String saleTeam;

    /** 销售经理 */
    private String saleManager;

    /** 创建人 */
    private Long userId;

    /** 是否删除 */
    @TableLogic
    private String delFlag;

    @TableField(exist = false)
    private String fromName;
    @TableField(exist = false)
    private String modelKey;
    @TableField(exist = false)
    private Long formUserId;
}
