package com.shoppingcart.shoppingcart.dao.Impl;

import com.shoppingcart.shoppingcart.dao.ProductDao;
import com.shoppingcart.shoppingcart.domain.Product;
import com.shoppingcart.shoppingcart.dto.ProductDto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ashan
 * @project shoppingcart
 * @date 11/7/2020
 */
@Repository
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {
    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtoList = null;
        Criteria criteria = getCurrentSession().createCriteria(Product.class);
        List<Product> productList = criteria.list();

        if (productList != null) {
            productDtoList = new ArrayList<>();
            for (Product product : productList) {
                ProductDto productDto = new ProductDto();
                productDto.setProductId(product.getProductId());
                productDto.setProductName(product.getProductName());
                productDto.setIsActive(product.getIsActive());
                productDtoList.add(productDto);
            }

        }

        return productDtoList;
    }

    @Override
    public ProductDto getProductById(int productId) {
        ProductDto productDto = null;
        Criteria criteria = getCurrentSession().createCriteria(Product.class, "product");
        criteria.add(Restrictions.eq("product.productId", productId));
        Product product = (Product) criteria.uniqueResult();
        if (product != null) {
            productDto = new ProductDto();
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setIsActive(product.getIsActive());
        }
        return productDto;
    }
}
