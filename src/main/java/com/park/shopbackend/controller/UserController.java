package com.park.shopbackend.controller;


import com.park.shopbackend.domain.Role;
import com.park.shopbackend.security.UserPrincipal;
import com.park.shopbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;

    @PutMapping("/change/{role}")
    public ResponseEntity<Object> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal, @PathVariable Role role) {

    userService.changeRole(role,userPrincipal.getUsername());
    return ResponseEntity.ok(true);
    }
}
