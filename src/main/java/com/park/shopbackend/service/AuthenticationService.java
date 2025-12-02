package com.park.shopbackend.service;

import com.park.shopbackend.domain.User;

public interface AuthenticationService {
    public User signInAndReturnJWT(User signInRequest);
}
