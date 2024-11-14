package com.yoong.ecommercejava2.infra.security.config;


import com.yoong.ecommercejava2.infra.security.CustomAccessDinedHandler;
import com.yoong.ecommercejava2.infra.security.CustomAuthenticationEntryPoint;
import com.yoong.ecommercejava2.infra.security.Jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomAccessDinedHandler customAccessDinedHandler;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http
    ) throws Exception {
        return http
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((it) ->
                        it.requestMatchers(
                                        "/api/v1/login",
                                        "/api/v1/buyer/user_signup",
                                        "/api/v1/seller/user_signup",
                                        "/swagger-ui/**",
                                        "/v3/api-docs/**",
                                        "/api/v1/**",
                                        "/oauth/login/**",
                                        "/api/v1/emails/**"
                                ).permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling((it) ->
                        it.authenticationEntryPoint(customAuthenticationEntryPoint)
                                .accessDeniedHandler(customAccessDinedHandler)
                )
                .build();
    }
}