package com.demo.client.business.impl;

import com.demo.client.business.UserBusiness;
import com.demo.client.vo.UserVO;
import com.demo.core.user.common.po.User;
import com.demo.core.user.common.service.UserService;
import com.demo.rpc.annotation.RemoteResource;
import com.demo.sdk.exception.BizException;
import com.demo.sdk.util.ModelConvertUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 用户相关业务
 *
 * @author jamin
 * @date 2020/8/11
 */
@Service
public class UserBusinessImpl implements UserBusiness {

    @RemoteResource
    private UserService userService;

    /**
     * 获取用户信息
     * @param userId 用户id
     */
    public UserVO get(Integer userId) {
        User user = userService.get(userId);
        Optional.ofNullable(user).orElseThrow(() -> new BizException("用户不存在"));

        return ModelConvertUtils.convert(UserVO.class, user);
    }
}
