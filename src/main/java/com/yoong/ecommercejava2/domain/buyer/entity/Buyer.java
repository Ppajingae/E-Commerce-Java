package com.yoong.ecommercejava2.domain.buyer.entity;

import com.yoong.ecommercejava2.domain.buyer.dto.request.CreateBuyerRequest;
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerProfileRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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

    public Buyer(CreateBuyerRequest createBuyerRequest, String encodedPassword) {
        this.nickname = createBuyerRequest.nickname();
        this.email = createBuyerRequest.email();
        this.profileImage = createBuyerRequest.profileImage();
        this.phoneNumber = createBuyerRequest.phoneNumber();
        this.address = createBuyerRequest.address();
        this.password = encodedPassword;
    }

    public void passwordUpdate(String newPassword) {

        this.password = newPassword;
    }

    public void updateImage(String imageUrl) {

        this.profileImage = imageUrl;
    }

    public void updateProfile(UpdateBuyerProfileRequest updateBuyerProfileRequest) {
        this.nickname = updateBuyerProfileRequest.nickname();
        this.phoneNumber = updateBuyerProfileRequest.phoneNumber();
        this.address = updateBuyerProfileRequest.address();
    }
}
