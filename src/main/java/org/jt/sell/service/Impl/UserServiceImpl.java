package org.jt.sell.service.Impl;

import org.jt.sell.dataobject.User;
import org.jt.sell.repository.UserRepository;
import org.jt.sell.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User findByEmail(String email) {
        return repository.findById(email).get();
    }
}
