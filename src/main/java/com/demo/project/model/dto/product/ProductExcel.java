package com.demo.project.model.dto.product;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProductExcel {
    /**
     * 商品id
     */
    @ExcelProperty("商品id")
    private Long id;

    /**
     * 商品名称
     */
    @ExcelProperty("商品名称")
    private String name;

    /**
     * 商品描述
     */
    @ExcelProperty("商品描述")
    private String description;

    /**
     * 商品单价
     */
    @ExcelProperty("商品单价")
    private BigDecimal price;

    /**
     * 商品图片url
     */
    @ExcelProperty("商品图片url")
    private String url;

    /**
     * 创建人
     */
    @ExcelProperty("创建人")
    private Long createUser;

    /**
     * 商品库存
     */
    @ExcelProperty("商品库存")
    private BigDecimal inventory;

    /**
     * 修改人
     */
    @ExcelProperty("修改人")
    private Long updateUser;

    /**
     * 生产日期
     */
    @ExcelProperty("生产日期")
    private LocalDate productDay;

    /**
     * 保质期
     */
    @ExcelProperty("保质期")
    private String shelfLife;

    /**
     * 销售斤数
     */
    @ExcelProperty("销售斤数")
    private BigDecimal sales;

    /**
     * 是否删除
     */
    @ExcelProperty("是否删除")
    private Integer isDeleted;
}
