package com.wo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
public class LoginController {
    @GetMapping("/loginOne")
    public Authentication getLoginUserOne(Authentication authentication) {
        return authentication;
    }
    @GetMapping("/loginTwo")
    public Principal getLoginUserTwo(Principal principal) {
        return principal;
    }
    @GetMapping("/loginThree")
    public Authentication getLoginUserThree() {
        // 通过安全上下文持有器获取安全上下文，再获取认证信息
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
