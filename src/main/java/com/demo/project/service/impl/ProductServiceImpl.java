package com.demo.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.project.common.ErrorCode;
import com.demo.project.exception.BusinessException;
import com.demo.project.model.dto.product.ProductAddRequest;
import com.demo.project.model.entity.Product;
import com.demo.project.model.entity.User;
import com.demo.project.service.ProductService;
import com.demo.project.mapper.ProductMapper;
import com.demo.project.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
* @author hzzzzzy
* @description 针对表【product(商品)】的数据库操作Service实现
* @createDate 2023-03-17 14:44:03
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

    @Autowired
    private UserService userService;

    /**
     * 创建商品
     *
     * @param productAddRequest
     * @param request
     * @return
     */
    @Override
    public Long addProduct(ProductAddRequest productAddRequest, HttpServletRequest request) {
        if (productAddRequest == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Product product = new Product();
        BeanUtils.copyProperties(productAddRequest,product);
        User user = userService.getLoginUser(request);
        if (user == null){
            throw new BusinessException(ErrorCode.FORBIDDEN_ERROR);
        }
        Long userId = user.getId();
        product.setCreateUser(userId);
        return userId;
    }
}




