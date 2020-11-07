/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcart.shoppingcart.domain;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * +
 *
 * @author HP
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")})
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer productId;
    @Basic(optional = false)
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private List<ProductCarton> productCartonList;
}
