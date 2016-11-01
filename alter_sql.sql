
-- 用户股票汇总信息表
CREATE TABLE `user_stock` (
`id`  bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键ID' ,
`user_id`  varchar(40) NULL COMMENT '资产持有人' ,
`card_no`  varchar(44) NULL ,
`stock_id`  varchar(20) NULL COMMENT '股票id' ,
`stock_code`  varchar(20) NULL COMMENT '股票代码' ,
`type`  varchar(20) NULL COMMENT '券商类型：ib 、hb等' ,
`stock_amount`  decimal(20,8) NULL COMMENT '持仓数量' ,
`buy_price`  decimal(20,8) NULL ,
`stock_cost`  decimal(20,8) NULL COMMENT '花费金额' ,
`pay_date`  varchar(20) NULL COMMENT '认购付款时间' ,
`read_status`  int(1) NULL COMMENT '0 未读  1 已读' ,
`benefit_uid`  varchar(40) NULL COMMENT '受益人身份' ,
`gmt_date`  varchar(20) NULL COMMENT '创建时间' ,
`gmt_modify`  varchar(20) NULL COMMENT '修改时间' ,
`currency`  varchar(10) NULL COMMENT '资产货币类型' ,
PRIMARY KEY (`id`)
)
;

-- 用户股票明细信息表
CREATE TABLE `user_stock_log` (
`log_id`  bigint(40) NOT NULL AUTO_INCREMENT COMMENT '股票操作记录ID' ,
`user_stock_id`  bigint(40) NOT NULL COMMENT '股票持仓信息id' ,
`user_id`  varchar(40) NULL COMMENT '资产持有人' ,
`fund_act`  varchar(2) NULL COMMENT '资产操作类型：1 购买，3 卖出' ,
`opactid`  varchar(40) NULL COMMENT '买入时生成操作ID，卖出时用买入的操作ID。' ,
`type`  varchar(20) NULL COMMENT '券商类型：ib 、hb等' ,
`stock_money`  decimal(20,8) NULL COMMENT '当次消费金额' ,
`currency`  varchar(20) NULL COMMENT '资产货币类型' ,
`remainder`  decimal(20,8) NULL COMMENT '剩余份额' ,
`fund_amount`  decimal(20,8) NULL COMMENT '操作份额' ,
`buy_price`  decimal(20,8) NULL COMMENT '买入时价值' ,
`sell_price`  decimal(20,8) NULL COMMENT '卖出时价值' ,
`opstatus`  int(2) NULL COMMENT '操作状态 0 申请，1 成功，2 失败。' ,
`pay_date`  varchar(20) NULL COMMENT '操作日期' ,
`read_status`  int(2) NULL COMMENT '0 未读  1 已读' ,
`gmt_date`  varchar(20) NULL COMMENT '创建时间' ,
`gmt_modify`  varchar(20) NULL COMMENT '修改时间' ,
`gmt_success`  varchar(20) NULL COMMENT '操作成功时间' ,
`gmt_fail`  varchar(20) NULL COMMENT '操作失败时间' ,
`state`  int(255) NULL COMMENT '类型:0,进行中;1,完成;' ,
PRIMARY KEY (`log_id`)
)
;
-- 券商用户关联表
CREATE TABLE `t_fund_user` (
`id`  bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`user_id`  varchar(40) NOT NULL COMMENT '用户id' ,
`type`  int(2) NOT NULL COMMENT '券商类型：0-IB' ,
`fund_user`  varchar(40) NOT NULL COMMENT '券商账户' ,
`fund_username`  varchar(40) NOT NULL COMMENT '券商用户名' ,
`status`  int(2) NOT NULL COMMENT '使用状态:0-未使用；1-已使用；' ,
`create_time`  varchar(20) NOT NULL COMMENT '创建时间' ,
PRIMARY KEY (`id`)
)
;

