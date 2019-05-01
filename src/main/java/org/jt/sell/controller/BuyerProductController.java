package org.jt.sell.controller;


import org.jt.sell.VO.ProductInfoVO;
import org.jt.sell.VO.ProductVO;
import org.jt.sell.VO.ResultVO;
import org.jt.sell.dataobject.ProductCategory;
import org.jt.sell.dataobject.ProductInfo;
import org.jt.sell.service.CategoryService;
import org.jt.sell.service.ProductService;
import org.jt.sell.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    Logger logger = LoggerFactory.getLogger(BuyerProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //提取出来数据 做成数据字典
        //一次性取出需要的额数据，避免for循环数据库

            //1. 查询所有的上架商品
            List<ProductInfo> productInfoList = productService.findUpAll();
            logger.error(productInfoList.toString());

            //2. 查询类目集合(一次性查询)
            List<Integer> categoryTypeList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                categoryTypeList.add(productInfo.getCategoryType());
            }
            logger.error(categoryTypeList.toString());
             List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
            logger.error(productCategoryList.toString());
            //精简方法(java8, lambda)
//            List<Integer> categoryTypeList = productInfoList.stream()
//                    .map(e -> e.getCategoryType())
//                    .collect(Collectors.toList());
            //3. 数据拼装
            List<ProductVO> productVOList = new ArrayList<>();
            System.out.println(productCategoryList.size());
            for (ProductCategory productCategory: productCategoryList) {
                ProductVO productVO = new ProductVO();
                productVO.setCategoryType(productCategory.getCategoryType());
                productVO.setCategoryName(productCategory.getCategoryName());

                List<ProductInfoVO> productInfoVOList = new ArrayList<>();
                for (ProductInfo productInfo: productInfoList) {
                    if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                        ProductInfoVO productInfoVO = new ProductInfoVO();
                        BeanUtils.copyProperties(productInfo, productInfoVO);
                        productInfoVOList.add(productInfoVO);
                    }
                }
                productVO.setProductInfoVOList(productInfoVOList);
                productVOList.add(productVO);
                logger.debug(productVO.toString());
            }

            return ResultVOUtil.success(productVOList);
        }
}
