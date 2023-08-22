package com.wo.controller;

import com.github.pagehelper.PageInfo;
import com.wo.domain.User;
import com.wo.service.UserService;
import com.wo.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("public")
public class PublicController {
    @Resource
    private UserService userService;
    @PostMapping
    public Result<User> saveUser(@RequestBody /*@Valid*/ User user){
        return userService.insert(user);
    }
    @GetMapping
    public Result<PageInfo<User>> listUser(){
        return userService.listUserPage(1,10);
    }
}
