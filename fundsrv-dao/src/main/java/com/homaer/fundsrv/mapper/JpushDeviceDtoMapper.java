package com.homaer.fundsrv.mapper;

import com.homaer.fundsrv.dataobject.JpushDeviceDto;
import com.homaer.fundsrv.dataobject.JpushDeviceDtoCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface JpushDeviceDtoMapper {
    int countByExample(JpushDeviceDtoCriteria example);

    int deleteByExample(JpushDeviceDtoCriteria example);

    int deleteByPrimaryKey(String registrationId);

    int insert(JpushDeviceDto record);

    int insertSelective(JpushDeviceDto record);

    List<JpushDeviceDto> selectByExample(JpushDeviceDtoCriteria example);

    JpushDeviceDto selectByPrimaryKey(String registrationId);

    int updateByExampleSelective(@Param("record") JpushDeviceDto record, @Param("example") JpushDeviceDtoCriteria example);

    int updateByExample(@Param("record") JpushDeviceDto record, @Param("example") JpushDeviceDtoCriteria example);

    int updateByPrimaryKeySelective(JpushDeviceDto record);

    int updateByPrimaryKey(JpushDeviceDto record);

	List<JpushDeviceDto> getJpushDeviceDtoListByOrderId(String orderId);
}