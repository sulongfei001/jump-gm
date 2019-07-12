package com.sulongfei.jump.web.controller;

import com.sulongfei.jump.dto.OrderDTO;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/11 17:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/admin/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/list")
    public Response orderList(@RequestBody OrderDTO dto){
        return orderService.orderList(dto);
    }

}
