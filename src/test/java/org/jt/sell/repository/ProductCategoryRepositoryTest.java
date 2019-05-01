package org.jt.sell.repository;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.hibernate.annotations.ListIndexBase;
import org.jt.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    /**
     * 测试查找一个
     */
    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findById(1).get();

        System.out.println(productCategory.toString());
    }
    @Test
     public void findByCategoryTypeInTest(){

        List<Integer> list = Arrays.asList(1,2,3,4);

        List<ProductCategory> result=repository.findByCategoryTypeIn(list);
        Assert.assertNotNull(result);
    }
    /**
     * 测试添加和修改
     */
    @Test
    @Transactional
    public void saveTest(){

        ProductCategory productCategory = repository.findById(2).get();
        productCategory.setCategoryType(24);

//        ProductCategory productCategory = new ProductCategory("男生最das",4);
        repository.save(productCategory);

    }

}