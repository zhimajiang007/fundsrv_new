package com.homaer.fundsrv.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.homaer.fundsrv.dao.JpushDeviceDao;
import com.homaer.fundsrv.dataobject.JpushDeviceDto;
import com.homaer.fundsrv.mapper.JpushDeviceDtoMapper;


@Repository
public class JpushDeviceDaoImpl implements JpushDeviceDao{
	
	/**
	 * changhai.wang
	 */
	private static final long serialVersionUID = -9028457708297272900L;
	
	@Autowired
	private JpushDeviceDtoMapper jpushDeviceDtoMapper;

	@Override
	public Serializable doCreateOrUpdate(JpushDeviceDto entity) {
		return jpushDeviceDtoMapper.insert(entity);
	}

	@Override
	public void update(JpushDeviceDto entity) {
		jpushDeviceDtoMapper.updateByPrimaryKey(entity);
	}

	@Override
	public void delete(JpushDeviceDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdate(JpushDeviceDto entity) {
		// TODO Auto-generated method stub
		
	}

	public List<JpushDeviceDto> getJpushDeviceDtoListByOrderId(String orderId)
	{
		return jpushDeviceDtoMapper.getJpushDeviceDtoListByOrderId(orderId);
	}

}
