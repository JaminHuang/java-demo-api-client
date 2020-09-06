package com.demo.client.consts;

public class RedisKeyEnum {

    /**
     * 划分'业务资源缓存'和'业务操作缓存'
     * 注意归类划分，对应归类写在相应归类分隔下
     */

    private static final String REDIS_KEY_PREFIX = "demo-client:";

    /*----------------------基础数据缓存KEY----------------------*/


    /*----------------------业务资源缓存KEY----------------------*/

    public final static String TEST_CACHE = REDIS_KEY_PREFIX + "test:%s";

}
