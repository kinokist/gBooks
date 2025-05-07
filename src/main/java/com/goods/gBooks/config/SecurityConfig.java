package com.goods.gBooks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // CSRF 비활성화 (API 호출 테스트를 위해)
            .authorizeHttpRequests()
                .requestMatchers("/api/**").permitAll()  // 로그인 API 허용
                .anyRequest().authenticated()                   // 그 외는 인증 필요
            .and()
            .formLogin().disable(); // form 기반 로그인 비활성화 (REST API 전용)

        return http.build();
    }
}

