package com.homaer.fundsrv.mapper;

import com.homaer.fundsrv.dataobject.FundUserDto;
import com.homaer.fundsrv.dataobject.FundUserDtoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundUserDtoMapper {
    int countByExample(FundUserDtoCriteria example);

    int deleteByExample(FundUserDtoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(FundUserDto record);

    int insertSelective(FundUserDto record);

    List<FundUserDto> selectByExample(FundUserDtoCriteria example);

    FundUserDto selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FundUserDto record, @Param("example") FundUserDtoCriteria example);

    int updateByExample(@Param("record") FundUserDto record, @Param("example") FundUserDtoCriteria example);

    int updateByPrimaryKeySelective(FundUserDto record);

    int updateByPrimaryKey(FundUserDto record);
}