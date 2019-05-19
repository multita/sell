package org.jt.sell.exception;

import lombok.Getter;
import lombok.Setter;
import org.jt.sell.enums.ResultEnum;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.exception
 * @ClassName: UserException
 * @Author: hjt
 * @Date: 2019/5/11 20:34
 * @Version: 1.0
 */

@Getter
@Setter
public class UserException extends RuntimeException{

    private Integer code;

    private String Msg;



    public UserException(Integer code, String Msg) {

        super(Msg);
        this.code = code;
    }

}
