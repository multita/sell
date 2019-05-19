package org.jt.sell.dataobject.dao;

import org.jt.sell.dataobject.ProductCategory;
import org.jt.sell.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.dataobject.dao
 * @ClassName: ProductCategoryDao
 * @Author: hjt
 * @Date: 2019/5/19 16:07
 * @Version: 1.0
 * 实际上直接serrvice调用mapper也是一样的，加个dao层更符合java后端分层习惯
 */
public class ProductCategoryDao {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    public int insert(ProductCategory productCategory){
        return productCategoryMapper.insertByObject(productCategory);
    }
}
