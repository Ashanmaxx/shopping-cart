/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoppingcart.shoppingcart.domain;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "product_carton")
@XmlRootElement
@Data
@NamedQueries({
    @NamedQuery(name = "ProductCarton.findAll", query = "SELECT p FROM ProductCarton p")
    , @NamedQuery(name = "ProductCarton.findByProductCartonId", query = "SELECT p FROM ProductCarton p WHERE p.productCartonId = :productCartonId")
    , @NamedQuery(name = "ProductCarton.findByProductCartonPrice", query = "SELECT p FROM ProductCarton p WHERE p.productCartonPrice = :productCartonPrice")
    , @NamedQuery(name = "ProductCarton.findByIsActive", query = "SELECT p FROM ProductCarton p WHERE p.isActive = :isActive")})
public class ProductCarton implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_carton_id", nullable = false)
    private Integer productCartonId;
    @Basic(optional = false)
    @Column(name = "product_carton_price", nullable = false)
    private double productCartonPrice;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private int isActive;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @ManyToOne(optional = false)
    private Product productId;

}
