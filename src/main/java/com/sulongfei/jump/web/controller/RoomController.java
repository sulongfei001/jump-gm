package com.sulongfei.jump.web.controller;

import com.sulongfei.jump.dto.RoomDTO;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/5/24 13:57
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/simple/list")
    public Response roomList(RoomDTO dto) {
        return roomService.simpleList(dto);
    }

    @PostMapping("/simple/create")
    public Response createSimpleRoom(RoomDTO dto) {
        return roomService.createSimpleRoom(dto);
    }

    @DeleteMapping("/simple/delete/{id}")
    public Response deleteSimpleRoom(@PathVariable long id) {
        return roomService.deleteSimpleRoom(id);
    }

    @PostMapping("/simple/detail/{id}")
    public Response getSimpleRoom(@PathVariable long id) {
        return roomService.getSimpleRoom(id);
    }

    @PutMapping("/simple/update")
    public Response updateSimpleRoom(RoomDTO dto){
        return roomService.updateSimpleRoom(dto);
    }
}
