package com.yanmai.wechat.message.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 响应视频消息
 * Created by wuyong on 2017/3/28.
 */
@Setter@Getter
public class VideoMessage extends BaseMessage {

    private Video video;
}
