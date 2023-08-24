package com.wo.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName permission
 */
@Data
public class Permission implements Serializable {
    public interface Update {}
    public interface Insert {}
    /**
     * 权限id
     */
    private Integer permissionId;

    /**
     * 所属上级id
     */
    private Integer parentId;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 类型
     */
    private String type;

    /**
     * 权限值
     */
    private String permissionValue;

    /**
     * 访问路径
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 图标
     */
    private String icon;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}