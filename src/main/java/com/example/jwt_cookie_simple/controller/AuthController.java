package com.example.jwt_cookie_simple.controller;


import com.example.jwt_cookie_simple.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String longin(@RequestParam String username, @RequestParam String password){
        if(username.equals("Srinivas") && password.equals("Srinu@123")){
            return jwtUtil.generateToken(username);
        }else{
            return "Invalid Credentials!";
        }
    }

}
