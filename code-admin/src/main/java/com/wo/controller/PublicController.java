package com.wo.controller;

import com.wo.domain.User;
import com.wo.service.UserService;
import com.wo.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public")
public class PublicController {
    @Resource
    private UserService userService;
    @PostMapping
    public Result<User> saveUser(@RequestBody /*@Valid*/ User user){
        return userService.insert(user);
    }
}
