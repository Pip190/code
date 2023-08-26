package com.wo.controller;

import cn.hutool.core.lang.tree.Tree;
import com.github.pagehelper.PageInfo;
import com.wo.domain.Permission;
import com.wo.service.PermissionService;
import com.wo.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("permission")
public class PermissionController {
    @Resource
    private PermissionService permissionService;
    @GetMapping
    public Result<PageInfo<Permission>> findAll(@RequestParam(defaultValue = "1") int pageNum,
                                                @RequestParam(defaultValue = "10") int pageSize){
        return permissionService.listAllPage(pageNum, pageSize);
    }

}
