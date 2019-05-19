package org.jt.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ProjectName: sell
 * @Package: org.jt.sell.form
 * @ClassName: ProductForm
 * @Author: hjt
 * @Date: 2019/5/18 13:58
 * @Version: 1.0
 */
@Data
public class ProductForm {
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}
