package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.RoomSpreadDTO;
import com.sulongfei.jump.response.Response;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/6/18 18:00
 * @Version 1.0
 */
public interface RoomSpreadService {
    Response spreadList(RoomSpreadDTO dto);
}
