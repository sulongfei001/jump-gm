package com.sulongfei.jump.mapper;

import com.sulongfei.jump.model.RecordSimple;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RecordSimpleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RecordSimple record);

    int insertSelective(RecordSimple record);

    RecordSimple selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RecordSimple record);

    int updateByPrimaryKey(RecordSimple record);

    Integer countPrize(@Param("roomId") Long roomId);

    List<RecordSimple> selectByRoomId(Long roomId);

    List<RecordSimple> historyTicket(Long roomId);
}