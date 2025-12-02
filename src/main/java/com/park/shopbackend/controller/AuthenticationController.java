package com.park.shopbackend.controller;

import com.park.shopbackend.domain.User;
import com.park.shopbackend.service.AuthenticationService;
import com.park.shopbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;
    @PostMapping("/sign-up")
    public ResponseEntity<Object> signUp(@RequestBody User user) {
        if(userService.findUserByUsername(user.getUsername())!=null){  // 중복 값이 존재하면
            return new ResponseEntity<>(HttpStatus.CONFLICT);  // 409 CONFICT  : Spring Security에서 인증실패 예외 처리
        }
        // 새 User DB에 저장하고 , 201 상태코드 반환
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED); }
    @PostMapping("/sign-in")
    public ResponseEntity<Object> signIn(@RequestBody User user){
        // 로그인 성공 시, 생성된 JWT와 함께상태코드200 반환
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }

}
