package com.yanmai.wechat.message.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 视频消息
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class VideoMessage extends BaseMessage {

    //视频消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;
    //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    private String ThumbMediaId;
}
