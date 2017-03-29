package com.yanmai.wechat.thread;

import com.yanmai.wechat.pojo.AccessToken;
import com.yanmai.wechat.utils.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * 利用线程死循环持久化access_token
 * Created by admin on 2017/3/29.
 */
public class TokenThread implements Runnable {
    private static Logger log = LoggerFactory.getLogger(TokenThread.class);
    // 第三方用户唯一凭证
    public static String appid = "";
    // 第三方用户唯一凭证密钥
    public static String appsecret = "";
    public static AccessToken accessToken = null;

    public void run() {
        while (true) {
            try {
                accessToken = WeixinUtil.getAccessToken(appid, appsecret);
                if (null != accessToken) {
                    log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresIn(), accessToken.getToken());
                    // 休眠7000秒,access_token有效期为7200秒
                    Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
                } else {
                    // 如果access_token为null，60秒后再获取
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    log.error("{}", e1);
                }
                log.error("{}", e);
            }
        }
    }
}
