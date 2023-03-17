package com.demo.project.service;

import com.demo.project.model.dto.product.ProductAddRequest;
import com.demo.project.model.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author hzzzzzy
* @description 针对表【product(商品)】的数据库操作Service
* @createDate 2023-03-17 14:44:03
*/
public interface ProductService extends IService<Product> {


    /**
     * 添加商品
     *
     * @param productAddRequest
     * @param request
     * @return
     */
    Long addProduct(ProductAddRequest productAddRequest, HttpServletRequest request);
}