-- 股票交易记录操作临时表
CREATE TABLE `t_stock_tmp` (
  `user_id` varchar(40) DEFAULT NULL COMMENT '用户id',
  `type` int(2) DEFAULT NULL COMMENT '券商类型:0-IB;',
  `fund_user` varchar(40) DEFAULT NULL COMMENT '券商账户',
  `fund_username` varchar(40) DEFAULT NULL COMMENT '券商用户名',
  `order_id` int(20) DEFAULT NULL COMMENT '订单号',
  `perm_id` int(20) DEFAULT NULL COMMENT '交易所订单号',
  `client_id` int(20) DEFAULT NULL COMMENT '客户端号码',
  `account` varchar(20) DEFAULT NULL COMMENT '账户',
  `action` int(2) DEFAULT NULL COMMENT '动作:0-buy;1-sell;',
  `quantity` int(10) DEFAULT NULL COMMENT '数量',
  `stock` varchar(20) DEFAULT NULL COMMENT '股票代码',
  `sec_type` varchar(20) DEFAULT NULL COMMENT '股票类型',
  `exchange` varchar(20) DEFAULT NULL COMMENT '股票类型',
  `status` varchar(20) DEFAULT NULL COMMENT '状态',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 股票交易记录保存表
CREATE TABLE `t_broker_order` (
  `order_id` varchar(40) NOT NULL COMMENT '主键',
  `clientId` varchar(40) NOT NULL COMMENT '连接ID',
  `permId` int(2) NOT NULL COMMENT 'permId',
  `symbol` varchar(20) NOT NULL COMMENT '股票代码',
  `account` varchar(40) NOT NULL COMMENT '资金账户',
  `totalquantity` int(8) DEFAULT '0' COMMENT '数量',
  `limitprice` double(10,2) DEFAULT NULL,
  `sent_time` varchar(50) DEFAULT NULL COMMENT '委托时间',
  `time_force` varchar(50) DEFAULT NULL COMMENT '有效期--DAY,当日有效；GTC,永久有效',
  `action` int(1) DEFAULT NULL COMMENT '订单操作--1,买；2,卖',
  `finish_time` varchar(20) DEFAULT NULL COMMENT '订单完成时间--仅记录分段成交最后一笔的时间',
  `action_index` varchar(20) DEFAULT NULL COMMENT '已完成交易的操作状态-BOT:买入,SLD:卖出;已提交交易的操作状态-BUY:买入,SELL:卖出',
  `status` varchar(20) NOT NULL COMMENT '订单状态 status=Submitted 提交已订单；status=Cancelled 已取消订单；Filled 已完成交易 ；PreSubmitted订单被持有和监控；PendingCancel',
  `order_type` varchar(20) NOT NULL COMMENT 'LMT(限价单) or MKT(市价单)',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `filled` int(8) DEFAULT NULL COMMENT '已完成交易数量---filled + remaining = totalQuantity',
  `remaining` int(8) DEFAULT NULL COMMENT '剩余未完成交易数量---filled + remaining = totalQuantity',
  `avg_fill_price` varchar(20) DEFAULT NULL COMMENT '平均成交价格',
  `last_fill_price` varchar(10) DEFAULT NULL COMMENT '最后一次成交价格--分N段成交，N>=1',
  `commission` varchar(80) DEFAULT NULL COMMENT '订单佣金',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 股票账户资金表
CREATE TABLE `t_account_capital` (
  `account_name` varchar(40) NOT NULL COMMENT '账户名',
  `net_liquidation` varchar(50) DEFAULT NULL COMMENT '账户总资产',
  `cash_balance` varchar(50) DEFAULT NULL COMMENT '可用资金',
  `unrealized_pnL` varchar(40) DEFAULT NULL COMMENT '盈亏额',
  PRIMARY KEY (`account_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `homaer_crawler`.`t_account_capital` ADD COLUMN `realized_pnL` varchar(40) DEFAULT NULL COMMENT '账户盈亏额' AFTER `unrealized_pnL`;
