package com.shoppingcart.shoppingcart.dto;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author Ashan
 * @project shoppingcart
 * @date 11/7/2020
 */
@Data
public class ProductDto {
    private Integer productId;
    private String productName;
    private Boolean isActive;
}
