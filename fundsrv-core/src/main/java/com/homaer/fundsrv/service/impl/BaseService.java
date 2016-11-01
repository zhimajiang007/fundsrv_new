package com.homaer.fundsrv.service.impl;

import java.io.Serializable;

public interface BaseService<T, ID extends Serializable> {

	Serializable save(T entity);

	void update(T entity);

	void saveOrUpdate(T entity);

	void delete(T entity);

//	T findById(ID id);
}
