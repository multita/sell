package org.jt.sell.handle;

import lombok.extern.slf4j.Slf4j;
import org.jt.sell.VO.ResultVO;
import org.jt.sell.exception.SellException;
import org.jt.sell.exception.SellerAuthorizeException;
import org.jt.sell.utils.ResultVOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.handle
 * @ClassName: SellExceptionHandle
 * @Author: hjt
 * @Date: 2019/5/19 13:54
 * @Version: 1.0
 */

@ControllerAdvice
@Slf4j
public class SellExceptionHandler {

    //拦截异常登录
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        Map<String,Object> map =new HashMap<>();
        map.put("msg", "请先登录");
        map.put("url", "heheh");
        return new ModelAndView("common/error",map);
    }

    //拦截sellException
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        log.info("【sell异常】");
        return ResultVOUtil.error(e.getCode(),e.getMessage());

    }
}
