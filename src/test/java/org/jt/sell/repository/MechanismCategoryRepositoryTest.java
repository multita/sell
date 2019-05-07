package org.jt.sell.repository;

import org.jt.sell.dataobject.MechanismCategory;
import org.jt.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.repository
 * @ClassName: MechanismCategoryRepositoryTest
 * @Author: hjt
 * @Date: 2019/5/6 16:58
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MechanismCategoryRepositoryTest {

    @Autowired
    private MechanismCategoryRepository repository;

    @Test
    public void saveTest(){

//        MechanismCategory mechanismCategory = repository.findById(2).get();
//        productCategory.setCategoryType(24);

        MechanismCategory mechanismCategory = new MechanismCategory("616研究院",2,1,0);
        repository.save(mechanismCategory);

    }

    @Test
    public void findAllTest(){
        List<MechanismCategory> mechanismCategoryList = repository.findAll();
        System.out.println(mechanismCategoryList);
    }

    @Test
    public void findByFatherTypeTest(){
        List<MechanismCategory> mechanismCategoryList = repository.findByFatherType(0);
        System.out.println(mechanismCategoryList);
    }

    @Test
    public void findByCategoryTypeTest(){
        MechanismCategory mechanismCategory = repository.findByCategoryType(2);
        System.out.println(mechanismCategory);
        repository.deleteById(mechanismCategory.getCategoryId());
    }
}