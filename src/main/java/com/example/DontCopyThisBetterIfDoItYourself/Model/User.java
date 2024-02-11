package com.example.DontCopyThisBetterIfDoItYourself.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ecommerce-user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "userId")
    private int userId;

    @Column(name = "userName", unique = true)
    private String userName;

    @Column(name = "userPassword1")
    private String userPassword1;

    @Column(name = "userPassword2")
    private String userPassword2;

    @Column(name = "userEmail")
    private String userEmail;
}
