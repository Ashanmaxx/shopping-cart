package com.shoppingcart.shoppingcart.services;

import com.shoppingcart.shoppingcart.dto.ResponseDto;

/**
 * @author Ashan
 * @project shoppingcart
 * @date 11/7/2020
 */
public interface ProductService {
    ResponseDto getAllProducts();

    ResponseDto getProductPriceList(int productId);

    ResponseDto getProductPrice(int productId, int quantity);
}
