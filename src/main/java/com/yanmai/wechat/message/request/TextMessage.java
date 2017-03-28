package com.yanmai.wechat.message.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 文本消息
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class TextMessage extends BaseMessage {

    private String Content;

}
