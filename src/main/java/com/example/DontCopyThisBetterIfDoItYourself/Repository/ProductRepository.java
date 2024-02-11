package com.example.DontCopyThisBetterIfDoItYourself.Repository;

import com.example.DontCopyThisBetterIfDoItYourself.Model.Product;
import com.example.DontCopyThisBetterIfDoItYourself.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT p FROM Product p where p.productName like :productName and p.productDes like :productDes")
    List<Product> getProductByAnyField(String productName, String productDes);

    @Query(value = "SELECT p FROM Product p where p.productName like :productName and p.productPrice = :productPrice and p.productDes like :productDes")
    List<Product> getProductByAnyField(String productName, Integer productPrice, String productDes);
}
