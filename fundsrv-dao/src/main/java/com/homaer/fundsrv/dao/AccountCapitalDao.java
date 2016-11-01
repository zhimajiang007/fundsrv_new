package com.homaer.fundsrv.dao;

import java.util.List;

import com.homaer.fundsrv.module.ib.MarketData;

public interface AccountCapitalDao extends GenericDao<MarketData, Integer> {

	public List<MarketData> getAccountCapitalList(MarketData dto);
}
