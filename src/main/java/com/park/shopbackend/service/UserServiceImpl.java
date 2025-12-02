package com.park.shopbackend.service;


import com.park.shopbackend.domain.Role;
import com.park.shopbackend.domain.User;
import com.park.shopbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Log4j2
//@RequiredArgsConstructor(onConstructor_ = @Autowired))
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

//    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public void changeRole(Role newrole, String username) {
        userRepository.updateUserRole(username, newrole);
    }

    @Override
    public void deleteUser(Long id) {
    userRepository.deleteById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
