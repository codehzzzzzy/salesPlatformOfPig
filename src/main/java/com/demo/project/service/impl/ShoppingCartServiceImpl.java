package com.demo.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.project.model.entity.ShoppingCart;
import com.demo.project.service.ShoppingCartService;
import com.demo.project.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Service;

/**
* @author hzzzzzy
* @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
* @createDate 2023-03-17 14:44:03
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

}




