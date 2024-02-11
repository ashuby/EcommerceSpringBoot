package com.example.DontCopyThisBetterIfDoItYourself.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

@Entity
@Data
@Table(name = "ecommerce-product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "productId")
    private int productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productPrice")
    private Integer productPrice;

    @Column(name = "productDescription")
    private String productDes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category;
}
