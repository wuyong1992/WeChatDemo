package com.yanmai.wechat.message.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 消息的基类
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class BaseMessage {
    // 开发者微信号
    private String ToUserName;
    // 发送方帐号（一个OpenID）
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（text/image/voice/video/shortvideo/location/link）
    private String MsgType;
    // 消息id，64位整型
    private long MsgId;
}
