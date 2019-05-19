package org.jt.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.jt.sell.dataobject.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.service.Impl
 * @ClassName: UserService
 * @Author: hjt
 * @Date: 2019/5/8 21:03
 * @Version: 1.0
 */
public interface UserService {

    List<User> findAll();
    User login(User user);
    User regiter(User user);

}
