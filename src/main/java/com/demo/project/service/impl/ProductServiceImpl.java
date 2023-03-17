package com.demo.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.project.model.entity.Product;
import com.demo.project.service.ProductService;
import com.demo.project.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author hzzzzzy
* @description 针对表【product(商品)】的数据库操作Service实现
* @createDate 2023-03-17 14:44:03
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




