package com.sulongfei.jump.web.controller;

import com.sulongfei.jump.dto.TicketDTO;
import com.sulongfei.jump.dto.UserDTO;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/1 10:25
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public Response userList(@RequestBody UserDTO dto){
        return userService.userList(dto);
    }

    @PostMapping("/update")
    public Response update(@RequestBody UserDTO dto){
        return userService.update(dto);
    }

    @PostMapping("/ticketLog")
    public Response ticketLog(@RequestBody UserDTO dto){
        return userService.ticketLog(dto);
    }

    @PostMapping("/ticketList")
    public Response ticketList(@RequestBody TicketDTO dto){
        return userService.ticketList(dto);
    }

    @PostMapping("/oneTicket")
    public Response oneTicket(@RequestBody TicketDTO dto){
        return userService.oneTicket(dto);
    }

    @PostMapping("/modifyTicket")
    public Response modifyTicket(@RequestBody TicketDTO dto){
        return userService.modifyTicket(dto);
    }
}
