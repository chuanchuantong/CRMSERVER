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
 * bpm_crm_remittance
 * @author: yhli
 * @date 2020-06-22 13:38
 */
@Data
@TableName("bpm_crm_remittance")
public class bpmCrmRemittanceEntity extends BaseEntity{

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
    private Date remittanceCostTime;

    /** 报销金额 */
    @NotNull(message = "参数值不能为空")
    private Double remittancereimburseAmount;

    /** 凭证 */
    @NotBlank(message = "参数值不能为空")
    private String remittanceVoucherFilepath;

    /** 备注 */
    @NotBlank(message = "参数值不能为空")
    private String remittanceRemark;

    /** 首选付款方式 */
    @NotNull(message = "参数值不能为空")
    private Long remittanceFirstPaymethod;

    /** 备忘录 */
    @NotBlank(message = "参数值不能为空")
    private String remittanceMemo;

    /** 收件人姓名 */
    @NotBlank(message = "参数值不能为空")
    private String remittanceRecipientName;

    /** 收件人地址 */
    @NotBlank(message = "参数值不能为空")
    private String remittanceRecipientAddress;

    /** 收件人手机 */
    @NotBlank(message = "参数值不能为空")
    private String remittanceRecipientPhone;

    /** 金额 */
    @NotNull(message = "参数值不能为空")
    private Double remittanceAccount;

    /** 汇款路径号码 */
    @NotBlank(message = "参数值不能为空")
    private String remittanceRouting;

    /** 银行地址 */
    @NotBlank(message = "参数值不能为空")
    private String remittanceBankaddress;

    /** 人民币汇款方式 */
    @NotNull(message = "参数值不能为空")
    private Long remittanceRmbPaymethod;

    /** 银行名称 */
    @NotBlank(message = "参数值不能为空")
    private String remittanceRmbBankname;

    /** 银行账户 */
    @NotBlank(message = "参数值不能为空")
    private String remittanceRmbBankaccount;

    /** 账户名注 */
    @NotBlank(message = "参数值不能为空")
    private String remittanceRmbAccountname;

    /** 审批金额 */
    @NotNull(message = "参数值不能为空")
    private Double approvalAmount;

    /** 出纳审批 */
    @NotNull(message = "参数值不能为空")
    private Long approvalCashier;

    /** 出纳备注 */
    @NotBlank(message = "参数值不能为空")
    private String approvalCashierRemark;

    /** 比例 */
    @NotNull(message = "参数值不能为空")
    private Double reimburseProportion;

    /** 金额 */
    @NotNull(message = "参数值不能为空")
    private Double reimburseAmount;

    /** 财务经理审批 */
    @NotNull(message = "参数值不能为空")
    private Long reimburseFinanceapproval;

    /** 财务经理备注 */
    @NotBlank(message = "参数值不能为空")
    private String reimburseFinanceremark;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date payTime;

    /** 付款记录 */
    @NotNull(message = "参数值不能为空")
    private Long payMethod;

    /** 附件 */
    @NotBlank(message = "参数值不能为空")
    private String payProofFilepath;

    /** 接收人号码 */
    @NotBlank(message = "参数值不能为空")
    private String payReceiptNumber;

    /** 备忘录 */
    @NotBlank(message = "参数值不能为空")
    private String payMemo;

    /** 结果 */
    @NotNull(message = "参数值不能为空")
    private Long cashierResult;

    /** 金额 */
    @NotNull(message = "参数值不能为空")
    private Double cashierAmount;

    /** 备忘录 */
    @NotBlank(message = "参数值不能为空")
    private String cashierMemo;

    /** 付款总额 */
    @NotNull(message = "参数值不能为空")
    private Double cashierPaysumamount;

    /** 备忘录 */
    @NotBlank(message = "参数值不能为空")
    private String memo;

}
