package com.homaer.fundsrv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.homaer.fundsrv.dataobject.AccountCapitalDtoCriteria;
import com.homaer.fundsrv.module.ib.MarketData;

public interface AccountCapitalDtoMapper {
    int countByExample(AccountCapitalDtoCriteria example);

    int deleteByExample(AccountCapitalDtoCriteria example);

    int deleteByPrimaryKey(String accountId);

    int doCreateOrUpdate(MarketData record);

    int insertSelective(MarketData record);

    List<MarketData> selectByExample(AccountCapitalDtoCriteria example);

    MarketData selectByPrimaryKey(String accountId);

    int updateByExampleSelective(@Param("record") MarketData record, @Param("example") AccountCapitalDtoCriteria example);

    int updateByExample(@Param("record") MarketData record, @Param("example") AccountCapitalDtoCriteria example);

    int updateByPrimaryKeySelective(MarketData record);

    int updateByPrimaryKey(MarketData record);
}