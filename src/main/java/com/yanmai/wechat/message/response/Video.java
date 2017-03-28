package com.yanmai.wechat.message.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 视频类
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class Video {
    //通过素材管理接口上传多媒体文件，得到的id
    private String MediaId;
    //视频消息的标题
    private String Title;
    //视频消息的描述
    private String Description;


}
