package org.jt.sell.repository;

import org.jt.sell.dataobject.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.repository
 * @ClassName: UserRepositoryTest
 * @Author: hjt
 * @Date: 2019/5/8 20:49
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findOneTest(){
        String email ="123";
        User user =  userRepository.findById(email).get();
        System.out.println(user);
    }
}