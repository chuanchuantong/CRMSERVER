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
 * bpm_crm_preparation
 * @author: yhli
 * @date 2020-06-23 11:26
 */
@Data
@TableName("bpm_crm_preparation")
public class bpmCrmPreparationEntity extends BaseEntity{

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

    /** 备注 */
    @NotBlank(message = "参数值不能为空")
    private String orderMemo;

    /** 服务地点 */
    @NotNull(message = "参数值不能为空")
    private Long preparationServicePlace;

    /** 服务类型 */
    @NotNull(message = "参数值不能为空")
    private Long preparationServiceType;

    /** 服务备忘录 */
    @NotBlank(message = "参数值不能为空")
    private String preparationServiceMemo;

    /** 发票单号 */
    @NotBlank(message = "参数值不能为空")
    private String preparationInvoiceNumber;

    /** 发票附件 */
    @NotBlank(message = "参数值不能为空")
    private String preparationInvoiceFilepath;

    /** 实际金额 */
    @NotNull(message = "参数值不能为空")
    private Double preparationActualAmount;

}
