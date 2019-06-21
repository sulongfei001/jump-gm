package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.RoomSimpleDTO;
import com.sulongfei.jump.response.Response;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/28 14:33
 * @Version 1.0
 */

public interface RoomSimpleService {
    Response createSimpleRoom(RoomSimpleDTO dto);

    Response simpleList(RoomSimpleDTO roomDTO);

    Response deleteSimpleRoom(long id);

    Response getSimpleRoom(long id);

    Response updateSimpleRoom(RoomSimpleDTO dto);

}
