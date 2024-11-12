package com.yoong.ecommercejava2.domain.admin.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

}
