package com.wo.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wo.domain.Permission;
import com.wo.mapper.PermissionMapper;
import com.wo.service.PermissionService;
import com.wo.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public Result<PageInfo<Permission>> listAllPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Permission> permissionList = permissionMapper.listAll();


        PageInfo<Permission> pageInfo = new PageInfo<>(permissionList);

        return Result.ok("查询成功", pageInfo);
    }
}
