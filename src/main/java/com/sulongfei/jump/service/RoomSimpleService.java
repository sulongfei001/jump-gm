package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.SimpleRoomDTO;
import com.sulongfei.jump.dto.SpreadRoomDTO;
import com.sulongfei.jump.response.Response;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/28 14:33
 * @Version 1.0
 */

public interface RoomSimpleService {
    Response createSimpleRoom(SimpleRoomDTO dto);

    Response simpleList(SimpleRoomDTO roomDTO);

    Response deleteSimpleRoom(long id);

    Response getSimpleRoom(long id);

    Response updateSimpleRoom(SimpleRoomDTO dto);

}
