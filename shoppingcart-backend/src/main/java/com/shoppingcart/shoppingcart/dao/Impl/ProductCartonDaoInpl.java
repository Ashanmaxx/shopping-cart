package com.shoppingcart.shoppingcart.dao.Impl;

import com.shoppingcart.shoppingcart.dao.ProductCartonDao;
import com.shoppingcart.shoppingcart.domain.ProductCarton;
import com.shoppingcart.shoppingcart.dto.ProductCartonDto;
import com.shoppingcart.shoppingcart.dto.ProductDto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * @author Ashan
 * @project shoppingcart
 * @date 11/7/2020
 */
@Repository
public class ProductCartonDaoInpl extends BaseDaoImpl<ProductCarton> implements ProductCartonDao {
    @Override
    public ProductCartonDto getProductCarton(int productId) {
        ProductCartonDto productCartonDto = null;
        Criteria criteria = getCurrentSession().createCriteria(ProductCarton.class, "productCarton");
        criteria.createAlias("productCarton.productId", "product");
        criteria.add(Restrictions.eq("product.productId", productId));

        ProductCarton productCarton = (ProductCarton) criteria.uniqueResult();
        if (productCarton != null) {
            productCartonDto = new ProductCartonDto();
            ProductDto productDto = null;
            productCartonDto.setIsActive(productCarton.getProductCartonId());
            productCartonDto.setProductCartonId(productCarton.getProductCartonId());
            productCartonDto.setProductCartonPrice(productCarton.getProductCartonPrice());

            if (productCarton.getProductId() != null) {
                productDto = new ProductDto();
                productDto.setProductId(productCarton.getProductId().getProductId());
                productDto.setProductName(productCarton.getProductId().getProductName());
                productDto.setIsActive(productCarton.getProductId().getIsActive());
                productCartonDto.setProductDto(productDto);
            }

        }
        return productCartonDto;
    }
}
