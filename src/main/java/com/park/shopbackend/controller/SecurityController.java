package com.park.shopbackend.controller;

import com.park.shopbackend.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {


    @GetMapping("/username")
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        UserDetails userDetails = (UserDetails)
                authentication.getPrincipal();
        return userDetails.getUsername();

    }

    @GetMapping("/messages/inbox")
    public ModelAndView currentUserName(@AuthenticationPrincipal User user) {
        String username = user.getUsername();
        return new ModelAndView("user/inbox", "username", username);
    }
}
