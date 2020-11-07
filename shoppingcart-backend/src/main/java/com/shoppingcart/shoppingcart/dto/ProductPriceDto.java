package com.shoppingcart.shoppingcart.dto;

import lombok.Data;

/**
 * @author Ashan
 * @project shoppingcart
 * @date 11/7/2020
 */
@Data
public class ProductPriceDto {
    private int productQuantity;
    private Double price;
    private String productName;
}
