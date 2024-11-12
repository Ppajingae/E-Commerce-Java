package com.yoong.ecommercejava2.domain.auth.controller;

import com.yoong.ecommercejava2.common.dto.AccessTokenResponse;
import com.yoong.ecommercejava2.common.dto.DefaultResponse;
import com.yoong.ecommercejava2.common.dto.LoginRequest;
import com.yoong.ecommercejava2.domain.auth.dto.EmailAuthRequest;
import com.yoong.ecommercejava2.domain.auth.dto.EmailAuthResponse;
import com.yoong.ecommercejava2.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login/admin")
    public ResponseEntity<AccessTokenResponse> loginAdmin(
            @RequestBody LoginRequest loginRequest
    ){
        return ResponseEntity.status(HttpStatus.OK).body(authService.loginAdmin(loginRequest));
    }

    @PostMapping("/login/seller")
    public ResponseEntity<AccessTokenResponse> loginSeller(
            @RequestBody LoginRequest loginRequest
    ){
        return ResponseEntity.status(HttpStatus.OK).body(authService.loginSeller(loginRequest));
    }

    @PostMapping("/login/buyer")
    public ResponseEntity<AccessTokenResponse> loginBuyer(
            @RequestBody LoginRequest loginRequest
    ){
        return ResponseEntity.status(HttpStatus.OK).body(authService.loginBuyer(loginRequest));
    }

    @PostMapping("/email/send")
    public ResponseEntity<DefaultResponse> sendMail(
            @RequestBody EmailAuthRequest emailAuthRequest
            ){
        return ResponseEntity.status(HttpStatus.OK).body(authService.sendMail(emailAuthRequest));
    }

    @PostMapping("/email/confirm")
    public ResponseEntity<EmailAuthResponse> verifyEmail(
            @RequestBody EmailAuthRequest emailAuthRequest,
            @RequestParam(name = "code") String code
    ){
        return ResponseEntity.status(HttpStatus.OK).body(authService.verifyEmail(emailAuthRequest, code));
    }

}

