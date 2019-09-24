package com.manual.api.dto.user;

import javax.validation.constraints.NotNull;

/**
 * @Author guodandan
 * @Date 2019/9/24 23:35
 */
public class UserDTO {
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
