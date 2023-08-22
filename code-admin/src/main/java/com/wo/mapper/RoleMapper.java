package com.wo.mapper;

import com.wo.domain.Role;

/**
* @author Wo
* @description 针对表【role】的数据库操作Mapper
* @createDate 2023-08-22 23:16:53
* @Entity com.wo.domain.Role
*/
public interface RoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

}
