package com.homaer.fundsrv.mapper;

import com.homaer.fundsrv.dataobject.UserStockLogDto;
import com.homaer.fundsrv.dataobject.UserStockLogDtoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserStockLogDtoMapper {
    int countByExample(UserStockLogDtoCriteria example);

    int deleteByExample(UserStockLogDtoCriteria example);

    int deleteByPrimaryKey(Long logId);

    int insert(UserStockLogDto record);

    int insertSelective(UserStockLogDto record);

    List<UserStockLogDto> selectByExample(UserStockLogDtoCriteria example);

    UserStockLogDto selectByPrimaryKey(Long logId);

    int updateByExampleSelective(@Param("record") UserStockLogDto record, @Param("example") UserStockLogDtoCriteria example);

    int updateByExample(@Param("record") UserStockLogDto record, @Param("example") UserStockLogDtoCriteria example);

    int updateByPrimaryKeySelective(UserStockLogDto record);

    int updateByPrimaryKey(UserStockLogDto record);
}