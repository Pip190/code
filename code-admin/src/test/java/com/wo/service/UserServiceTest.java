package com.wo.service;

import com.wo.domain.User;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class UserServiceTest {
    @Resource
    private UserService userService;
    @Test
    void selectByUsername() {
        User user = userService.selectByUsername("萧岚");
        log.info(user.toString());
    }
}