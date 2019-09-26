package com.manual.api.dto.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author guodandan
 * @Date 2019/9/24 23:25
 */
@Data
public class UserAddDTO extends UserDTO{

    @NotNull(message = "确认密码不能为空")
    private String repPassword;
    private String address;
}
