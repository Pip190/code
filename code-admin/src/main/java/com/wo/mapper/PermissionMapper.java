package com.wo.mapper;
import java.util.List;

import com.wo.domain.Permission;

/**
* @author Wo
* @description 针对表【permission】的数据库操作Mapper
* @createDate 2023-08-22 23:16:53
* @Entity com.wo.domain.Permission
*/
public interface PermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> listAll();

}
