package org.jt.sell.service;

import org.jt.sell.dataobject.MechanismCategory;
import org.jt.sell.dto.MechanismFrameDTO;

import java.util.List;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.service
 * @ClassName: MechanismCategoryService
 * @Author: hjt
 * @Date: 2019/5/6 19:34
 * @Version: 1.0
 */
public interface MechanismCategoryService {
    MechanismFrameDTO findAll();
    void addNode(MechanismFrameDTO mechanismFrameDTO);
    void deleteNode(MechanismFrameDTO mechanismFrameDTO);
}
