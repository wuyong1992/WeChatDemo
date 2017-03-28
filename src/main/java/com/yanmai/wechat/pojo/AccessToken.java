package com.yanmai.wechat.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by wuyong on 2017/3/29.
 */
@Getter@Setter
public class AccessToken {
    // 获取到的凭证
    private String token;
    // 凭证有效时间，单位：秒
    private int expiresIn;
}
