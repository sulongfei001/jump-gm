package com.sulongfei.jump.mapper;

import com.sulongfei.jump.model.SecurityUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SecurityUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecurityUser record);

    int insertSelective(SecurityUser record);

    SecurityUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecurityUser record);

    int updateByPrimaryKey(SecurityUser record);

    SecurityUser selectByUsername(String userName);

    List<SecurityUser> selectByPage(@Param("id") Long id,@Param("phoneNumber") String phoneNumber);
}
