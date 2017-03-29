package com.yanmai.wechat.servlet;

import com.yanmai.wechat.thread.TokenThread;
import com.yanmai.wechat.utils.MessageUtil;
import com.yanmai.wechat.utils.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *初始化加载servlet，获取access_token
 * Created by admin on 2017/3/29.
 */
public class InitServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);

    public void init() throws ServletException {
        // 获取web.xml中配置的参数
        TokenThread.appid = MessageUtil.APPID;
        TokenThread.appsecret = MessageUtil.APPSECRET;

        log.info("weixin api appid:{}", TokenThread.appid);
        log.info("weixin api appsecret:{}", TokenThread.appsecret);

        // 未配置appid、appsecret时给出提示
        if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {
            log.error("appid and appsecret configuration error, please check carefully.");
        } else {
            // 启动定时获取access_token的线程
            new Thread(new TokenThread()).start();
        }
    }
}
