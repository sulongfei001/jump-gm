package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.RoomDTO;
import com.sulongfei.jump.response.Response;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/28 14:33
 * @Version 1.0
 */

public interface RoomService {
    Response createSimpleRoom(RoomDTO dto);

    Response simpleList(RoomDTO roomDTO);

    Response deleteSimpleRoom(long id);

    Response getSimpleRoom(long id);

    Response updateSimpleRoom(RoomDTO dto);
}
