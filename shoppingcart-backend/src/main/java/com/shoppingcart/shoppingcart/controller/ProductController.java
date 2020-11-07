package com.shoppingcart.shoppingcart.controller;

import com.shoppingcart.shoppingcart.dto.ResponseDto;
import com.shoppingcart.shoppingcart.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ashan
 * @project shoppingcart
 * @date 11/7/2020
 */
@RequestMapping("product")
@RestController
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @CrossOrigin
    @GetMapping("/all")
    public ResponseDto getAllProducts(){
        log.info("ProductController.getAllProducts() invoked");
        return productService.getAllProducts();
    }

    @CrossOrigin
    @GetMapping("/productPrice/{productId}")
    public ResponseDto getProductPriceList(@PathVariable int productId){
        log.info("ProductController.getAllProducts() invoked");
        return productService.getProductPriceList(productId);
    }

    @CrossOrigin
    @GetMapping("/productPrice")
    public ResponseDto getProductPrice(@RequestParam int  productId,@RequestParam int quantity){
        log.info("ProductController.getProductPrice() invoked");
        return productService.getProductPrice(productId,quantity);
    }
}
