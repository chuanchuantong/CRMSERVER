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
 * bpm_crm_reimburse
 * @author: yhli
 * @date 2020-06-22 14:13
 */
@Data
@TableName("bpm_crm_reimburse")
public class bpmCrmReimburseEntity extends BaseEntity{

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

    /** 费用发生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date reimburseTime;

    /** 报销金额 */
    @NotNull(message = "参数值不能为空")
    private Double reimburseAmount;

    /** 凭证 */
    @NotBlank(message = "参数值不能为空")
    private String reimburseAttaFilepath;

    /** 审批金额 */
    @NotNull(message = "参数值不能为空")
    private Double cashierAmount;

    /** 出纳审批 */
    @NotNull(message = "参数值不能为空")
    private Long cashierApproval;

    /** 备注 */
    @NotBlank(message = "参数值不能为空")
    private String cashierRemark;

    /** 报销比例 */
    @NotNull(message = "参数值不能为空")
    private Double financeProportion;

    /** 报销金额 */
    @NotNull(message = "参数值不能为空")
    private Double financeAmount;

    /** 财务经理审批 */
    @NotNull(message = "参数值不能为空")
    private Long financeApproval;

    /** 备注 */
    @NotBlank(message = "参数值不能为空")
    private String financeRemark;

    /** 会计审批 */
    @NotNull(message = "参数值不能为空")
    private Long accountingApproval;

    /** 会计备注 */
    @NotBlank(message = "参数值不能为空")
    private String accountingRemark;

}
