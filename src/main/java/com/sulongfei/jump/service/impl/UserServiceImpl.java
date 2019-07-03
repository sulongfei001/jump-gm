package com.sulongfei.jump.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sulongfei.jump.dto.UserDTO;
import com.sulongfei.jump.mapper.SecurityUserMapper;
import com.sulongfei.jump.model.SecurityUser;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.UserRes;
import com.sulongfei.jump.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/1 10:26
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private SecurityUserMapper userMapper;

    @Override
    public Response userList(UserDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        List<SecurityUser> list = userMapper.selectByPage(dto.getId(), dto.getPhoneNumber());
        List<UserRes> data = Lists.newArrayList();
        list.forEach(user -> {
            UserRes res = new UserRes();
            BeanUtils.copyProperties(user, res);
            data.add(res);
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }
}
