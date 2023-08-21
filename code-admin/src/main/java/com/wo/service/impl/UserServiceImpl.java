package com.wo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wo.domain.User;
import com.wo.mapper.UserMapper;
import com.wo.service.UserService;
import com.wo.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Objects;

@Service
@Validated
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public Result<User> deleteByPrimaryKey(Long id) {
        int deleteByPrimaryKey = this.userMapper.deleteByPrimaryKey(id);
        if (deleteByPrimaryKey>0){
            return Result.ok("删除成功");
        }
        return Result.error("删除失败");
    }

    @Override
    public Result<User> insert(User record) {
        int insert = this.userMapper.insert(record);
        if (insert>0){
            return Result.created("添加成功",record);
        }
        return Result.error("添加失败");
    }

    @Override
    public Result<User> insertSelective(User record) {
        int insertSelective = this.userMapper.insertSelective(record);
        if (insertSelective>0){
            return Result.created("添加成功",record);
        }
        return Result.error("添加失败");
    }

    @Override
    public Result<User> selectByPrimaryKey(Long id) {
        User user = this.userMapper.selectByPrimaryKey(id);
        if (!ObjectUtils.isEmpty(user)){
            return Result.ok("查询成功",user);
        }
        return Result.noContent("资源不存在");
    }

    @Override
    public Result<User> updateByPrimaryKeySelective(Long id, User source) {
        User user = this.userMapper.selectByPrimaryKey(id);
        if (Objects.nonNull(user)){
            CopyOptions copyOptions = CopyOptions.create().setIgnoreNullValue(true).setIgnoreProperties("id");
            BeanUtil.copyProperties(source,user,copyOptions);
            int updateByPrimaryKeySelective = this.userMapper.updateByPrimaryKeySelective(user);
            if (updateByPrimaryKeySelective>0){
                return Result.ok("修改成功");
            }
            return Result.noContent("修改失败");
        }
        return Result.error("修改失败");
    }

    @Override
    public Result<User> updateByPrimaryKey(Long id, User source) {
        User user = this.userMapper.selectByPrimaryKey(id);
        if (Objects.nonNull(user)){
            BeanUtil.copyProperties(source,user,"id");
            int updateByPrimaryKey = this.userMapper.updateByPrimaryKey(user);
            if (updateByPrimaryKey>0){
                return Result.ok("修改成功");
            }
        }
        return Result.noContent("修改失败");
    }

    @Override
    public Result<PageInfo<User>> listUserPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList=userMapper.listUser();
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        return Result.ok("查询成功",pageInfo);
    }
}