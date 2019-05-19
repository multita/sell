package org.jt.sell.service;

import org.jt.sell.dataobject.ProductInfo;
import org.jt.sell.dto.CartDTO;
import org.jt.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {


    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

//    /** 查询商品列表. */
//    Page<ProductInfo> findList(Pageable pageable);


    ProductInfo onSale(String productId);
    ProductInfo offSale(String productId);
}
