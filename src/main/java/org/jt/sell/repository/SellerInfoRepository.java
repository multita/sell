package org.jt.sell.repository;

import org.jt.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.repository
 * @ClassName: SellerInfoRepository
 * @Author: hjt
 * @Date: 2019/5/19 9:53
 * @Version: 1.0
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenid(String openid);
}
