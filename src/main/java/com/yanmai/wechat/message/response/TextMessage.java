package com.yanmai.wechat.message.response;


import lombok.Getter;
import lombok.Setter;

/**
 * 文本消息
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class TextMessage extends BaseMessage {

    // 回复的消息内容
    private String Content;
}
