package org.jt.sell.exception;

import org.jt.sell.enums.ResultEnum;

public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
