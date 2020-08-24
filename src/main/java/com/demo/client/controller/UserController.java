package com.demo.client.controller;

import com.demo.sdk.annotation.AccessToken;
import com.demo.sdk.controller.BaseController;
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



}
