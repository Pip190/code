package com.wo.domain;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@Data
public class User implements Serializable {
    public interface Update {}
    public interface Insert {}
    /**
     * 主键id
     */
    @Null(groups = {Insert.class})
    @NotNull(groups = Update.class)
    private Integer userId;

    /**
     * 用户名
     */
    @NotBlank
    private String username;

    /**
     * 密码
     */
    @NotNull
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 邮箱
     */
    @Email
    private String email;

    private static final long serialVersionUID = 1L;
}