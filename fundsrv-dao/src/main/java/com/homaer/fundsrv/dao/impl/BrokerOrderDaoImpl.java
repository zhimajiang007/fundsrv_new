package com.homaer.fundsrv.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.homaer.fundsrv.dao.BrokerOrderDao;
import com.homaer.fundsrv.dataobject.BrokerOrderDto;
import com.homaer.fundsrv.dataobject.BrokerOrderDtoCriteria;
import com.homaer.fundsrv.mapper.BrokerOrderDtoMapper;
import com.homaer.fundsrv.module.ib.InitContants;


@Repository
public class BrokerOrderDaoImpl implements BrokerOrderDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8439099638761914549L;
	
	@Autowired
	private BrokerOrderDtoMapper brokerOrderDtoMapper;

	@Override
	public Serializable doCreateOrUpdate(BrokerOrderDto entity) {
		return brokerOrderDtoMapper.insert(entity);
	}

	@Override
	public void update(BrokerOrderDto entity) {
		brokerOrderDtoMapper.updateByPrimaryKey(entity);
	}

	@Override
	public void delete(BrokerOrderDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(BrokerOrderDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BrokerOrderDto> getBrokerOrderList(String userId) {
		BrokerOrderDtoCriteria query = new BrokerOrderDtoCriteria();
		// query.createCriteria().andUserIdEqualTo(userId);
		return brokerOrderDtoMapper.selectByExample(query);
	}
	
	@Override
	public int getMaxId() {
		int nOrderId = InitContants.TWS_ORID;
		String orderId = brokerOrderDtoMapper.getMaxId();
		if (!StringUtils.isEmpty(orderId)) {
			nOrderId = Integer.parseInt(orderId);
		}
		return nOrderId;
	}
	
	public List<BrokerOrderDto> getBrokerOrderDtoList(BrokerOrderDto dto)
	{
	
		BrokerOrderDtoCriteria query = new BrokerOrderDtoCriteria();
		BrokerOrderDtoCriteria.Criteria criteria = query.createCriteria();
		
		if (!StringUtils.isEmpty(dto.getAccount())) {
			criteria.andAccountEqualTo(dto.getAccount());
		}
		
		// criteria.andStatusNotEqualTo("MyStatus");

		return brokerOrderDtoMapper.selectByExample(query);
	}

}
