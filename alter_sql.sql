
-- �û���Ʊ������Ϣ��
CREATE TABLE `user_stock` (
`id`  bigint(40) NOT NULL AUTO_INCREMENT COMMENT '����ID' ,
`user_id`  varchar(40) NULL COMMENT '�ʲ�������' ,
`card_no`  varchar(44) NULL ,
`stock_id`  varchar(20) NULL COMMENT '��Ʊid' ,
`stock_code`  varchar(20) NULL COMMENT '��Ʊ����' ,
`type`  varchar(20) NULL COMMENT 'ȯ�����ͣ�ib ��hb��' ,
`stock_amount`  decimal(20,8) NULL COMMENT '�ֲ�����' ,
`buy_price`  decimal(20,8) NULL ,
`stock_cost`  decimal(20,8) NULL COMMENT '���ѽ��' ,
`pay_date`  varchar(20) NULL COMMENT '�Ϲ�����ʱ��' ,
`read_status`  int(1) NULL COMMENT '0 δ��  1 �Ѷ�' ,
`benefit_uid`  varchar(40) NULL COMMENT '���������' ,
`gmt_date`  varchar(20) NULL COMMENT '����ʱ��' ,
`gmt_modify`  varchar(20) NULL COMMENT '�޸�ʱ��' ,
`currency`  varchar(10) NULL COMMENT '�ʲ���������' ,
PRIMARY KEY (`id`)
)
;

-- �û���Ʊ��ϸ��Ϣ��
CREATE TABLE `user_stock_log` (
`log_id`  bigint(40) NOT NULL AUTO_INCREMENT COMMENT '��Ʊ������¼ID' ,
`user_stock_id`  bigint(40) NOT NULL COMMENT '��Ʊ�ֲ���Ϣid' ,
`user_id`  varchar(40) NULL COMMENT '�ʲ�������' ,
`fund_act`  varchar(2) NULL COMMENT '�ʲ��������ͣ�1 ����3 ����' ,
`opactid`  varchar(40) NULL COMMENT '����ʱ���ɲ���ID������ʱ������Ĳ���ID��' ,
`type`  varchar(20) NULL COMMENT 'ȯ�����ͣ�ib ��hb��' ,
`stock_money`  decimal(20,8) NULL COMMENT '�������ѽ��' ,
`currency`  varchar(20) NULL COMMENT '�ʲ���������' ,
`remainder`  decimal(20,8) NULL COMMENT 'ʣ��ݶ�' ,
`fund_amount`  decimal(20,8) NULL COMMENT '�����ݶ�' ,
`buy_price`  decimal(20,8) NULL COMMENT '����ʱ��ֵ' ,
`sell_price`  decimal(20,8) NULL COMMENT '����ʱ��ֵ' ,
`opstatus`  int(2) NULL COMMENT '����״̬ 0 ���룬1 �ɹ���2 ʧ�ܡ�' ,
`pay_date`  varchar(20) NULL COMMENT '��������' ,
`read_status`  int(2) NULL COMMENT '0 δ��  1 �Ѷ�' ,
`gmt_date`  varchar(20) NULL COMMENT '����ʱ��' ,
`gmt_modify`  varchar(20) NULL COMMENT '�޸�ʱ��' ,
`gmt_success`  varchar(20) NULL COMMENT '�����ɹ�ʱ��' ,
`gmt_fail`  varchar(20) NULL COMMENT '����ʧ��ʱ��' ,
`state`  int(255) NULL COMMENT '����:0,������;1,���;' ,
PRIMARY KEY (`log_id`)
)
;
-- ȯ���û�������
CREATE TABLE `t_fund_user` (
`id`  bigint(40) NOT NULL AUTO_INCREMENT COMMENT '����' ,
`user_id`  varchar(40) NOT NULL COMMENT '�û�id' ,
`type`  int(2) NOT NULL COMMENT 'ȯ�����ͣ�0-IB' ,
`fund_user`  varchar(40) NOT NULL COMMENT 'ȯ���˻�' ,
`fund_username`  varchar(40) NOT NULL COMMENT 'ȯ���û���' ,
`status`  int(2) NOT NULL COMMENT 'ʹ��״̬:0-δʹ�ã�1-��ʹ�ã�' ,
`create_time`  varchar(20) NOT NULL COMMENT '����ʱ��' ,
PRIMARY KEY (`id`)
)
;

