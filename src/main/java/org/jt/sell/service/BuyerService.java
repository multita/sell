package org.jt.sell.service;

import org.jt.sell.dto.OrderDTO;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.service
 * @ClassName: BuyerService
 * @Author: hjt
 * @Date: 2019/5/7 21:57
 * @Version: 1.0
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openid,String orderId);
    OrderDTO cancelOrder(String openid,String orderId);
}
