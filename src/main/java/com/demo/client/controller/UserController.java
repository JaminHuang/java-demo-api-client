package com.demo.client.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.client.business.UserBusiness;
import com.demo.client.vo.UserVO;
import com.demo.sdk.annotation.AccessToken;
import com.demo.sdk.controller.BaseController;
import com.demo.sdk.response.Result;
import com.demo.sdk.thread.ReqThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关
 *
 * @author jamin
 * @date 2020/8/11
 */
@RestController
@RequestMapping("user")
@AccessToken
public class UserController extends BaseController {

    @Autowired
    private UserBusiness userBusiness;

    /**
     * 获取用户信息
     */
    @GetMapping("/{id}")
    @AccessToken(required = false)
    public Result<UserVO> get(@PathVariable("id") Integer id) {
        return Result.success(userBusiness.get(id));
    }

    /**
     * 获取用户信息
     */
    @GetMapping("/test")
    public Result<Object> get() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("debug", ReqThreadLocal.getDebug());

        return Result.success(jsonObject);
    }
}
