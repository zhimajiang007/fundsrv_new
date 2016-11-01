package com.homaer.fundsrv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.homaer.fundsrv.cache.ServiceCacheUtil;
import com.homaer.fundsrv.dao.AccountCapitalDao;
import com.homaer.fundsrv.module.ib.MarketData;
import com.homaer.fundsrv.service.AccountCapitalService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountCapitalServiceImpl extends BaseServiceImpl<MarketData, Integer, AccountCapitalDao>
		implements AccountCapitalService {

	@Autowired
	private AccountCapitalDao AccountCapitalDao;
	
	@Autowired
	private ServiceCacheUtil serviceCacheUtil;

	@Override
	public MarketData doCreateOrUpdate(MarketData dto) {
		AccountCapitalDao.doCreateOrUpdate(dto);
		return dto;
	}

	@Override
	public MarketData doUpdate(MarketData dto) {
		AccountCapitalDao.update(dto);
		return dto;
	}

	@Override
	public List<MarketData> getAccountCapitalList(MarketData dto)
	{
		List<MarketData> lstAccountCapitalDtos = AccountCapitalDao.getAccountCapitalList(dto);
		return lstAccountCapitalDtos;
	}
}
