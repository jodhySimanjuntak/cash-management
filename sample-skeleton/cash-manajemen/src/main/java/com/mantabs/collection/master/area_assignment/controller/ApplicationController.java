package com.mantabs.collection.master.area_assignment.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mandala.mfincore.config.CookieUtil;
import com.mandala.mfincore.config.JwtFilter;

@Controller
public class ApplicationController {

    @Value("${mfincore.homepage}")
    private String appRoot;


    @Value("${mfincore.cookieName}")
    private String jwtTokenCookieName;

    @GetMapping("/")
    public String home(){
        return appRoot;
    }

    @Value("${mfincore.authserver}")
    private String authService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public FilterRegistrationBean jwtFilter() {
//        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new JwtFilter());
//        registrationBean.setInitParameters(Collections.singletonMap("services.auth", authService));
//        registrationBean.addUrlPatterns("/");
//        registrationBean.addUrlPatterns(appRoot);
//
//        return registrationBean;
//    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse httpServletResponse) {
        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
        return "redirect:/";
    }

}
