package org.jt.sell.repository;

import org.jt.sell.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.undo.UndoableEditSupport;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.repository
 * @ClassName: UserRepository
 * @Author: hjt
 * @Date: 2019/5/8 20:48
 * @Version: 1.0
 */
public interface UserRepository extends JpaRepository<User,String> {

}
