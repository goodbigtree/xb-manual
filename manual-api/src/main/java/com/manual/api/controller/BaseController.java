package com.manual.api.controller;

import com.manual.api.model.RespEntity;

/**
 * desc:
 * author: xuebin3765@163.com
 * date: 2019/09/23
 */
public class BaseController extends BaseLogs {

    public String success(Object object){
        return RespEntity.success(object).toString();
    }

    public String success(){
        return RespEntity.success().toString();
    }

    public String success(Object object, String respCode, String respMsg){
        return RespEntity.success(object).toString();
    }

    public String error(){
        return RespEntity.error().toString();
    }

    public String error(String respMsg){
        return RespEntity.error(respMsg).toString();
    }

    protected String error(String respCode, String respMsg){
        return RespEntity.error(respCode, respMsg).toString();
    }
}
