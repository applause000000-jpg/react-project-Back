package com.park.shopbackend.security.jwt;

import com.park.shopbackend.security.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface JwtProvider {
    String generateToken(UserPrincipal userPrincipal);
    //인증정보 얻기
    Authentication getAuthentication(HttpServletRequest request);
    // 토근 유효성 검증
    boolean isTokenValid(HttpServletRequest request);
}
