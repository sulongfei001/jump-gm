package com.sulongfei.jump.web.controller;

import com.sulongfei.jump.dto.SimpleRoomDTO;
import com.sulongfei.jump.dto.SpreadRoomDTO;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.service.RoomSimpleService;
import com.sulongfei.jump.service.RoomSpreadService;
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
    private RoomSimpleService simpleService;
    @Autowired
    private RoomSpreadService spreadService;

    @PostMapping("/simple/list")
    public Response roomList(@RequestBody SimpleRoomDTO dto) {
        return simpleService.simpleList(dto);
    }

    @PostMapping("/simple/create")
    public Response createSimpleRoom(@RequestBody SimpleRoomDTO dto) {
        return simpleService.createSimpleRoom(dto);
    }

    @DeleteMapping("/simple/delete/{id}")
    public Response deleteSimpleRoom(@PathVariable long id) {
        return simpleService.deleteSimpleRoom(id);
    }

    @PostMapping("/simple/detail/{id}")
    public Response getSimpleRoom(@PathVariable long id) {
        return simpleService.getSimpleRoom(id);
    }

    @PutMapping("/simple/update")
    public Response updateSimpleRoom(@RequestBody SimpleRoomDTO dto) {
        return simpleService.updateSimpleRoom(dto);
    }

    @PostMapping("/spread/list")
    public Response spreadList(@RequestBody SpreadRoomDTO dto){
        return spreadService.spreadList(dto);
    }
}
