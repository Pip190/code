package com.wo.mapper;

import com.wo.domain.User;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
    }

    @Test
    void insertSelective() {
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }

    @Test
    void listUser() {
    }

    @Test
    void selectByUsername() {
    }

    @Test
    void testSelectAllRtnBigMap() {
        Map<Long, Map<String, Object>> bigMap = userMapper.selectAllRtnBigMap();
        log.info("bigMap: {}",bigMap);
    }
    @Test
    void testSelectAllRtnListMap() {
        List<Map<String, Object>> mapList = userMapper.selectAllRtnListMap();
        log.info("mapList: {}",mapList);
    }
    @Test
    void testDeleteBatchArrayIn(){
        Long[] batchArray = {7L,8L,6L,9L};
        int deleteBatchArrayIn = userMapper.deleteBatchArrayIn(batchArray);
        log.info("批量删除条数：{}",deleteBatchArrayIn);
    }
    @Test
    void testInsertBatch(){
        // 拿数据库数据模拟批量新增数据
        List<User> users = userMapper.listUser();
        for (User user : users) {
            user.setUserId(null);
        }
        // 开始执行批量新增操作
        int insertBatch = userMapper.insertBatch(users);
        log.info("In方式 批量新增数据条数：{}",insertBatch);
    }
    @Test
    void testDeleteBatchArrayOr(){
        Long[] batchArray = {10L,11L,12L};
        int deleteBatchArrayIn = userMapper.deleteBatchArrayOr(batchArray);
        log.info("Or方式 批量删除条数：{}",deleteBatchArrayIn);
    }
}