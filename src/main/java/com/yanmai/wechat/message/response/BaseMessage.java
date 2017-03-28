package com.yanmai.wechat.message.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 响应消息基类
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class BaseMessage {
    // 接收方帐号（收到的OpenID）
    private String ToUserName;
    // 开发者微信号
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（text/music/news）
    private String MsgType;
    // 位0x0001被标志时，星标刚收到的消息
    private int FuncFlag;

}
