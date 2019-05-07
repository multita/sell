package org.jt.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.omg.CORBA.INTERNAL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.dataobject
 * @ClassName: MechanismCategory
 * @Author: hjt
 * @Date: 2019/5/6 16:42
 * @Version: 1.0
 */

@Proxy(lazy = false)
@Entity
@Data
public class MechanismCategory {
    /** 类目id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    /** 类目级别. */
    private Integer categoryLevel;

    /** 父类编号. */
    private Integer fatherType;

    /** 子节点数. */
    private Integer SonsNumber;

    public MechanismCategory(String categoryName, Integer categoryType, Integer categoryLevel, Integer fatherType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.categoryLevel = categoryLevel;
        this.fatherType = fatherType;
        this.SonsNumber = 0;
    }
    public  MechanismCategory(){

    }
}
