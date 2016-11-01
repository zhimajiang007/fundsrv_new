package com.homaer.fundsrv.service;

import java.util.List;

import com.homaer.fundsrv.dataobject.BrokerOrderDto;

public interface BrokerOrderService {
	
	public BrokerOrderDto doCreate(BrokerOrderDto dto);
	
	public BrokerOrderDto doUpdate(BrokerOrderDto dto);
	
	public int getMaxId();
	
	public List<BrokerOrderDto> getBrokerOrderDtoList(BrokerOrderDto dto);

}