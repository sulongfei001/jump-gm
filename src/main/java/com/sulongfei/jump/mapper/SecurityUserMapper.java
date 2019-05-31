package com.sulongfei.jump.mapper;

import com.sulongfei.jump.model.SecurityUser;

public interface SecurityUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SecurityUser record);

    int insertSelective(SecurityUser record);

    SecurityUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SecurityUser record);

    int updateByPrimaryKey(SecurityUser record);
}