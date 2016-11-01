package com.homaer.fundsrv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.homaer.fundsrv.cache.ServiceCacheUtil;
import com.homaer.fundsrv.dao.BrokerOrderDao;
import com.homaer.fundsrv.dataobject.BrokerOrderDto;
import com.homaer.fundsrv.service.BrokerOrderService;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BrokerOrderServiceImpl extends BaseServiceImpl<BrokerOrderDto, Integer, BrokerOrderDao>
		implements BrokerOrderService {

	@Autowired
	private BrokerOrderDao brokerOrderDao;
	
	@Autowired
	private ServiceCacheUtil serviceCacheUtil;

	@Override
	public BrokerOrderDto doCreate(BrokerOrderDto dto) {
		System.out.println(dto.getLimitprice() + "-价格-");
		brokerOrderDao.doCreateOrUpdate(dto);
		return dto;
	}

	@Override
	public BrokerOrderDto doUpdate(BrokerOrderDto dto) {
		System.out.println(dto.getLimitprice() + "-价格-");
		brokerOrderDao.update(dto);
		return dto;
	}
	
	@Override
	public int getMaxId() {
		int orderId = brokerOrderDao.getMaxId();
		return orderId;
	}
	
	@Override
	public List<BrokerOrderDto> getBrokerOrderDtoList(BrokerOrderDto dto)
	{
		List<BrokerOrderDto> lstBrokerOrderDtos = brokerOrderDao.getBrokerOrderDtoList(dto);
		return lstBrokerOrderDtos;
	}
}
