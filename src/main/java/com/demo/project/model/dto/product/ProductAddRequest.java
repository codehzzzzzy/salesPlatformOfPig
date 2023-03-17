package com.demo.project.model.dto.product;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductAddRequest implements Serializable {
    /**
     * 商品id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 商品图片url
     */
    private String url;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 商品库存
     */
    private BigDecimal inventory;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 生产日期
     */
    private LocalDate productDay;

    /**
     * 保质期
     */
    private String shelfLife;

    /**
     * 销售斤数
     */
    private BigDecimal sales;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}
