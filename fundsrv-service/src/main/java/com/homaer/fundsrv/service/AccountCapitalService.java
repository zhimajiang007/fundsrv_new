package com.homaer.fundsrv.service;

import java.util.List;

import com.homaer.fundsrv.module.ib.MarketData;

public interface AccountCapitalService {
	
	public MarketData doCreateOrUpdate(MarketData dto);
	
	public MarketData doUpdate(MarketData dto);
	
	public List<MarketData> getAccountCapitalList(MarketData dto);

}