-- ��Ʊ���׼�¼������ʱ��
CREATE TABLE `t_stock_tmp` (
  `user_id` varchar(40) DEFAULT NULL COMMENT '�û�id',
  `type` int(2) DEFAULT NULL COMMENT 'ȯ������:0-IB;',
  `fund_user` varchar(40) DEFAULT NULL COMMENT 'ȯ���˻�',
  `fund_username` varchar(40) DEFAULT NULL COMMENT 'ȯ���û���',
  `order_id` int(20) DEFAULT NULL COMMENT '������',
  `perm_id` int(20) DEFAULT NULL COMMENT '������������',
  `client_id` int(20) DEFAULT NULL COMMENT '�ͻ��˺���',
  `account` varchar(20) DEFAULT NULL COMMENT '�˻�',
  `action` int(2) DEFAULT NULL COMMENT '����:0-buy;1-sell;',
  `quantity` int(10) DEFAULT NULL COMMENT '����',
  `stock` varchar(20) DEFAULT NULL COMMENT '��Ʊ����',
  `sec_type` varchar(20) DEFAULT NULL COMMENT '��Ʊ����',
  `exchange` varchar(20) DEFAULT NULL COMMENT '��Ʊ����',
  `status` varchar(20) DEFAULT NULL COMMENT '״̬',
  `create_time` varchar(20) DEFAULT NULL COMMENT '����ʱ��'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ��Ʊ���׼�¼�����
CREATE TABLE `t_broker_order` (
  `order_id` varchar(40) NOT NULL COMMENT '����',
  `clientId` varchar(40) NOT NULL COMMENT '����ID',
  `permId` int(2) NOT NULL COMMENT 'permId',
  `symbol` varchar(20) NOT NULL COMMENT '��Ʊ����',
  `account` varchar(40) NOT NULL COMMENT '�ʽ��˻�',
  `totalquantity` int(8) DEFAULT '0' COMMENT '����',
  `limitprice` double(10,2) DEFAULT NULL,
  `sent_time` varchar(50) DEFAULT NULL COMMENT 'ί��ʱ��',
  `time_force` varchar(50) DEFAULT NULL COMMENT '��Ч��--DAY,������Ч��GTC,������Ч',
  `action` int(1) DEFAULT NULL COMMENT '��������--1,��2,��',
  `finish_time` varchar(20) DEFAULT NULL COMMENT '�������ʱ��--����¼�ֶγɽ����һ�ʵ�ʱ��',
  `action_index` varchar(20) DEFAULT NULL COMMENT '����ɽ��׵Ĳ���״̬-BOT:����,SLD:����;���ύ���׵Ĳ���״̬-BUY:����,SELL:����',
  `status` varchar(20) NOT NULL COMMENT '����״̬ status=Submitted �ύ�Ѷ�����status=Cancelled ��ȡ��������Filled ����ɽ��� ��PreSubmitted���������кͼ�أ�PendingCancel',
  `order_type` varchar(20) NOT NULL COMMENT 'LMT(�޼۵�) or MKT(�м۵�)',
  `create_time` varchar(20) DEFAULT NULL COMMENT '����ʱ��',
  `filled` int(8) DEFAULT NULL COMMENT '����ɽ�������---filled + remaining = totalQuantity',
  `remaining` int(8) DEFAULT NULL COMMENT 'ʣ��δ��ɽ�������---filled + remaining = totalQuantity',
  `avg_fill_price` varchar(20) DEFAULT NULL COMMENT 'ƽ���ɽ��۸�',
  `last_fill_price` varchar(10) DEFAULT NULL COMMENT '���һ�γɽ��۸�--��N�γɽ���N>=1',
  `commission` varchar(80) DEFAULT NULL COMMENT '����Ӷ��',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ��Ʊ�˻��ʽ��
CREATE TABLE `t_account_capital` (
  `account_name` varchar(40) NOT NULL COMMENT '�˻���',
  `net_liquidation` varchar(50) DEFAULT NULL COMMENT '�˻����ʲ�',
  `cash_balance` varchar(50) DEFAULT NULL COMMENT '�����ʽ�',
  `unrealized_pnL` varchar(40) DEFAULT NULL COMMENT 'ӯ����',
  PRIMARY KEY (`account_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `homaer_crawler`.`t_account_capital` ADD COLUMN `realized_pnL` varchar(40) DEFAULT NULL COMMENT '�˻�ӯ����' AFTER `unrealized_pnL`;
