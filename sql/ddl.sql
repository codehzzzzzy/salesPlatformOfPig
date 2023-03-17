-- 创建库
create database if not exists my_db;
-- 切换库
use my_db;
-- 用户表
create table user
(
    id           bigint(20) auto_increment comment 'id' primary key,
    username     varchar(256)                           null comment '用户昵称',
    user_account  varchar(256)                           not null comment '账号',
    role          varchar(256)                                not null comment 'user / admin',
    user_password varchar(512)                           not null comment '密码',
    create_time   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete     tinyint      default 0                 not null comment '是否删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin comment '用户';

-- 商品表
create table product
(
    id                  bigint auto_increment comment 'id' primary key comment '商品id',
    `name`              varchar(256)                           not null comment '商品名称',
    description         varchar(256)                           null comment '商品描述',
    weight              DECIMAL(8,2)      default 0.0          not null comment '权重',
    price               DECIMAL(8,2)                           not null comment '商品单价',
    url                 varchar(256)                           not null comment '商品图片url',
    create_user         bigint(20)                             NOT NULL comment '创建人',
    inventory           DECIMAL(10,2)                             NOT NULL comment '商品库存',
    update_user         bigint(20)                             NOT NULL comment '修改人',
    create_time         datetime      default CURRENT_TIMESTAMP  NOT NULL comment '创建时间',
    update_time         datetime      default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP NOT NULL comment '更新时间',
    product_day          datetime                               NOT NULL comment '生产日期',
    shelf_life           varchar(256)                           NOT NULL comment '保质期',
    sales               DECIMAL(8,2)                            NOT NULL comment '销售斤数',
    is_deleted         int(11)                                NOT NULL DEFAULT '0' COMMENT '是否删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin comment '商品';

-- 订单表
create table `order`(
    id bigint(20) NOT NULL primary key COMMENT '主键',
    `number`     varchar(50)   DEFAULT NULL COMMENT '订单号',
    product_id   varchar(512)  DEFAULT NULL COMMENT '商品id',
    order_time    datetime     default CURRENT_TIMESTAMP not null comment '下单时间',
    user_id      bigint(20)    NOT NULL COMMENT '下单用户',
    weight       DECIMAL(8,2)  NOT NULL COMMENT '购买斤数',
    update_time   datetime      default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    status       int(11)       NOT NULL DEFAULT '1' COMMENT '订单状态 1待付款，2待派送，3已派送，4已完成，5已取消',
    `method`     tinyint       NOT NULL COMMENT '支付方式 1微信，2支付宝',
    order_price   DECIMAL(8,2)                            not null comment '订单总价',
    location     varchar(256)                      not null comment '订单地址',
    phone        varchar(255)                      DEFAULT NULL comment '用户电话',
    remark       varchar(100)                      DEFAULT NULL COMMENT '备注',
    address_book_id bigint(20) NOT NULL COMMENT '地址id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin comment '订单';

-- 购物车
CREATE TABLE shopping_cart (
     id    bigint(20) NOT NULL primary key COMMENT '主键',
     user_id bigint(20) NOT NULL COMMENT '用户id',
     product_id varchar(512)  DEFAULT NULL COMMENT '商品id',
     url   varchar(256)  not null comment '商品图片url',
     name varchar(50)  DEFAULT NULL COMMENT '商品名称',
     `number` int(11) NOT NULL DEFAULT '1' COMMENT '数量',
     price DECIMAL(8,2) not null comment '价格'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='购物车';

-- 营销活动信息表
CREATE TABLE promotion(
    id                  INT AUTO_INCREMENT PRIMARY KEY COMMENT '营销活动id',
    name                tinyint             NOT NULL COMMENT '营销活动名称',
    start_time           DATETIME            NOT NULL COMMENT '开始时间',
    end_time             DATETIME            NOT NULL COMMENT '结束时间',
    create_user         bigint(20)          NOT NULL comment '创建人',
    update_user         bigint(20)          NOT NULL comment '修改人',
    discount            DECIMAL(8,2)        NOT NULL COMMENT '满减金额'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='营销活动信息';

-- 地址表
CREATE TABLE address_book (
    `id`            bigint(20) NOT NULL COMMENT '主键',
    `user_id`       bigint(20) NOT NULL COMMENT '用户id',
    `consignee`     varchar(50) COLLATE utf8_bin NOT NULL COMMENT '收货人',
    `sex`           tinyint(4) NOT NULL COMMENT '性别 0 女 1 男',
    `phone`         varchar(11) COLLATE utf8_bin NOT NULL COMMENT '手机号',
    `detail`        varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '详细地址',
    `is_default`    tinyint(1) NOT NULL DEFAULT '0' COMMENT '默认 0 否 1是',
    create_time     datetime  default CURRENT_TIMESTAMP  NOT NULL comment '创建时间',
    update_time     datetime  default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP NOT NULL comment '更新时间',
    `create_user`   bigint(20) NOT NULL COMMENT '创建人',
    `update_user`   bigint(20) NOT NULL COMMENT '修改人',
    `is_deleted`    int(11) NOT NULL DEFAULT '0' COMMENT '是否删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='地址管理';