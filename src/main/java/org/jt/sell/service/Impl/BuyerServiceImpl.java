package org.jt.sell.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.jt.sell.dto.OrderDTO;
import org.jt.sell.enums.ResultEnum;
import org.jt.sell.exception.SellException;
import org.jt.sell.repository.OrderMasterRepository;
import org.jt.sell.service.BuyerService;
import org.jt.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.service.Impl
 * @ClassName: BuyerServiceImpl
 * @Author: hjt
 * @Date: 2019/5/7 21:59
 * @Version: 1.0
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderServiceImpl orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {

        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO==null){
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致，openid={}，orderDTO",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO==null){
            log.error("【取消订单】查不到该订单，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致，openid={}，orderDTO",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderService.cancel(orderDTO);
    }
}
