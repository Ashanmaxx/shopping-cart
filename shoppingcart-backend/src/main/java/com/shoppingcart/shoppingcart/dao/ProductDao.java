package com.shoppingcart.shoppingcart.dao;

import com.shoppingcart.shoppingcart.domain.Product;
import com.shoppingcart.shoppingcart.dto.ProductDto;

import java.util.List;

/**
 * @author Ashan
 * @project shoppingcart
 * @date 11/7/2020
 */
public interface ProductDao  extends BaseDao<Product>{
    List<ProductDto> getAllProducts();

    ProductDto getProductById(int productId);
}
