package com.tomik.RestApi.RestLastTask.controllers;

import com.tomik.RestApi.RestLastTask.models.User;
import com.tomik.RestApi.RestLastTask.security.MyUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UsersController {

    @GetMapping("/api/user")
    @ResponseBody
    public ResponseEntity<User> showUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails = (MyUserDetails) auth.getPrincipal();
        return new ResponseEntity<>(myUserDetails.getUser(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public String userPage() {
        return "user";
    }
}
