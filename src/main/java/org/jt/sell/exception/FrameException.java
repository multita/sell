package org.jt.sell.exception;

import org.jt.sell.enums.FrameEnum;
import org.jt.sell.enums.ResultEnum;

import java.awt.*;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.exception
 * @ClassName: FrameException
 * @Author: hjt
 * @Date: 2019/5/11 22:06
 * @Version: 1.0
 */
public class FrameException extends RuntimeException {
    private Integer code;

    private String Msg;


    public FrameException(FrameEnum frametEnum) {

        super(frametEnum.getMsg());
        this.code = frametEnum.getCode();
    }
    public FrameException(Integer code, String Msg) {

        super(Msg);
        this.code = code;
    }
}
