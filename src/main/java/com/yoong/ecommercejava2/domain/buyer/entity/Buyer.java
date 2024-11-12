package com.yoong.ecommercejava2.domain.buyer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Buyer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "provider_name")
    private String providerName = null;

    @Column(name = "provider_id")
    private String providerId = null;
}
