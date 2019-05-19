package org.jt.sell.enums;

import lombok.Getter;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.enums
 * @ClassName: FrameEnum
 * @Author: hjt
 * @Date: 2019/5/11 22:08
 * @Version: 1.0
 */
@Getter
public enum FrameEnum {
    NOT_EXIST(0,"该架构节点不存在"),

     ;
    private Integer code;

    private String msg;

    FrameEnum(Integer code,String msg){
        this.code =code;
        this.msg =msg;
    }
}
