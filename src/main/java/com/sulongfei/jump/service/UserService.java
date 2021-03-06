package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.TicketDTO;
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

    Response update(UserDTO dto);

    Response ticketLog(UserDTO dto);

    Response ticketList(TicketDTO dto);

    Response oneTicket(TicketDTO dto);

    Response modifyTicket(TicketDTO dto);
}
