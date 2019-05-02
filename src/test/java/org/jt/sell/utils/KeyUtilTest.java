package org.jt.sell.utils;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class KeyUtilTest {

     public  void randomPasswordTest(){
        System.out.println(KeyUtil.randomPassword());
     }
}