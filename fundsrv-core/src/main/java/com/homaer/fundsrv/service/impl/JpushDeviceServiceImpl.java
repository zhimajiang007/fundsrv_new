package com.homaer.fundsrv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homaer.fundsrv.dao.JpushDeviceDao;
import com.homaer.fundsrv.dataobject.JpushDeviceDto;
import com.homaer.fundsrv.service.JpushDeviceService;


@Service
public class JpushDeviceServiceImpl extends BaseServiceImpl<JpushDeviceDto, Integer, JpushDeviceDao>
		implements JpushDeviceService {

	@Autowired
	private JpushDeviceDao JpushDeviceDao;
	
//	@Autowired
//	private ServiceCacheUtil serviceCacheUtil;
	
	@Override
	public List<JpushDeviceDto> getJpushDeviceDtoListByOrderId(String orderId)
	{
		List<JpushDeviceDto> lstJpushDeviceDtos = JpushDeviceDao.getJpushDeviceDtoListByOrderId(orderId);
		return lstJpushDeviceDtos;
	}
}
