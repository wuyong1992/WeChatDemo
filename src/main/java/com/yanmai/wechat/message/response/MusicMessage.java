package com.yanmai.wechat.message.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 音乐消息
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class MusicMessage extends BaseMessage {
    // 音乐
    private Music Music;
}
