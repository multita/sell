package org.jt.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.jt.sell.constant.CookieConstant;
import org.jt.sell.constant.RedisConstant;
import org.jt.sell.dataobject.SellerInfo;
import org.jt.sell.enums.ResultEnum;
import org.jt.sell.service.SellerService;
import org.jt.sell.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.controller
 * @ClassName: SellerUserController
 * @Author: hjt
 * @Date: 2019/5/19 10:46
 * @Version: 1.0
 */

@Controller
@RequestMapping("/seller")
@Slf4j
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/login")
    public ModelAndView login (
                               HttpServletResponse response,
                               @RequestParam("openid") String openid,
                               Map<String,Object> map){

        //1 openid去和数据库里的数据匹配
        SellerInfo sellerInfo = sellerService.findSellerByOpenid(openid);
        if(sellerInfo == null ){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMsg());
            map.put("url","sell/seller/order/list");
            log.info("【登录】该账号不存在:"+openid);
            return new ModelAndView("common/error",map);
        }

        //2. 设置token至redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);

        //3. 设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
        log.error("【登录】登录成功:"+openid);
        return new ModelAndView("redirect:" +  "/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2. 清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

            //3. 清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMsg());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }
}
