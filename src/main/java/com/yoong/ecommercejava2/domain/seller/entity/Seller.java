package com.yoong.ecommercejava2.domain.seller.entity;

import com.yoong.ecommercejava2.domain.seller.dto.CreateSellerRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="seller")
@NoArgsConstructor
public class Seller {

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

    public Seller(CreateSellerRequest createSellerRequest, String encodedPassword) {
        this.address = createSellerRequest.address();
        this.email = createSellerRequest.email();
        this.nickname = createSellerRequest.nickname();
        this.password = encodedPassword;
        this.phoneNumber = createSellerRequest.phoneNumber();
        this.profileImage = "test";
    }
}
