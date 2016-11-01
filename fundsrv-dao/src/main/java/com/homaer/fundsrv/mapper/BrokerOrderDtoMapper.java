package com.homaer.fundsrv.mapper;

import com.homaer.fundsrv.dataobject.BrokerOrderDto;
import com.homaer.fundsrv.dataobject.BrokerOrderDtoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrokerOrderDtoMapper {
	int countByExample(BrokerOrderDtoCriteria example);

	int deleteByExample(BrokerOrderDtoCriteria example);

	int deleteByPrimaryKey(String orderId);

	int insert(BrokerOrderDto record);

	int insertSelective(BrokerOrderDto record);

	List<BrokerOrderDto> selectByExample(BrokerOrderDtoCriteria example);

	BrokerOrderDto selectByPrimaryKey(String orderId);

	int updateByExampleSelective(@Param("record") BrokerOrderDto record,
			@Param("example") BrokerOrderDtoCriteria example);

	int updateByExample(@Param("record") BrokerOrderDto record, @Param("example") BrokerOrderDtoCriteria example);

	int updateByPrimaryKeySelective(BrokerOrderDto record);

	int updateByPrimaryKey(BrokerOrderDto record);

	String getMaxId();
}