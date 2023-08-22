package com.wo.mapper;

import com.wo.domain.RolePermission;

/**
* @author Wo
* @description 针对表【role_permission】的数据库操作Mapper
* @createDate 2023-08-22 23:16:53
* @Entity com.wo.domain.RolePermission
*/
public interface RolePermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

}
