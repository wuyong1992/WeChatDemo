package com.yanmai.wechat.message.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 图文消息
 * Created by wuyong on 2017/3/28.
 */
@Getter@Setter
public class NewsMessage {

    // 图文消息个数，限制为10条以内
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    private List<Article> Articles;
}
