package com.yoong.ecommercejava2.infra.security.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtPlugin jwtPlugin;

    private static final Pattern BEARER_PATTERN = Pattern.compile("^Bearer (.+?)$");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String jwt = getBearerToken(request);

        if (jwt != null) {

            Jws<Claims> jws = jwtPlugin.validateToken(jwt);

            String userIdString = jws.getPayload().getSubject();
            Long userId = Long.parseLong(userIdString);
            String role = jws.getPayload().get("role", String.class);
            String email = jws.getPayload().get("email", String.class);

            UserPrincipal principal = new UserPrincipal(
                    userId,
                    email,
                    Set.of(role)
            );

            JwtAuthenticationToken authentication = new JwtAuthenticationToken(
                    principal,
                    new WebAuthenticationDetailsSource().buildDetails(request)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String getBearerToken(HttpServletRequest request){
        String headerValue = request.getHeader("Authorization");

        if(headerValue == null) return null;

        Matcher matcher = BEARER_PATTERN.matcher(headerValue);

        if(matcher.find()){
            return matcher.group(1);
        }

        return null;
    }
}