package com.wo.config;

import com.wo.security.AppAccessDeniedHandler;
import com.wo.security.AppAuthenticationFailureHandler;
import com.wo.security.AppAuthenticationSuccessHandler;
import com.wo.security.AppLogoutSuccessHandler;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {
    @Resource
    private AppAuthenticationSuccessHandler successHandler;
    @Resource
    private AppAuthenticationFailureHandler failureHandler;
    @Resource
    private AppLogoutSuccessHandler logoutHandler;
    @Resource
    private AppAccessDeniedHandler deniedHandler;
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/blog/**")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated()
//                )
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/login")
//                        .permitAll()
//                )
//                .rememberMe(Customizer.withDefaults());
//
//        return http.build();
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/blog/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .successHandler(successHandler) // 配置认证成功处理器
                        .failureHandler(failureHandler) // 配置认证失败处理器
    //                    .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessHandler(logoutHandler)    // 配置退出成功处理器
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedHandler(deniedHandler) // 配置访问拒绝处理器
                )
                .rememberMe(Customizer.withDefaults());

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
