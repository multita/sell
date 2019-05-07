package org.jt.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jt.sell.dataobject.OrderDetail;
import org.jt.sell.dataobject.OrderMaster;
import org.jt.sell.dto.OrderDTO;
import org.jt.sell.form.OrderForm;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.converter
 * @ClassName: OrderForm2OrderDTOConverter
 * @Author: hjt
 * @Date: 2019/5/7 17:10
 * @Version: 1.0
 */
public class OrderForm2OrderDTOConverter {
    public  static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList =gson.fromJson(orderForm.getItems(),
                new TypeToken<List<OrderDetail>>() {
                }.getType());
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
