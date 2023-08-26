package com.wo.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PermissionServiceTest {
    @Resource
    private PermissionService permissionService;
    @Test
    void listAllPage() {
        permissionService.listAllPage(1,40);
    }
}