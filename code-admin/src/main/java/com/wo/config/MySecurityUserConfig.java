//package com.wo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class MySecurityUserConfig {
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userOne = User.builder()
//                .username("zhang")
//                .password(passwordEncoder().encode("123456"))
//                .authorities("admin.add","admin.edit","admin.delete")
//                .build();
//        UserDetails userTwo = User.builder()
//                .username("li")
//                .password(passwordEncoder().encode("123456"))
//                .authorities("user.add","user.delete","user.edit","user.query")
//                .build();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(userOne);
//        manager.createUser(userTwo);
//        return manager;
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
