package org.jt.sell.controller;

import org.jt.sell.VO.ResultVO;
import org.jt.sell.service.MechanismCategoryService;
import org.jt.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.controller
 * @ClassName: ViewFrameController
 * @Author: hjt
 * @Date: 2019/5/7 13:34
 * @Version: 1.0
 */

@RestController
@RequestMapping("/ecg/frame")
public class ViewFrameController {

    @Autowired
    private MechanismCategoryService mechanismCategoryService;

    @GetMapping("/list")
    public ResultVO list(){
        return ResultVOUtil.success(mechanismCategoryService.findAll());
    }
//    @GetMapping("/add")
//    public ResultVO add(){
//        mechanismCategoryService.addNode();
//        return ResultVOUtil.success(mechanismCategoryService.findAll());
//    }
}
