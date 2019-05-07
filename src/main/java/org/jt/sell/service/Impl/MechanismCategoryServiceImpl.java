package org.jt.sell.service.Impl;

import org.jt.sell.converter.DTO2MechanismCategoryConverter;
import org.jt.sell.converter.MechanismCategory2DTOConverter;
import org.jt.sell.dataobject.MechanismCategory;
import org.jt.sell.dto.MechanismFrameDTO;
import org.jt.sell.repository.MechanismCategoryRepository;
import org.jt.sell.service.MechanismCategoryService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.service.Impl
 * @ClassName: MechanismCategoryImpl
 * @Author: hjt
 * @Date: 2019/5/6 19:35
 * @Version: 1.0
 */

@Service
public class MechanismCategoryServiceImpl implements MechanismCategoryService {

    @Autowired
    MechanismCategoryRepository repository ;


    public void insertSonNodes(MechanismFrameDTO mechanismFrameDTO,int type){


        List<MechanismCategory> mechanismCategoryList =repository.findByFatherType(type);

        List<MechanismFrameDTO> mechanismFrameDTOList =MechanismCategory2DTOConverter.convert(mechanismCategoryList);

        for(MechanismFrameDTO mechanismFrameDTO1:mechanismFrameDTOList){

            if(mechanismFrameDTO1.getSonsNumber()!=0){
               this.insertSonNodes(mechanismFrameDTO1,mechanismFrameDTO1.getCategoryType());
            }
        }
        mechanismFrameDTO.setMechanismFrameDTOList(mechanismFrameDTOList);
    }
    @Override
    public MechanismFrameDTO findAll() {
        MechanismFrameDTO mechanismFrameDTO ;
        int type = 0;

        MechanismCategory mechanismCategory = repository.findByFatherType(-1).get(0);

        mechanismFrameDTO =MechanismCategory2DTOConverter.convert(mechanismCategory);

        this.insertSonNodes(mechanismFrameDTO,type);

        return mechanismFrameDTO;
    }

    @Override
    public void addNode(MechanismFrameDTO mechanismFrameDTO) {
        repository.save(DTO2MechanismCategoryConverter.convert(mechanismFrameDTO));
    }

    @Override
    public void deleteNode(MechanismFrameDTO mechanismFrameDTO) {
        MechanismCategory mechanismCategory =repository.findByCategoryType(mechanismFrameDTO.getCategoryType());
        repository.deleteById(mechanismCategory.getCategoryId());

    }
}
