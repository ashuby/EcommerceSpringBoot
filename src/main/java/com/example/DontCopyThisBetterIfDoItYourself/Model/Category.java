package com.example.DontCopyThisBetterIfDoItYourself.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ecommerce-category")
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category")
    private int categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "categoryDes")
    private String categoryDescription;
}
