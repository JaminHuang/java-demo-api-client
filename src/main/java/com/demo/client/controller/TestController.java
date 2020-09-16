package com.demo.client.controller;

import com.demo.client.business.TestBusiness;
import com.demo.client.vo.UserVO;
import com.demo.sdk.annotation.AccessToken;
import com.demo.sdk.controller.BaseController;
import com.demo.sdk.response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * demo 测试相关
 * @author jamin
 * @date 2020-09-04
 */
@RestController
@RequestMapping("test")
@AccessToken
public class TestController extends BaseController {

    @Autowired
    private TestBusiness testBusiness;

    /**
     * 测试发送rabbitMQ消息
     */
    @GetMapping("/message")
    @AccessToken(required = false)
    public Result<Object> message() {
        testBusiness.testRabbitMQ(1);
        return Result.success();
    }

    /**
     * 测试存储redis-save
     */
    @GetMapping("/redis/save")
    @AccessToken(required = false)
    public Result<Object> redisSave() {
        testBusiness.testRedisSave(2);
        return Result.success();
    }

    /**
     * 测试存储redis-get
     */
    @GetMapping("/redis/get")
    @AccessToken(required = false)
    public Result<UserVO> redisGet() {
        return Result.success(testBusiness.testRedisGet(2));
    }
}
