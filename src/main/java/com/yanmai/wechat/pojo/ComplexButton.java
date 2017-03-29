package com.yanmai.wechat.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 组合按钮
 * Created by admin on 2017/3/29.
 */
@Setter@Getter
public class ComplexButton extends Button {
    //二级菜单数组，个数应为1~5个
    private Button[] sub_button;
}
