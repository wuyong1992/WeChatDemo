package com.yanmai.wechat.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * VIEW类型按钮
 * Created by admin on 2017/3/29.
 */
@Getter@Setter
public class ViewButton extends Button {

    //菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
    private String type;
    //网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url
    private String url;
}
