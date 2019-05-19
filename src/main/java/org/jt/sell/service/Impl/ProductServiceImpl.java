package org.jt.sell.service.Impl;

import org.jt.sell.converter.OrderMaster2OrderDTOConverter;
import org.jt.sell.dataobject.OrderMaster;
import org.jt.sell.dataobject.ProductInfo;
import org.jt.sell.dto.CartDTO;
import org.jt.sell.dto.OrderDTO;
import org.jt.sell.enums.ProductStatusEnum;
import org.jt.sell.enums.ResultEnum;
import org.jt.sell.exception.SellException;
import org.jt.sell.repository.ProductInfoRepository;
import org.jt.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements  ProductService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).get();

    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO: cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }

    /**
     * 要么全成功  要么全不成功
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO: cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            repository.save(productInfo);
        }
    }

//    @Override
//    public Page<ProductInfo> findList(Pageable pageable) {
//        Page<ProductInfo> productInfoPage = repository.findAll(pageable);
//        List<ProductInfo> productInfoList = productInfoPage.getContent();
//        return new PageImpl<ProductInfo>(productInfoList, pageable, productInfoPage.getTotalElements());
//
//    }
@Override
public ProductInfo onSale(String productId) {
    ProductInfo productInfo = repository.findById(productId).get();
    if (productInfo == null) {
        throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
    }
    if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
        throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
    }

    //更新
    productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
    return repository.save(productInfo);
}

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = repository.findById(productId).get();
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }

        //更新
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo);
    }

}
