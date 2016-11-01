package com.homaer.fundsrv.dao;

import java.util.List;

import com.homaer.fundsrv.dataobject.BrokerInfoDto;

public interface BrokerInfoDao extends GenericDao<BrokerInfoDto, Integer> {

	public List<BrokerInfoDto> getBrokerInfoList(String userId);
	
	/**
	 * 根据ib查询的账户资产将账户状态6修改为8
	 * @param objBrokerInfo
	 */
	public void doUpdateStatusByIb(BrokerInfoDto objBrokerInfo);

}
