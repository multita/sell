package org.jt.sell.service.Impl;

import org.jt.sell.dataobject.MechanismCategory;
import org.jt.sell.dto.MechanismFrameDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.service.Impl
 * @ClassName: MechanismCategoryServiceImplTest
 * @Author: hjt
 * @Date: 2019/5/6 22:13
 * @Version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MechanismCategoryServiceImplTest {

    @Autowired
    private MechanismCategoryServiceImpl mechanismCategoryService;

    @Test
    public void insertSonNodes() {
    }

    @Test
    public void findAll() {
        System.out.println(mechanismCategoryService.findAll());
    }

    @Test
    public void addNode() {
        MechanismFrameDTO mechanismFrameDTO = new MechanismFrameDTO("616研究院",2,1,0);
        mechanismCategoryService.addNode(mechanismFrameDTO);
    }

    @Test
    public void deleteNode() {
        MechanismFrameDTO mechanismFrameDTO = new MechanismFrameDTO(4010);
        mechanismCategoryService.deleteNode(mechanismFrameDTO);
    }
}