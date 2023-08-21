package com.wo.controller;

import com.github.pagehelper.PageInfo;
import com.wo.domain.User;
import com.wo.enums.ErrorCodeEnum;
import com.wo.service.UserService;
import com.wo.utils.Result;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("{id}")
    public Result<User> getUser(@PathVariable Long id){
        return userService.selectByPrimaryKey(id);
    }
    @PostMapping
    public Result<User> saveUser(@RequestBody @Validated({User.Insert.class, Default.class}) User user){
        return userService.insert(user);
    }
    @PostMapping("selective")
    public Result<User> saveUserSelective(@RequestBody User user){
        return userService.insertSelective(user);
    }
    @PutMapping("selective/{id}")
    public Result<User> updateUserSelective(@PathVariable Long id, @RequestBody User user){
        return userService.updateByPrimaryKeySelective(id,user);
    }
    @PutMapping("{id}")
    public Result<User> updateUser(@PathVariable Long id, @RequestBody @Validated({User.Update.class, Default.class}) User user){
        return userService.updateByPrimaryKey(id,user);
    }
    @DeleteMapping("{id}")
    public Result<User> removeUser(@PathVariable Long id){
        return userService.deleteByPrimaryKey(id);
    }

    @GetMapping()
    public Result<PageInfo<User>> listUser(@RequestParam(defaultValue = "1") int pageNum,
                                           @RequestParam(defaultValue = "10") int pageSize){
        return userService.listUserPage(pageNum,pageSize);
    }

}