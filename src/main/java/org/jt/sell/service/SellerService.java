package org.jt.sell.service;

import org.jt.sell.dataobject.SellerInfo;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.service
 * @ClassName: SellerService
 * @Author: hjt
 * @Date: 2019/5/19 10:12
 * @Version: 1.0
 */
public interface SellerService {
      SellerInfo findSellerByOpenid(String openid);
}
