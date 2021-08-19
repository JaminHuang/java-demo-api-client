package com.demo.client.business.impl;

import com.alibaba.fastjson.JSONObject;
import com.demo.client.business.TestBusiness;
import com.demo.client.consts.MessageRoute;
import com.demo.client.consts.RedisKeyEnum;
import com.demo.client.vo.UserVO;
import com.demo.core.user.common.po.User;
import com.demo.core.user.common.service.UserService;
import com.demo.rpc.annotation.RemoteResource;
import com.demo.sdk.mq.Message;
import com.demo.sdk.mq.MessageProducer;
import com.demo.sdk.util.ModelConvertUtils;
import com.demo.sdk.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 测试模块业务实现类
 *
 * @author jamin
 * @date 2020/9/4
 */
@Service
public class TestBusinessImpl implements TestBusiness {

    @RemoteResource
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 测试RabbitMQ消息
     * @param userId 用户id
     */
    @Override
    public void testRabbitMQ(Integer userId) {
        JSONObject data = new JSONObject();
        data.put("userId", userId);
        Message<JSONObject> message = new Message<>(MessageRoute.TEST_MESSAGE, data);
        MessageProducer.ptp(message);
    }

    /**
     * 测试Redis
     * @param userId 用户id
     */
    @Override
    public void testRedisSave(Integer userId) {
        UserVO vo = new UserVO();
        vo.setId(2);
        vo.setCnName("test");
        vo.setPhone("12345678901");
        redisUtils.setex(String.format(RedisKeyEnum.TEST_CACHE, userId), vo, 1, TimeUnit.MINUTES);
    }

    /**
     * 测试Redis-Get
     * @param userId 用户id
     */
    @Override
    public UserVO testRedisGet(Integer userId) {
        UserVO cache = (UserVO) redisUtils.get(String.format(RedisKeyEnum.TEST_CACHE, userId));
        if (Objects.nonNull(cache)) {
            return cache;
        }

        User user = userService.get(1);
        return ModelConvertUtils.convert(UserVO.class, user);
    }
}
