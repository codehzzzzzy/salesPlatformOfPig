# salesPlatformOfPig
基于springboot的猪联网平台（猪销售平台）

前端：
- 登录模块，商品页面展示模块的展示
- 购物车模块的展示
- 订单销售情况的可视化展示

后端：
- 商品管理模块，管理员模块，购物车模块，营销活动模块，订单模块的增删改查
- 使用redis实现单点登录
- 将热门商品序列化后存入redis中，下次查询时直接命中缓存，无需访问数据库，减少数据库压力
- 使用布隆过滤器，并解决缓存击穿的问题
- 基于商品销量的权重算法，并进行商品优先推荐
- 使用EasyExcel，根据订单记录生成Excel文档，方便分析销售情况
- 实现发布营销活动，包括满减等活动，使用RabbitMQ实现定时任务的发布与截止
