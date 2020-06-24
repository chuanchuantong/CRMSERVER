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
 * Clue
 * @author: yhli
 * @date 2020-06-19 14:19
 */
@Data
@TableName("Clue")
public class ClueEntity extends BaseEntity{

    /** Id */ 

	@TableId(type = IdType.AUTO)
    private Long Id;
    /** 简称 */
    private String ShortHand;

    /** 来源 */
    private String Source;

    /** 客户名称 */
    private String CustomerName;

    /** 客户地址 */
    private String CustomerAddress;

    /** 联系方式 */
    private String ContactInfo;

    /** 专业/行业 */
    private String Industry;

    /** 意向车型 */
    private String IntentionCar;

    /** 需求 */
    private String Needs;

    /** 预算 */
    private String Budget;

    /** 是否持币 */
    private String IsHoldCash;

    /** 现有车型 */
    private String ExitsCar;

    /** 计划提车时间 */
    private String PlanTime;

    /** 订单状态 -1 草稿  0 已提交 1待审批 2 已审批 3 已完成 */
    private Long CStatus;

    /** 销售提成 */
    private Double Royalty;

    /** OA */
    private Long OAId;

    /** 客户级别 */
    private String Level;

    /** 客户特点 */
    private String CuStyles;

    /** 创建人 */
    private Long CreateId;

    /** 修改人 */
    private Long UpdateId;

    /** 订单编号 */
    private String FCode;

    /** 用户id */
    private Long UserId;

    /** 备注 */
    private String Remarks;

    /** 客户信任度 单选按钮（A+，A，A-） 2020-06-09新增需求 */
    private String Trusts;

}
