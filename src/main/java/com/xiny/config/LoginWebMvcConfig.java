//package com.xiny.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.*;
//
///**
// * Created by xiny on 2018/11/5.   shiro替代
// */
//@Configuration
//public class LoginWebMvcConfig implements WebMvcConfigurer {
//
//
//    /**
//     * 注入自定义拦截器
//     * @return
//     */
//    @Bean
//    public LoginInterceptor getLoginInterceptor(){
//        return new LoginInterceptor();
//    }
//
//
//    /**
//     * 拦截请求，安全登陆
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration registration = registry.addInterceptor(getLoginInterceptor());
//        registration.addPathPatterns("/**");
//        registration.excludePathPatterns("/login**");
//    }
//}
