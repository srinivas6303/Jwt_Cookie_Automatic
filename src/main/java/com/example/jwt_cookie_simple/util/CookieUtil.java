package com.example.jwt_cookie_simple.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {

    public static void addJwtToken(HttpServletResponse response,String token){
        Cookie cookie=new Cookie("jwt",token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(100+60*60);

        response.addCookie(cookie);
    }

    public static String getJwtFromCookie(HttpServletRequest request){
        if(request.getCookies()!=null){
            for(Cookie cookie: request.getCookies()){
                if("jwt".equals(cookie.getName())){
                    return  cookie.getValue();
                }
            }
        }
        return null;
    }
}
