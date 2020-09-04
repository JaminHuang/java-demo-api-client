package com.demo.client.consts;

public enum MessageRoute implements com.demo.sdk.mq.MessageRoute {

    /** 本模块 **/
    TEST_MESSAGE("demo-client", "test_message", "测试消息");

    private String topic, tag, describe;

    MessageRoute(String topic, String tag, String describe) {
        this.topic = topic;
        this.tag = tag;
        this.describe = describe;
    }

    @Override
    public String topic() {
        return topic;
    }

    @Override
    public String tag() {
        return tag;
    }

    @Override
    public String describe() {
        return describe;
    }
}
