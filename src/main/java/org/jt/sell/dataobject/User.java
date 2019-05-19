package org.jt.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.dataobject
 * @ClassName: User
 * @Author: hjt
 * @Date: 2019/5/8 20:43
 * @Version: 1.0
 */
@Proxy(lazy = false)
@Entity
@Data
public class User {

    /** 用户名*/
    private String  name;

    /** 密码*/
    private String password;

    /** 邮箱*/
    @Id
    private String email;

    /** 身份证*/
    private String  cardid;

    public User() {
    }
    public User(String email ,String password) {
        this.password = password;
        this.email = email;
    }
    public User(String name, String password, String email, String cardid) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.cardid = cardid;
    }
}
