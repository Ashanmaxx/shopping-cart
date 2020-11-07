package com.shoppingcart.shoppingcart.dto;

import com.shoppingcart.shoppingcart.domain.Product;
import lombok.Data;

/**
 * @author Ashan
 * @project shoppingcart
 * @date 11/7/2020
 */
@Data
public class ProductCartonDto {
    private Integer productCartonId;
    private double productCartonPrice;
    private int isActive;
    private ProductDto productDto;
}
