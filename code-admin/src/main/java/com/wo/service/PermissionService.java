package com.wo.service;

import cn.hutool.core.lang.tree.Tree;
import com.github.pagehelper.PageInfo;
import com.wo.domain.Permission;
import com.wo.utils.Result;

import java.util.List;

public interface PermissionService {
    Result<PageInfo<Permission>> listAllPage(int pageNum, int pageSize);
}
