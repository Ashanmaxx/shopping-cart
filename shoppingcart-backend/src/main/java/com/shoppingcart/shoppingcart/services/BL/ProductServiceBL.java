package com.shoppingcart.shoppingcart.services.BL;

import com.shoppingcart.shoppingcart.dao.ProductCartonDao;
import com.shoppingcart.shoppingcart.dao.ProductDao;
import com.shoppingcart.shoppingcart.dto.ProductCartonDto;
import com.shoppingcart.shoppingcart.dto.ProductDto;
import com.shoppingcart.shoppingcart.dto.ProductPriceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashan
 * @project shoppingcart
 * @date 11/7/2020
 */
@Service
@Slf4j
public class ProductServiceBL {

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductCartonDao productCartonDao;

    public List<ProductDto> getAllProducts() {
        return productDao.getAllProducts();
    }

    public List<ProductPriceDto> getProductPriceList(int productId) {
        List<ProductPriceDto> productPriceDtoList = new ArrayList<>();

        ProductCartonDto productCartonDto = productCartonDao.getProductCarton(productId);

        for (int i = 1; i < 51; i++) {
            ProductPriceDto productPriceDto = getProductPrice(productCartonDto.getProductDto().getProductName(), i,
                    productCartonDto.getProductCartonPrice());
            productPriceDtoList.add(productPriceDto);
        }

        return productPriceDtoList;
    }

    public ProductPriceDto getProductPrice(String productType, int quantity, Double cartonPrice) {
        ProductPriceDto productPriceDto = null;
        int devider;
        float incrementPercent;
        Double totalAmount = 0.0;

        if (productType.equals("Penguin-ears")) {
            devider = 20;
        } else {
            devider = 5;
        }

        if (quantity % devider == 0) {
            if (quantity / devider >= 3) {
                totalAmount = (quantity / devider) * (cartonPrice * 0.9);
            } else {
                totalAmount = (quantity / devider) * cartonPrice;
            }
        }
        if (quantity < devider) {
            totalAmount = ((cartonPrice * 1.3) / devider) * quantity;
        }
        if (quantity > devider) {
            if (quantity / devider >= 3) {
                totalAmount = ((quantity / devider) * (cartonPrice * 0.9)) + (((cartonPrice * 1.3) / devider) * (quantity % devider));
            } else {
                totalAmount = ((quantity / devider) * cartonPrice) + (((cartonPrice * 1.3) / devider) * (quantity % devider));
            }

        }
        productPriceDto = new ProductPriceDto();
        productPriceDto.setPrice(totalAmount);
        productPriceDto.setProductQuantity(quantity);
        productPriceDto.setProductName(productType);
        return productPriceDto;
    }

    public ProductPriceDto getProductUniquePrice(int productId, int quantity) {
        ProductPriceDto productPriceDto;
        ProductCartonDto productCartonDto = productCartonDao.getProductCarton(productId);
        productPriceDto = getProductPrice(productCartonDto.getProductDto().getProductName(),
                quantity, productCartonDto.getProductCartonPrice());
        return productPriceDto;
    }
}
