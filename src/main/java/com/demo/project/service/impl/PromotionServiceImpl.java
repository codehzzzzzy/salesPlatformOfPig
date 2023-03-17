package com.demo.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.project.model.entity.Promotion;
import com.demo.project.service.PromotionService;
import com.demo.project.mapper.PromotionMapper;
import org.springframework.stereotype.Service;

/**
* @author hzzzzzy
* @description 针对表【promotion(营销活动信息)】的数据库操作Service实现
* @createDate 2023-03-17 14:44:03
*/
@Service
public class PromotionServiceImpl extends ServiceImpl<PromotionMapper, Promotion>
    implements PromotionService{

}




