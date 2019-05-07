package org.jt.sell.converter;

import org.jt.sell.dataobject.MechanismCategory;
import org.jt.sell.dataobject.OrderMaster;
import org.jt.sell.dto.MechanismFrameDTO;
import org.jt.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.converter
 * @ClassName: MechanismCategory2DTOConverter
 * @Author: hjt
 * @Date: 2019/5/6 20:13
 * @Version: 1.0
 */
public class MechanismCategory2DTOConverter {
    public  static MechanismFrameDTO convert(MechanismCategory mechanismCategory){

        MechanismFrameDTO mechanismFrameDTO = new MechanismFrameDTO();
        BeanUtils.copyProperties(mechanismCategory,mechanismFrameDTO);
        return mechanismFrameDTO;
    }
    public static List<MechanismFrameDTO> convert(List<MechanismCategory> mechanismCategoryList){

        return mechanismCategoryList.stream().map(
                e ->convert(e)
        ).collect(Collectors.toList());

    }
}
