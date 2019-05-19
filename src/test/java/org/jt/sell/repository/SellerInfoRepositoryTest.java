package org.jt.sell.repository;

import org.jt.sell.dataobject.SellerInfo;
import org.jt.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.repository
 * @ClassName: SellerInfoRepositoryTest
 * @Author: hjt
 * @Date: 2019/5/19 9:55
 * @Version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository ;
    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");
        sellerInfo.setCreateTime(new Date());
        sellerInfo.setUpdateTime(new Date());
        sellerInfoRepository.save(sellerInfo);
    }

    @Test
    public void findByOpenidTest(){
        String openid ="abc";
        Assert.assertEquals("abc",sellerInfoRepository.findByOpenid(openid).getOpenid());
    }
}