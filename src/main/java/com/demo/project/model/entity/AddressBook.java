package com.demo.project.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import lombok.Data;

/**
 * 地址管理
 * @TableName address_book
 */
@TableName(value ="address_book")
@Data
public class AddressBook implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 性别 0 女 1 男
     */
    private Integer sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 详细地址
     */
    private String detail;

    /**
     * 默认 0 否 1是
     */
    private Integer isDefault;

    /**
     * 创建时间
     */
    private LocalDate createTime;

    /**
     * 更新时间
     */
    private LocalDate updateTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}