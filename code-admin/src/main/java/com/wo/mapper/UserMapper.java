package com.wo.mapper;
import java.util.Collection;

import com.wo.domain.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author ASUS
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-08-21 10:05:45
* @Entity com.wo.domain.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> listUser();
    User selectByUsername(String username);
    @MapKey("user_id")
    Map<Long, Map<String,Object>> selectAllRtnBigMap();
    @MapKey("user_id") // 此处不写默认是第一列，如果你没有显式地指定@MapKey注解，MyBatis会默认使用查询结果中的第一个字段作为键值。
    List<Map<String,Object>> selectAllRtnListMap();

    /**
     * 批量删除in方式
     * @param userIds 删除的主键数组
     * @return 删除成功的条数
     */
    int deleteBatchArrayIn(@Param("userIds") Long[] userIds);
    int deleteBatchArrayOr(@Param("userIds") Long[] userIds);
    /**
     * 批量插入
     * @param userCollection 用户集合
     * @return 添加成功的用户集合
     */
    int insertBatch(@Param("userCollection") Collection<User> userCollection);
}
