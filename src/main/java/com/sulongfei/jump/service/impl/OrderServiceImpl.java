package com.sulongfei.jump.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.sulongfei.jump.dto.OrderDTO;
import com.sulongfei.jump.mapper.PaymentOrderMapper;
import com.sulongfei.jump.model.PaymentOrder;
import com.sulongfei.jump.response.GoodsRes;
import com.sulongfei.jump.response.OrderRes;
import com.sulongfei.jump.response.Response;
import com.sulongfei.jump.response.UserRes;
import com.sulongfei.jump.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈〉
 *
 * @Author sulongfei
 * @Date 2019/7/11 17:02
 * @Version 1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private PaymentOrderMapper orderMapper;

    @Override
    public Response orderList(OrderDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getPageSize());
        List<PaymentOrder> list = orderMapper.selectAll(dto.getUserId(),dto.getSwOrderId());
        List<OrderRes> data = Lists.newArrayList();
        list.forEach(order -> {
            OrderRes res = new OrderRes();
            BeanUtils.copyProperties(order, res);
            UserRes user = new UserRes();
            BeanUtils.copyProperties(order.getUser(), user);
            GoodsRes goods = new GoodsRes();
            BeanUtils.copyProperties(order.getGoods(), goods);
            res.setUser(user);
            res.setGoods(goods);
            data.add(res);
        });
        return Response.toResponse(data, new PageInfo<>(list).getTotal());
    }
}
