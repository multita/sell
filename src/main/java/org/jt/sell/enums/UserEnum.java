package org.jt.sell.enums;

import lombok.Getter;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.enums
 * @ClassName: UserEnum
 * @Author: hjt
 * @Date: 2019/5/11 21:08
 * @Version: 1.0
 */
@Getter
public enum UserEnum {
    EMAIL_EXIST(0,"该邮箱未注册"),
    PASSWORD_MISTAKE(1,"密码不正确"),
      ;
    private Integer code;

    private String msg;

    UserEnum(Integer code,String msg){
        this.code =code;
        this.msg =msg;
    }
}
