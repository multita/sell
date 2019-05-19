package org.jt.sell.exception;

import lombok.Getter;
import org.jt.sell.enums.ResultEnum;

@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code ,String msg) {

        super(msg);
        this.code = code;
    }
}
