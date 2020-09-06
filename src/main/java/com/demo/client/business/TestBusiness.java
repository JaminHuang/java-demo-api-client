package com.demo.client.business;

import com.demo.client.vo.UserVO;

public interface TestBusiness {

    /**
     * 测试RabbitMQ消息
     * @param userId 用户id
     */
    void testRabbitMQ(Integer userId);

    /**
     * 测试Redis-Save
     * @param userId 用户id
     */
    void testRedisSave(Integer userId);

    /**
     * 测试Redis-Get
     * @param userId 用户id
     */
    UserVO testRedisGet(Integer userId);
}
