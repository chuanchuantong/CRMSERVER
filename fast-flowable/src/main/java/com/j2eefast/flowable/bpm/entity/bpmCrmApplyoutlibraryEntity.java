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
 * bpm_crm_applyoutlibrary
 * @author: yhli
 * @date 2020-06-23 14:05
 */
@Data
@TableName("bpm_crm_applyoutlibrary")
public class bpmCrmApplyoutlibraryEntity extends BaseEntity{

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

    /** 合同价 */
    @NotNull(message = "参数值不能为空")
    private Double orderContractPrice;

    /** 是否包税 */
    @NotNull(message = "参数值不能为空")
    private Long orderIsTax;

    /** 是否包运输 */
    @NotNull(message = "参数值不能为空")
    private Long orderIsTransport;

    /** 是否保修 */
    @NotNull(message = "参数值不能为空")
    private Long orderIsGuarantee;

    /** 其他项目 */
    @NotBlank(message = "参数值不能为空")
    private String orderOtherProject;

    /** 选择库存id */
    @NotBlank(message = "参数值不能为空")
    private String carStockId;

    /** 车辆识别码 */
    @NotBlank(message = "参数值不能为空")
    private String carVin;

    /** 车辆型号 */
    @NotBlank(message = "参数值不能为空")
    private String carVehicle;

    /** 库存成本 */
    @NotNull(message = "参数值不能为空")
    private Double carStockCost;

    /** 是否通过审批 */
    @NotNull(message = "参数值不能为空")
    private Long approvalIsCross;

    /** 审批备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalRemark;

    /** 审批日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date approvalTime;

}
