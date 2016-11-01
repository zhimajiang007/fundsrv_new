package com.homaer.fundsrv.dao;

import java.util.List;

import com.homaer.fundsrv.dataobject.JpushDeviceDto;

public interface JpushDeviceDao extends GenericDao<JpushDeviceDto, Integer> {

	public List<JpushDeviceDto> getJpushDeviceDtoListByOrderId(String orderId);

}
