package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.UserDTO;
import com.sulongfei.jump.response.Response;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/1 10:26
 * @Version 1.0
 */
public interface UserService {
    Response userList(UserDTO dto);
}
