package org.jt.sell.controller;

import org.jt.sell.VO.ResultVO;
import org.jt.sell.dataobject.MechanismCategory;
import org.jt.sell.dto.MechanismFrameDTO;
import org.jt.sell.service.MechanismCategoryService;
import org.jt.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class FrameController {

    @Autowired
    private MechanismCategoryService mechanismCategoryService;

    @GetMapping("/list")
    public ResultVO list(){

        return ResultVOUtil.success(mechanismCategoryService.findAll());
    }
    @PostMapping("/add")
    public ResultVO add(@RequestParam("categoryName")String categoryName,
                        @RequestParam("fatherType")Integer fatherType){
        MechanismFrameDTO mechanismFrameDTO =mechanismCategoryService.addNode(new MechanismFrameDTO(categoryName,fatherType));
        return ResultVOUtil.success(mechanismCategoryService.findAll());
    }
    @PostMapping("/delete")
    public ResultVO add(@RequestParam("categoryType")Integer categoryType ){
        MechanismFrameDTO mechanismFrameDTO =mechanismCategoryService.deleteNode(new MechanismFrameDTO(categoryType));
        return ResultVOUtil.success(mechanismCategoryService.findAll());
    }
}
