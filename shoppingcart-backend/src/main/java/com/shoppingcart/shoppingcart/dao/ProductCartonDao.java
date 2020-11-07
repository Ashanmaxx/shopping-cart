package com.shoppingcart.shoppingcart.dao;

import com.shoppingcart.shoppingcart.domain.ProductCarton;
import com.shoppingcart.shoppingcart.dto.ProductCartonDto;

/**
 * @author Ashan
 * @project shoppingcart
 * @date 11/7/2020
 */
public interface ProductCartonDao extends BaseDao<ProductCarton>{
    ProductCartonDto getProductCarton(int productId);
}
