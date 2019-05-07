package org.jt.sell.dto;

import lombok.Data;

import java.util.List;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.dto
 * @ClassName: mechanismFrameDTO
 * @Author: hjt
 * @Date: 2019/5/6 19:55
 * @Version: 1.0
 */

@Data
public class MechanismFrameDTO {

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    /** 类目级别. */
    private Integer categoryLevel;

    /** 父类编号. */
    private Integer fatherType;

    /** 子节点数. */
    private Integer sonsNumber;

    public List<MechanismFrameDTO> mechanismFrameDTOList;

    public MechanismFrameDTO(){
    }

    public MechanismFrameDTO(String categoryName, Integer categoryType, Integer categoryLevel, Integer fatherType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.categoryLevel = categoryLevel;
        this.fatherType = fatherType;
        this.sonsNumber =0;
    }

    public MechanismFrameDTO(String categoryName, Integer categoryType, Integer categoryLevel, Integer fatherType, Integer sonsNumber, List<MechanismFrameDTO> mechanismFrameDTOList) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.categoryLevel = categoryLevel;
        this.fatherType = fatherType;
        this.sonsNumber = sonsNumber;
        this.mechanismFrameDTOList = mechanismFrameDTOList;
    }
}
