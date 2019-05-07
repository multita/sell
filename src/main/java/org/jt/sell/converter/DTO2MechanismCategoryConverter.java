package org.jt.sell.converter;

import org.jt.sell.dataobject.MechanismCategory;
import org.jt.sell.dto.MechanismFrameDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.converter
 * @ClassName: DTO2MechanismCategoryConverter
 * @Author: hjt
 * @Date: 2019/5/6 22:08
 * @Version: 1.0
 */
public class DTO2MechanismCategoryConverter {
    public  static MechanismCategory convert(MechanismFrameDTO mechanismFrameDTO){

        MechanismCategory mechanismCategory = new MechanismCategory();
        BeanUtils.copyProperties(mechanismFrameDTO,mechanismCategory);
        return mechanismCategory;
    }
    public static List<MechanismCategory> convert(List<MechanismFrameDTO> mechanismFrameDTOList){

        return mechanismFrameDTOList.stream().map(
                e ->convert(e)
        ).collect(Collectors.toList());

    }
}
