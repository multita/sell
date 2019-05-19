package org.jt.sell.service.Impl;

import org.jt.sell.dataobject.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.service.Impl
 * @ClassName: UserServiceImplTest
 * @Author: hjt
 * @Date: 2019/5/8 21:10
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void findAll() {
        System.out.println(userService.findAll());
    }

    @Test
    public void login() {

        User user = new User("email3","23523525432523");
        System.out.println(userService.login(user));
    }

    @Test
    public void regiter(){

        User user = new User("jhh","password","email3","23523525432523");
        userService.regiter(user);
    }
}