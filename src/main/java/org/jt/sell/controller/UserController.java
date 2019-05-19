package org.jt.sell.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.jt.sell.VO.ResultVO;
import org.jt.sell.dataobject.User;
import org.jt.sell.exception.UserException;
import org.jt.sell.service.MechanismCategoryService;
import org.jt.sell.service.UserService;
import org.jt.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.controller
 * @ClassName: UserController
 * @Author: hjt
 * @Date: 2019/5/11 20:56
 * @Version: 1.0
 */

@RestController
@RequestMapping("/ecg/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultVO login(@RequestParam("email")String email,
                          @RequestParam("password")String password){
        User user = new User(email,password);
        try{
            return ResultVOUtil.success(userService.login(user));
        }catch (UserException e){
            return ResultVOUtil.error(e.getCode(),e.getMessage());
        }

    }
    @PostMapping("/regiter")
    public ResultVO regiter(
                            @RequestParam("name")String name,
                            @RequestParam("cardid")String cardid,
                            @RequestParam("email")String email,
                            @RequestParam("password")String password){
        User user = new User(name,password,email,cardid);
        try{
            return ResultVOUtil.success(userService.regiter(user));
        }catch (UserException e){
            return ResultVOUtil.error(e.getCode(),e.getMessage());
        }

    }
}
