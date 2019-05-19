package org.jt.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不足"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(13,"详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"订单状态更新失败"),
    ORDER_DETAIL_EMPTY(16,"无此订单信息"),
    ORDER_PAY_STATUS_ERROR(17,"支付状态不正确"),
    PARAM_ERROR(18,"参数不正确"),
    CART_EMPTY(19,"购物车为空"),
    PAPAM_ERROR(20,"订单列表为空"),
    ORDER_OWNER_ERROR(21,"不能查询他人订单"),
    ORDER_CANCEL_SUCCESS(22,"订单取消成功"),
    ORDER__SUCCESS(23,"订单完成成功"),
    PRODUCT_STATUS_ERROR(24,"商品状态出错"),
    LOGIN_FAIL(25,"登录信息不正确"),
    LOGOUT_SUCCESS(26,"退出登录成功"),
    ;


    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
