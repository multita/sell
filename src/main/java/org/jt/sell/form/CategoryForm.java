package org.jt.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.form
 * @ClassName: CategoryForm
 * @Author: hjt
 * @Date: 2019/5/18 15:35
 * @Version: 1.0
 */
@Data
public class CategoryForm {


    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
