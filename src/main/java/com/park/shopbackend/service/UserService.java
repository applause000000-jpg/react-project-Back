package com.park.shopbackend.service;

import com.park.shopbackend.domain.Role;
import com.park.shopbackend.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    void changeRole(Role newrole,String username);
    void deleteUser(Long id);
    List<User> findAllUsers();
}
