package com.homaer.fundsrv.mapper;

import com.homaer.fundsrv.dataobject.UserStockDto;
import com.homaer.fundsrv.dataobject.UserStockDtoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserStockDtoMapper {
    int countByExample(UserStockDtoCriteria example);

    int deleteByExample(UserStockDtoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(UserStockDto record);

    int insertSelective(UserStockDto record);

    List<UserStockDto> selectByExample(UserStockDtoCriteria example);

    UserStockDto selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserStockDto record, @Param("example") UserStockDtoCriteria example);

    int updateByExample(@Param("record") UserStockDto record, @Param("example") UserStockDtoCriteria example);

    int updateByPrimaryKeySelective(UserStockDto record);

    int updateByPrimaryKey(UserStockDto record);
}