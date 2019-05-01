package org.jt.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jt.sell.dataobject.ProductInfo;

import java.util.List;

/**
 * 返回  （前端需要的 ）商品部分信息
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private  Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

    public ProductVO() {
    }

    public ProductVO(String categoryName, Integer categoryType, List<ProductInfoVO> productInfoVOList) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.productInfoVOList = productInfoVOList;
    }
}
