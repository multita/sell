package org.jt.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.jt.sell.VO.ResultVO;
import org.jt.sell.converter.OrderForm2OrderDTOConverter;
import org.jt.sell.dto.OrderDTO;
import org.jt.sell.enums.ResultEnum;
import org.jt.sell.exception.SellException;
import org.jt.sell.form.OrderForm;
import org.jt.sell.service.Impl.BuyerServiceImpl;
import org.jt.sell.service.Impl.OrderServiceImpl;
import org.jt.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedFormContentFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.controller
 * @ClassName: BuyerOrderController
 * @Author: hjt
 * @Date: 2019/5/7 16:55
 * @Version: 1.0
 */

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private BuyerServiceImpl buyerService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String ,String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }
    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid")String openid,
                                         @RequestParam(value ="page" ,defaultValue = "0")Integer page,
                                         @RequestParam(value ="size",defaultValue = "10")Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PAPAM_ERROR);
        }

        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage =orderService.findList(openid,request);
//        return ResultVOUtil.success();
        return ResultVOUtil.success(orderDTOPage.getContent());
    }
        //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){

        OrderDTO orderDTO =  buyerService.findOrderOne(openid,orderId);
        return ResultVOUtil.success(orderDTO);
    }
        //取消订单
    @PostMapping("/cancel")
    public ResultVO<OrderDTO> cancel(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){

        OrderDTO orderDTO = buyerService.cancelOrder(openid,orderId);

        return ResultVOUtil.success();
    }

}
