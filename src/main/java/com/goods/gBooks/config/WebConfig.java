package com.goods.gBooks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // Flutter 웹 주소로 대체
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);  // 쿠키나 인증 정보를 허용
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**");
                //.addResourceLocations("file:///C:/Users/bob/studyJava/flutter_java/src/main/resources/static/images/");
                //.addResourceLocations("file:./images/");
                //C:\Users\bob\studyJava\flutter_java\src\main\resources\static\images
    }
}
