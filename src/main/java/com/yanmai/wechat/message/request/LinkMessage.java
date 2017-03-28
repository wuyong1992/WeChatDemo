package com.yanmai.wechat.message.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 链接消息
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class LinkMessage extends BaseMessage {
    // 消息标题
    private String Title;
    // 消息描述
    private String Description;
    // 消息链接
    private String Url;

}
