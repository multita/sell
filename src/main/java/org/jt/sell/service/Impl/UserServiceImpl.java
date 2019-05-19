package org.jt.sell.service.Impl;

import org.jt.sell.dataobject.User;
import org.jt.sell.exception.UserException;
import org.jt.sell.repository.UserRepository;
import org.jt.sell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import sun.security.util.Password;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.service.Impl
 * @ClassName: Userservice
 * @Author: hjt
 * @Date: 2019/5/8 21:05
 * @Version: 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User login(User user) {
        try{
            User user1 = repository.findById(user.getEmail()).get();
            if(!user1.getPassword().equalsIgnoreCase(getMD5(user.getPassword()))){
                user1.setPassword(null);
                return user1;
            }else{
                throw new UserException(1,"密码错误");
            }
        }catch (NoSuchElementException e){
            //抛出找不到的异常
            throw new UserException(2,"账号不存在");
        }


    }

    @Override
    public User regiter(User user) {


            try{
                repository.findById(user.getEmail()).get();
                throw new UserException(3,"该邮箱已经注册");
            }catch (NoSuchElementException e){
                user.setPassword(getMD5(user.getPassword()));
                User user1 = repository.save(user);
                user1.setPassword(null);
                return user1;
            }


    }

    private String getMD5(String seckillId) {
        String salt ="fnsajdb%^&4%7GHD^*%*";
        String base = seckillId+ "/"+salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return  md5;
    }

}
