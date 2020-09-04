package com.demo.client.business.rabbitmq.impl;

import com.alibaba.fastjson.JSONObject;
import com.demo.client.business.rabbitmq.RabbitMqBusiness;
import com.demo.client.consts.MessageRoute;
import com.demo.sdk.mq.Message;
import com.demo.sdk.mq.MessageProducer;

/**
 * RabbitMQ消息中心
 *
 * @author jamin
 * @date 2020/9/4
 */
public class RabbitMqBusinessImpl implements RabbitMqBusiness {

    /**
     * 测试Mq
     * @param userId 学生id
     */
    public void test(Integer userId) {
        JSONObject data = new JSONObject();
        data.put("userId", userId);
        Message<JSONObject> message = new Message<>(MessageRoute.TEST_MESSAGE, data);
        MessageProducer.ptp(message);
    }
}
