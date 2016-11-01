package com.homaer.fundsrv.service;

import java.util.List;

import com.homaer.fundsrv.dataobject.JpushDeviceDto;

public interface JpushDeviceService {
	
	public List<JpushDeviceDto> getJpushDeviceDtoListByOrderId(String orderId);

}