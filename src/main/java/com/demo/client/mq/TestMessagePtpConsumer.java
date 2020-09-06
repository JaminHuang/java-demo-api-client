package com.demo.client.mq;

import com.alibaba.fastjson.JSONObject;
import com.demo.sdk.mq.ConsumeStatus;
import com.demo.sdk.mq.Message;
import com.demo.sdk.mq.MessageRoute;
import com.demo.sdk.mq.PtpConsumer;
import com.demo.sdk.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 测试RabbitMQ消息
 *
 * @author jamin
 * @date 2020/9/4
 */
//@Service
public class TestMessagePtpConsumer extends PtpConsumer<JSONObject> {

    private static final Logger logger = LoggerFactory.getLogger(TestMessagePtpConsumer.class);

    @Override
    protected MessageRoute subscribe() {
        return com.demo.client.consts.MessageRoute.TEST_MESSAGE;
    }

    @Override
    protected ConsumeStatus consume(Message<JSONObject> message, JSONObject data) {
        logger.info("测试消息, [data] = {}", data);

        if (data.isEmpty()) {
            return ConsumeStatus.SUCCESS;
        }

        Integer userId = data.getInteger("userId");

        try {
            System.out.println("测试消息, 消费者消费成功……");
        }
        catch (Exception ex) {
            logger.error("测试消息, 消费异常, 参数[data] = {}, [message] = {}", data, ExceptionUtils.getExceptionMsg(ex));
        }


        return ConsumeStatus.SUCCESS;
    }
}
