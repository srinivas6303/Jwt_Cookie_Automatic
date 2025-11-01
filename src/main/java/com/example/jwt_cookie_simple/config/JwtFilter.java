package com.example.jwt_cookie_simple.config;

import com.example.jwt_cookie_simple.util.CookieUtil;
import com.example.jwt_cookie_simple.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public  class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CookieUtil cookieUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String path=request.getRequestURI();
        if(path.equals("/login")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = cookieUtil.getJwtFromCookie(request);

        if(token!=null){
            try {
                String username= jwtUtil.extractUsername(token);

                if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                    if(jwtUtil.validateToken(token,username)){
                        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,username,Collections.emptyList());
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }
            }catch (Exception e){
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Invalid or expired token");
            }
        }else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header");
            return;
        }

        filterChain.doFilter(request,response);
    }
}