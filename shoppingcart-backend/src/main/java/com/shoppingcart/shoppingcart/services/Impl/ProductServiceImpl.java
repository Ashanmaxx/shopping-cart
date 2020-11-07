package com.shoppingcart.shoppingcart.services.Impl;

import com.shoppingcart.shoppingcart.Util.ServiceUtil;
import com.shoppingcart.shoppingcart.dto.ProductDto;
import com.shoppingcart.shoppingcart.dto.ProductPriceDto;
import com.shoppingcart.shoppingcart.dto.ResponseDto;
import com.shoppingcart.shoppingcart.services.BL.ProductServiceBL;
import com.shoppingcart.shoppingcart.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ashan
 * @project shoppingcart
 * @date 11/7/2020
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ServiceUtil serviceUtil;

    @Autowired
    ProductServiceBL productServiceBL;

    @Override
    public ResponseDto getAllProducts() {

        log.info("ProductServiceImpl.getAllProducts() invoked.");
        ResponseDto responseDto = null;
        try {
            List<ProductDto> productDtoList = productServiceBL
                    .getAllProducts();
            if (productDtoList != null) {
                responseDto = serviceUtil.getServiceResponse(productDtoList);
            } else {
                responseDto = serviceUtil.getErrorServiceResponse(
                        "Error occurs when retrieving products");
            }
        } catch (Exception e) {
            responseDto = serviceUtil.getErrorServiceResponse(e);
        }
        return responseDto;
    }

    @Override
    public ResponseDto getProductPriceList(int productId) {
        ResponseDto responseDto = null;
        try {
            List<ProductPriceDto> productPriceDtosList = productServiceBL
                    .getProductPriceList(productId);
            if (productPriceDtosList != null) {
                responseDto = serviceUtil.getServiceResponse(productPriceDtosList);
            } else {
                responseDto = serviceUtil.getErrorServiceResponse(
                        "Error occurs when retrieving products");
            }
        } catch (Exception e) {
            responseDto = serviceUtil.getErrorServiceResponse(e);
        }
        return responseDto;
    }

    @Override
    public ResponseDto getProductPrice(int productId, int quantity) {
        ResponseDto responseDto = null;
        try {
            ProductPriceDto productPriceDtos = productServiceBL
                    .getProductUniquePrice(productId, quantity);
            if (productPriceDtos != null) {
                responseDto = serviceUtil.getServiceResponse(productPriceDtos);
            } else {
                responseDto = serviceUtil.getErrorServiceResponse(
                        "Error occurs when retrieving products");
            }
        } catch (Exception e) {
            responseDto = serviceUtil.getErrorServiceResponse(e);
        }
        return responseDto;
    }
}
