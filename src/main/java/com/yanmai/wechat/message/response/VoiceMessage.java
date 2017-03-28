package com.yanmai.wechat.message.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by wuyong on 2017/3/28.
 */
@Setter@Getter
public class VoiceMessage extends BaseMessage {
    //通过素材管理接口上传多媒体文件，得到的id
    private String MediaId;
}
