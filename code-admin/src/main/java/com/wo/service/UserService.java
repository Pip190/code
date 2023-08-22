package com.wo.service;

import com.github.pagehelper.PageInfo;
import com.wo.domain.User;
import com.wo.utils.Result;
import jakarta.validation.Valid;

public interface UserService {
    Result<User> deleteByPrimaryKey(Long userId);

    Result<User> insert(@Valid User record);    // 开启service校验

    Result<User> insertSelective(User record);

    Result<User> selectByPrimaryKey(Long userId);

    Result<User> updateByPrimaryKeySelective(Long userId, User record);

    Result<User> updateByPrimaryKey(Long userId, User record);

    Result<PageInfo<User>> listUserPage(int pageNum, int pageSize);

    User selectByUsername(String username);
}
