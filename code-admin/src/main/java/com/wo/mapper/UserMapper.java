package com.wo.mapper;

import com.wo.domain.User;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
* @author ASUS
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-08-21 10:05:45
* @Entity com.wo.domain.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> listUser();
}
