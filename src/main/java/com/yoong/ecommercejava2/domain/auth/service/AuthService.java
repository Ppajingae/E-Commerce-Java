package com.yoong.ecommercejava2.domain.auth.service;

import com.yoong.ecommercejava2.common.dto.AccessTokenResponse;
import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.common.dto.LoginRequest;
import com.yoong.ecommercejava2.domain.auth.dto.EmailAuthRequest;
import com.yoong.ecommercejava2.domain.auth.dto.EmailAuthResponse;
import com.yoong.ecommercejava2.domain.buyer.dto.BuyerResponse;
import com.yoong.ecommercejava2.domain.buyer.entity.Buyer;
import com.yoong.ecommercejava2.domain.buyer.repository.BuyerRepository;
import com.yoong.ecommercejava2.domain.buyer.service.BuyerService;
import com.yoong.ecommercejava2.infra.security.Jwt.JwtPlugin;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final BuyerRepository buyerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtPlugin jwtPlugin;

    public AccessTokenResponse loginAdmin(LoginRequest loginRequest) {
        return null;
    }

    public AccessTokenResponse loginSeller(LoginRequest loginRequest) {
        return null;
    }

    public AccessTokenResponse loginBuyer(LoginRequest loginRequest) {

        Buyer buyer = buyerRepository.findByEmail(loginRequest.email());

        if(buyer != null && passwordEncoder.matches(loginRequest.password(), buyer.getPassword())){
            String token = jwtPlugin.generateAccessToken(buyer.getId().toString(), buyer.getEmail(), "BUYER");

            return new AccessTokenResponse(token);
        }

        throw new RuntimeException();
    }


    public DefaultResponse sendMail(EmailAuthRequest emailAuthRequest) {
        return null;
    }

    public EmailAuthResponse verifyEmail(EmailAuthRequest emailAuthRequest, String code) {
        return null;
    }
}
