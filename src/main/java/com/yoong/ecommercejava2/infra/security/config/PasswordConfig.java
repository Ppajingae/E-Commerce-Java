package com.yoong.ecommercejava2.infra.security.config;

import com.yoong.ecommercejava2.common.ex.exception.PasswordException;
import com.yoong.ecommercejava2.domain.buyer.dto.request.UpdateBuyerPasswordRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    public String validPassword(String password, UpdateBuyerPasswordRequest request) {

        if(!encoder().matches(request.currentPassword(), password)) throw new PasswordException(401, "비밀번호가 일치하지 않습니다");
        if(encoder().matches(request.newPassword(), password)) throw new PasswordException(401, "현재 비밀번호와 수정할 비밀번호가 같습니다");

        return encoder().encode(request.newPassword());
    }
}
