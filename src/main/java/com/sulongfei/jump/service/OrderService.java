package com.sulongfei.jump.service;

import com.sulongfei.jump.dto.OrderDTO;
import com.sulongfei.jump.response.Response;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/11 17:01
 * @Version 1.0
 */
public interface OrderService {
    Response orderList(OrderDTO dto);
}
