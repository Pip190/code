package com.wo.mapper;

import com.wo.domain.UserRole;

/**
* @author Wo
* @description 针对表【user_role】的数据库操作Mapper
* @createDate 2023-08-22 23:16:53
* @Entity com.wo.domain.UserRole
*/
public interface UserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

}
