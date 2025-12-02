package com.park.shopbackend.service;

import com.park.shopbackend.domain.User;
import com.park.shopbackend.security.UserPrincipal;
import com.park.shopbackend.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Log4j2
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;


    @Override
    public User signInAndReturnJWT(User signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal(); // 인증성공한 사용자 정보 얻기
        String jwt = jwtProvider.generateToken(userPrincipal); // UserPrinciple 정보를 기반으로 JWT 생성
        User signInUser = userPrincipal.getUser();
        log.info("로그인 처리 유저:``````````````````"+signInUser);
        signInUser.setToken(jwt);
        return signInUser;
    }
}
