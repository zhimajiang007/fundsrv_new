package com.homaer.fundsrv.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.homaer.fundsrv.dao.AccountCapitalDao;
import com.homaer.fundsrv.dataobject.AccountCapitalDtoCriteria;
import com.homaer.fundsrv.mapper.AccountCapitalDtoMapper;
import com.homaer.fundsrv.module.ib.MarketData;


@Repository
public class AccountCapitalDaoImpl implements AccountCapitalDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4887927021685656084L;
	@Autowired
	private AccountCapitalDtoMapper AccountCapitalDtoMapper;

	@Override
	public Serializable doCreateOrUpdate(MarketData entity) {
		return AccountCapitalDtoMapper.doCreateOrUpdate(entity);
	}

	@Override
	public void update(MarketData entity) {
		AccountCapitalDtoMapper.updateByPrimaryKey(entity);
	}

	@Override
	public void delete(MarketData entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(MarketData entity) {
		// TODO Auto-generated method stub
		
	}
	
	public List<MarketData> getAccountCapitalList(MarketData dto)
	{
	
		AccountCapitalDtoCriteria query = new AccountCapitalDtoCriteria();
		AccountCapitalDtoCriteria.Criteria criteria = query.createCriteria();
		if (!StringUtils.isEmpty(dto.getAccount())) {
			criteria.andAccountNameEqualTo(dto.getAccount());
		}
		if (!StringUtils.isEmpty(dto.getCashBalance())) {
			criteria.andCashBalanceEqualTo(dto.getCashBalance());
		}
		return AccountCapitalDtoMapper.selectByExample(query);

	}

}
