package com.wo.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.github.pagehelper.PageInfo;
import com.wo.domain.Permission;
import com.wo.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class PermissionServiceImplTest {
    @Resource
    private PermissionServiceImpl permissionServiceImpl;
    @Test
    void listAllPage() {
        Result<PageInfo<Permission>> pageInfoResult = permissionServiceImpl.listAllPage(1, 30);
        List<Permission> permissionList = pageInfoResult.getData().getList();
        // 创建 TreeNodeConfig 配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setWeightKey("permissionId"); // 设置节点权重字段，这里使用 permissionId 作为权重

        // 构建菜单树
        List<Tree<Integer>> treeList = TreeUtil.build(permissionList, 0, treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getPermissionId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setWeight(treeNode.getPermissionId()); // 设置节点权重
                    tree.setName(treeNode.getPermissionName()); // 设置节点名称
                    tree.putExtra("type", treeNode.getType());
                    tree.putExtra(treeNode.getType(), treeNode.getType());
                    tree.putExtra("permissionValue", treeNode.getPermissionValue());
                    tree.putExtra("path", treeNode.getPath());
                    tree.putExtra("icon", treeNode.getIcon());
                    tree.putExtra("component", treeNode.getComponent());
                    tree.putExtra("createTime", treeNode.getCreateTime());
                });
        // 此时，treeList 中包含了构建好的菜单树
        log.info("构建好的菜单树：{}", treeList);

    }
}