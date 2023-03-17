package com.demo.project.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import lombok.Data;

/**
 * 订单
 * @TableName order
 */
@TableName(value ="order")
@Data
public class Order implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 订单号
     */
    private String number;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 下单时间
     */
    private LocalDate orderTime;

    /**
     * 下单用户
     */
    private Long userId;

    /**
     * 购买斤数
     */
    private BigDecimal weight;

    /**
     * 更新时间
     */
    private LocalDate updateTime;

    /**
     * 订单状态 1待付款，2待派送，3已派送，4已完成，5已取消
     */
    private Integer status;

    /**
     * 支付方式 1微信，2支付宝
     */
    private Integer method;

    /**
     * 订单总价
     */
    private BigDecimal orderPrice;

    /**
     * 订单地址
     */
    private String location;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 地址id
     */
    private Long addressBookId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}