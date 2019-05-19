package org.jt.sell.dataobject.mapper;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.jt.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.dataobject.mapper
 * @ClassName: ProductCategoryTest
 * @Author: hjt
 * @Date: 2019/5/19 15:22
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper  productCategoryMapper;

    @Test
    public  void insertByMap() throws Exception{
        Map<String ,Object> map = new HashMap<>();
        map.put("category_name","甜甜最可爱");
        map.put("category_type",101);
        int result = productCategoryMapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("哎呀");
        productCategory.setCategoryType(110);
        int result = productCategoryMapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);

    }

    @Test
    public void findByCategoryType(){
        ProductCategory result = productCategoryMapper.findByCategoryType(101);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateByCategoryType(){
        int result = productCategoryMapper.updateByCategoryType("修改哎呀",101);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteByCategorytest(){
        int result = productCategoryMapper.deleteByCategory(110);
        Assert.assertEquals(1,result);

    }
//    报错：UnsatisfiedDependencyException:
//    信息：Error creating bean with name 'productCategoryMapper' defined in file
//          [D:\applicant\workspace\sell\sell\target\classes\org\jt\sell\dataobject\mapper\ProductCategoryMapper.class]:
//           Unsatisfied dependency expressed through bean property 'sqlSessionFactory';
//    未解决
//    @Test
//    public void selectByCategoryType(){
//        ProductCategory result = productCategoryMapper.selectByCategoryType(101);
//        Assert.assertNotNull(result);
//    }
}