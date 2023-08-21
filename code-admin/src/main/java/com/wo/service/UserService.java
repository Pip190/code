package com.wo.service;

import com.github.pagehelper.PageInfo;
import com.wo.domain.User;
import com.wo.utils.Result;
import jakarta.validation.Valid;

public interface UserService {
    Result<User> deleteByPrimaryKey(Long id);

    Result<User> insert(@Valid User record);

    Result<User> insertSelective(User record);

    Result<User> selectByPrimaryKey(Long id);

    Result<User> updateByPrimaryKeySelective(Long id, User record);

    Result<User> updateByPrimaryKey(Long id, User record);

    Result<PageInfo<User>> listUserPage(int pageNum, int pageSize);
}
