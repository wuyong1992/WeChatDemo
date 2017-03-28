package com.yanmai.wechat.message.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 语音消息
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class VoiceMessage extends BaseMessage {
    //语音消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;
    //语音格式，如amr，speex等
    private String Format;
}
