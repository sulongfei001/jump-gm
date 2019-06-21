package com.sulongfei.jump.mapper;

import com.sulongfei.jump.model.GlobalDictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GlobalDictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GlobalDictionary record);

    int insertSelective(GlobalDictionary record);

    GlobalDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GlobalDictionary record);

    int updateByPrimaryKey(GlobalDictionary record);

    List<GlobalDictionary> selectAll();

    void updateByKey(@Param("key") String key,@Param("value") String value);
}