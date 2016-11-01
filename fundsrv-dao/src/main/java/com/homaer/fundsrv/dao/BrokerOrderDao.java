package com.homaer.fundsrv.dao;

import java.util.List;

import com.homaer.fundsrv.dataobject.BrokerOrderDto;

public interface BrokerOrderDao extends GenericDao<BrokerOrderDto, Integer> {

	public List<BrokerOrderDto> getBrokerOrderList(String userId);

	public int getMaxId();

	public List<BrokerOrderDto> getBrokerOrderDtoList(BrokerOrderDto dto);

}
