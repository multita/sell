package org.jt.sell.service.Impl;

import org.jt.sell.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.service.Impl
 * @ClassName: SellerServiceImplTest
 * @Author: hjt
 * @Date: 2019/5/19 10:15
 * @Version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    @Autowired
    private SellerServiceImpl sellerService;
    @Test
    public void findSellerByOpenid() {
        SellerInfo sellerInfo = sellerService.findSellerByOpenid("abc");
        Assert.assertEquals("abc",sellerInfo.getOpenid());
    }
}