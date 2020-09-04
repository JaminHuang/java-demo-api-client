package com.demo.client.business.impl;

import com.demo.client.business.TestBusiness;
import com.demo.client.business.rabbitmq.RabbitMqBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试模块业务实现类
 *
 * @author jamin
 * @date 2020/9/4
 */
@Component
public class TestBusinessImpl implements TestBusiness {

    @Autowired
    private RabbitMqBusiness rabbitMqBusiness;

    /**
     * 测试RabbitMQ消息
     * @param userId 用户id
     */
    @Override
    public void testRabbitMQ(Integer userId) {
        rabbitMqBusiness.test(userId);
    }
}
