package com.homaer.fundsrv.service.impl;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.homaer.common.tools.log.LoggerUtils;
import com.homaer.fundsrv.dao.GenericDao;

public class BaseServiceImpl<T, ID extends Serializable, E extends GenericDao<T, ID>>
		implements BaseService<T, ID> {
	
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(LoggerUtils.SERVICE_LOGGER);

	protected E daoImpl;

	public E getDaoImpl() {
		return daoImpl;
	}

	public void setDaoImpl(E daoImpl) {
		this.daoImpl = daoImpl;
	}

	@Override
	public Serializable save(T entity) {
		return daoImpl.doCreateOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		daoImpl.update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		daoImpl.saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		daoImpl.delete(entity);
	}

}
