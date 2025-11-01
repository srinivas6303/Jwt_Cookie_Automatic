package com.example.jwt_cookie_simple.controller;


import com.example.jwt_cookie_simple.util.CookieUtil;
import com.example.jwt_cookie_simple.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CookieUtil cookieUtil;

    @PostMapping("/login")
    public String longin(@RequestParam String username, @RequestParam String password, HttpServletResponse response){
        if(username.equals("Srinivas") && password.equals("Srinu@123")){
            String token = jwtUtil.generateToken(username);
            cookieUtil.addJwtToken(response,token);
            return "Login successful! JWT stored in cookie.";
        }else{
            return "Invalid Credentials!";
        }
    }

}
