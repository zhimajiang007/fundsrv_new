package com.homaer.fundsrv.dao;

import java.io.Serializable;

/**
 * 
 * @author homaer
 * @version $Id: GenericDao.java,v 0.1 2012-8-11 上午11:16:25 homaer Exp $
 */
public interface GenericDao<T, ID extends Serializable> extends Serializable {

	/**
	 * 保存一个对象
	 * 
	 * @param entity
	 * @return
	 */
	Serializable doCreateOrUpdate(T entity);

	/**
	 * 更新一个对象
	 * 
	 * @param entity
	 * @return
	 */
	void update(T entity);

	/**
	 * 删除一个对象
	 * 
	 * @param entity
	 */
	void delete(T entity);

	/**
	 * 保存或更新对象
	 * 
	 * @param entity
	 */
	void saveOrUpdate(T entity);

}
