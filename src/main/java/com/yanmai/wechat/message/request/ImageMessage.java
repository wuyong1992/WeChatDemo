package com.yanmai.wechat.message.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片消息
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class ImageMessage extends BaseMessage {

    // 图片链接
    private String PicUrl;
    //图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;

}
