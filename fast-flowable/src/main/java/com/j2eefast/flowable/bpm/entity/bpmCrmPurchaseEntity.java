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
 * bpm_crm_purchase
 * @author: yhli
 * @date 2020-06-19 13:29
 */
@Data
@TableName("bpm_crm_purchase")
public class bpmCrmPurchaseEntity extends BaseEntity{

    /** 主键 */ 
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private String id;
    /** 流程实例id */
    private String processInstanceId;

    /** 订单号 */
    private String saleCode;

    /** 申请人 */
    private Long userId;

    /** 是否删除 */
    @TableLogic
    private String delFlag;

    /** 销售员 */
    private Long saleUserid;

    /** 销售订单编号 */
    @NotBlank(message = "参数值不能为空")
    private String saleOrderNumber;

    /** 合同价格 */
    @NotNull(message = "参数值不能为空")
    private Double orderContractPrice;

    /** 是否含税 */
    @NotNull(message = "参数值不能为空")
    private Long orderIsTax;

    /** 是否包含运输费用 */
    @NotNull(message = "参数值不能为空")
    private Long orderIsTransport;

    /** 是否保修 */
    @NotNull(message = "参数值不能为空")
    private Long orderIsGuarantee;

    /** 其他 */
    @NotBlank(message = "参数值不能为空")
    private String orderOtherItem;

    /** 车辆识别号 */
    @NotBlank(message = "参数值不能为空")
    private String carVin;

    /** 车辆 */
    @NotBlank(message = "参数值不能为空")
    private String carVehicle;

    /** 里程 */
    @NotNull(message = "参数值不能为空")
    private Double carMileage;

    /** 变速箱  */
    @NotNull(message = "参数值不能为空")
    private Long carTranmission;

    /** 驱动形式 */
    @NotNull(message = "参数值不能为空")
    private Long carDrivertrain;

    /** 车况 */
    @NotNull(message = "参数值不能为空")
    private Long carStatus;

    /** 最高价 */
    @NotNull(message = "参数值不能为空")
    private Double channelHighestPrice;

    /** 采购来源 */
    @NotNull(message = "参数值不能为空")
    private Long channelPurchaseSource;

    /** 是否公开销售 */
    @NotNull(message = "参数值不能为空")
    private Long channelIsOpenSale;

    /** 拍卖  */
    @NotNull(message = "参数值不能为空")
    private Long channelAuction;

    /** 拍卖类型 */
    @NotNull(message = "参数值不能为空")
    private Long channelAuctionType;

    /** 拍卖时间类型 */
    @NotBlank(message = "参数值不能为空")
    private String channelAuctionTimeType;

    /** 拍卖时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date channelAuctionTime;

    /** 卖方名称 */
    @NotBlank(message = "参数值不能为空")
    private String channelSellerName;

    /** 卖方联系方式 */
    @NotBlank(message = "参数值不能为空")
    private String channelSellerContactinfo;

    /** 采购备注 */
    @NotBlank(message = "参数值不能为空")
    private String channelPurchaseMemo;

    /** 采购专员 */
    @NotBlank(message = "参数值不能为空")
    private String managerPurchaseSpecialist;

    /** 审查 */
    @NotBlank(message = "参数值不能为空")
    private String managerReview;

    /** 审查备注 */
    @NotBlank(message = "参数值不能为空")
    private String managerReviewMemo;

    /** 是否采购 */
    @NotNull(message = "参数值不能为空")
    private Long managerIsPurchase;

    /** 采购结果 */
    @NotNull(message = "参数值不能为空")
    private Long purchaseResult;

    /** 结果时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date purchaseResultTime;

    /** 结果备注 */
    @NotBlank(message = "参数值不能为空")
    private String purchaseResultMemo;

    /** 是否入库 */
    @NotNull(message = "参数值不能为空")
    private Long isWarehousing;

    /** 付款发送日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    @NotNull(message = "参数值不能为空")
    private Date cashierPaySentTime;

    /** 付款方式 */
    @NotNull(message = "参数值不能为空")
    private Long cashierPayMethod;

    /** 证明 */
    @NotBlank(message = "参数值不能为空")
    private String cashierProofFilepath;

    /** 收据单号 */
    @NotBlank(message = "参数值不能为空")
    private String cashierReceiptNumber;

    /** 出纳付款备注 */
    @NotBlank(message = "参数值不能为空")
    private String cashierMemo;

    /** 支付结果 */
    @NotNull(message = "参数值不能为空")
    private Long confirmPayMethod;

    /** 金额 */
    @NotNull(message = "参数值不能为空")
    private Double confirmPayAmount;

    /** 确认走账备注 */
    @NotBlank(message = "参数值不能为空")
    private String confirmMemo;

    /** 付款总额 */
    @NotNull(message = "参数值不能为空")
    private Double purchasePaySum;

    /** 采购备注 */
    @NotBlank(message = "参数值不能为空")
    private String purchaseRemark;

}
