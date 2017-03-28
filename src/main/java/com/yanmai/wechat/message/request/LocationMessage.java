package com.yanmai.wechat.message.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 地理位置消息
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class LocationMessage extends BaseMessage {

    // 地理位置维度
    private String Location_X;
    // 地理位置经度
    private String Location_Y;
    // 地图缩放大小
    private String Scale;
    // 地理位置信息
    private String Label;

}
