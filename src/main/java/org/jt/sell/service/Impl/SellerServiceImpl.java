package org.jt.sell.service.Impl;

import org.jt.sell.dataobject.SellerInfo;
import org.jt.sell.repository.SellerInfoRepository;
import org.jt.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.service.Impl
 * @ClassName: SellerServiceImpl
 * @Author: hjt
 * @Date: 2019/5/19 10:13
 * @Version: 1.0
 */
@Service
public class SellerServiceImpl implements SellerService {


    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
