package org.jt.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.dataobject
 * @ClassName: SellerInfo
 * @Author: hjt
 * @Date: 2019/5/19 9:48
 * @Version: 1.0
 */

@Proxy(lazy = false)
@Entity
@DynamicUpdate
@Data
public class SellerInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Date createTime;

    private Date updateTime;
}
