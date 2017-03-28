package com.yanmai.wechat.message.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 音乐类
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class Music {
    // 音乐名称
    private String Title;
    // 音乐描述
    private String Description;
    // 音乐链接
    private String MusicUrl;
    // 高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String HQMusicUrl;
    //缩略图的媒体id，通过素材管理接口上传多媒体文件，得到的id
    private String ThumbMediaId;
}
