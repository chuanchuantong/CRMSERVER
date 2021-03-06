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
 * bpm_crm_substitution
 * @author: yhli
 * @date 2020-06-22 10:42
 */
@Data
@TableName("bpm_crm_substitution")
public class bpmCrmSubstitutionEntity extends BaseEntity{

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

    /** 换入车辆识别号 */
    @NotBlank(message = "参数值不能为空")
    private String inCarVin;

    /** 换入车辆/车型 */
    @NotBlank(message = "参数值不能为空")
    private String inCarVehicle;

    /** 车辆里程 */
    @NotNull(message = "参数值不能为空")
    private Long inCarMileage;

    /** 要价/置换价 */
    @NotNull(message = "参数值不能为空")
    private Double inCarAskprice;

    /** 折价备注 */
    private String inCarTradememo;

    /** 审核备注 */
    private String purchaseRemark;

    /** 是否收购 */
    @NotNull(message = "参数值不能为空")
    private Long purchaseIsbuy;

    /** 估价 */
    @NotNull(message = "参数值不能为空")
    private Double purchaseEvaluation;

    /** 入库检查 */
    @NotNull(message = "参数值不能为空")
    private Long warehouseInCheck;

    /** 入库估价 */
    @NotNull(message = "参数值不能为空")
    private Double warehouseInEvaluation;

    /** 入库备注 */
    private String warehouseInRemark;

    /** 入库文件 */
    private Long warehouseInFile;

    /** 入库文件路径 */
    private String filehumanInFilepath;

    /** 入库备注 */
    @NotBlank(message = "参数值不能为空")
    private String filehumanInRemark;

    /** 出纳审核 */
    @NotNull(message = "参数值不能为空")
    private Long checkmoneyCashierReview;

    /** 证明 */
    @NotBlank(message = "参数值不能为空")
    private String checkmoneyProofpath;

    /** 贷款金额审核 */
    @NotNull(message = "参数值不能为空")
    private Double checkmoneyLoanamountreceived;

    /** 收据编号 */
    @NotBlank(message = "参数值不能为空")
    private String checkmoneyReceiptnumber;

    /** 出纳备注/备忘录 */
    @NotBlank(message = "参数值不能为空")
    private String checkmoneyMemo;

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
