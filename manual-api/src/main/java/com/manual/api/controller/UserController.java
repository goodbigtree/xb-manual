package com.manual.api.controller;

import com.manual.api.ApplicationManualApi;
import com.manual.api.dto.user.UserAddDTO;
import com.manual.api.entity.User;
import com.manual.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * desc:
 * author: xuebin3765@163.com
 * date: 2019/09/23
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(ApplicationManualApi.class);

    @Resource
    private UserService userService;

    @RequestMapping("/add")
    public String add(@RequestBody @Valid UserAddDTO userAddDTO){
        logger.debug("step into add user: {}", userAddDTO);
        User user = userService.add(userAddDTO);
        logger.debug("step out add user: ", user);
        return success(user);
    }
}
