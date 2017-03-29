package com.yanmai.wechat.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * CLICK事件按钮
 * Created by wuyong on 2017/3/29.
 */
@Setter@Getter
public class ClickButton extends Button {
    //类型
    private String type;
    //菜单KEY值，用于消息接口推送，不超过128字节
    private String key;
}
