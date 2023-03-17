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
 * 营销活动信息
 * @TableName promotion
 */
@TableName(value ="promotion")
@Data
public class Promotion implements Serializable {
    /**
     * 营销活动id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 营销活动名称
     */
    private Integer name;

    /**
     * 开始时间
     */
    private LocalDate startTime;

    /**
     * 结束时间
     */
    private LocalDate endTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 满减金额
     */
    private BigDecimal discount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}