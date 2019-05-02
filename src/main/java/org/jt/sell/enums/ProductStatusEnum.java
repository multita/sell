package org.jt.sell.enums;

import lombok.Getter;

@Getter
public enum  ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code,String msg){
        this.code =code;
        this.msg =msg;
    }

}
