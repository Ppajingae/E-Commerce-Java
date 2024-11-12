package com.yoong.ecommercejava2.infra.security.Jwt;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final UserPrincipal userPrincipal;

    public JwtAuthenticationToken(UserPrincipal userPrincipal, WebAuthenticationDetails details) {
        super(userPrincipal.getAuthorities());
        this.userPrincipal = userPrincipal;
        super.setAuthenticated(true);
        super.setDetails(details);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return userPrincipal;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }
}

