package com.mandala.mfincore.config;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String username = JwtTokenUtil.getSubject(httpServletRequest, jwtTokenCookieName, signingKey);
        if(username == null){
            String authService = this.getFilterConfig().getInitParameter("services.auth");
            try {
                httpServletResponse.sendRedirect(authService + "?ref=" + httpServletRequest.getRequestURL());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
            httpServletRequest.setAttribute("username", username);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}
