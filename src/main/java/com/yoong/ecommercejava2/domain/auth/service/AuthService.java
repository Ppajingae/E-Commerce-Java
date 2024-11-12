package com.yoong.ecommercejava2.domain.auth.service;

import com.yoong.ecommercejava2.common.dto.AccessTokenResponse;
import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.common.dto.LoginRequest;
import com.yoong.ecommercejava2.domain.auth.dto.EmailAuthRequest;
import com.yoong.ecommercejava2.domain.auth.dto.EmailAuthResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public AccessTokenResponse loginAdmin(LoginRequest loginRequest) {
        return null;
    }

    public AccessTokenResponse loginSeller(LoginRequest loginRequest) {
        return null;
    }

    public AccessTokenResponse loginBuyer(LoginRequest loginRequest) {
        return null;
    }


    public DefaultResponse sendMail(EmailAuthRequest emailAuthRequest) {
        return null;
    }

    public EmailAuthResponse verifyEmail(EmailAuthRequest emailAuthRequest, String code) {
        return null;
    }
}
