package org.jt.sell.converter;

import org.aspectj.weaver.ast.Or;
import org.jt.sell.dataobject.OrderMaster;
import org.jt.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.converter
 * @ClassName: OrderMaster2OrderDTOConverter
 * @Author: hjt
 * @Date: 2019/5/2 16:42
 * @Version: 1.0
 */
public class OrderMaster2OrderDTOConverter {
    public  static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){

        return orderMasterList.stream().map(
                e ->convert(e)
        ).collect(Collectors.toList());

    }
}
