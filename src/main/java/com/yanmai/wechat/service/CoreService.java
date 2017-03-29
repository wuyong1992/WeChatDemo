package com.yanmai.wechat.service;

import com.yanmai.wechat.message.response.Article;
import com.yanmai.wechat.message.response.NewsMessage;
import com.yanmai.wechat.message.response.TextMessage;
import com.yanmai.wechat.utils.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 核心服务类
 * Created by wuyong on 2017/3/28.
 */

public class CoreService {
    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return
     */
    public static String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            // 默认返回的文本消息内容
            String respContent = "请求处理异常，请稍候尝试！";

            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(request);

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");


            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);

            // 创建图文消息
            NewsMessage newsMessage = new NewsMessage();
            newsMessage.setToUserName(fromUserName);
            newsMessage.setFromUserName(toUserName);
            newsMessage.setCreateTime(new Date().getTime());
            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
            newsMessage.setFuncFlag(0);

            List<Article> articleList = new ArrayList<Article>();


            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                respContent = "您发送的是文本消息！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
            // 音频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是音频消息！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
            // 视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "您发送的是视频消息！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
            // 小视频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
                respContent = "您发送的是小视频消息！";
                textMessage.setContent(respContent);
                respMessage = MessageUtil.textMessageToXml(textMessage);
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "你好，"+fromUserName+"！这是一个测试号...";
                    textMessage.setContent(respContent);
                    respMessage = MessageUtil.textMessageToXml(textMessage);
                }
                // 取消订阅
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                }
                // 自定义菜单点击事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    String eventKey = requestMap.get("EventKey");

                    if ("key1_1".equals(eventKey)){
                        Article article1 = new Article();
                        article1.setPicUrl("http://yanmai.wechat.com.ngrok.cc/images/key1_1.png");
                        article1.setDescription("CDPiazz圆山MAJI门店贴心小物-可爱手作印章");
                        article1.setUrl("https://mp.weixin.qq.com/s?__biz=MzI2MzU3NDQ4Ng==&tempkey=g7AmId1Nr6mBGfhLw9AjrJv7EuB8yp%2F9NzKoBvAkCigTg4fDO6cku9h%2FB4%2BY1gveKYo25JS4wCG9Xf3WXY3Teo5CRtm0HRcCLSpwe4yR2OAAZia8ONs4cqNJdeniStNz%2BlaTR6euRl0xGeyyVqNphA%3D%3D&chksm=6ab887815dcf0e9721f1ce67f9bab2a8ed36a565026d12e0a66af8b9da8046b13f44c93f7fb3#rd");
                        article1.setTitle("圆山MAJI门店");

                        Article article2 = new Article();
                        article2.setPicUrl("http://yanmai.wechat.com.ngrok.cc/images/key1_1_2.png");
                        article2.setUrl("https://mp.weixin.qq.com/s?__biz=MzI2MzU3NDQ4Ng==&tempkey=g7AmId1Nr6mBGfhLw9AjrJv7EuB8yp%2F9NzKoBvAkCiiHDHKvOQZqN8J%2FkJsig%2BBIG2jlXw2FrwAsucPUlE9VJMkCogCLt%2B%2Fx3%2FVhkHk4ec4AZia8ONs4cqNJdeniStNzIqBlD%2BN%2BIHKnGDOYFOEPdA%3D%3D&chksm=6ab887815dcf0e97ef3ff123154f245ea0439a2a236b20f584dc5885c3fedc8c64712589795e##");
                        article2.setDescription("CDPiazza华山旗舰店【橱窗展-插画家FiFi】");
                        article2.setTitle("CDPiazza华山旗舰店");

                        //封装图文
                        articleList.add(article1);
                        articleList.add(article2);
                        newsMessage.setArticleCount(articleList.size());
                        newsMessage.setArticles(articleList);
                        //封装响应消息
                        respMessage = MessageUtil.newsMessageToXml(newsMessage);

                    }else if ("key1_2".equals(eventKey)){
                        Article article = new Article();
                        article.setPicUrl("http://yanmai.wechat.com.ngrok.cc/images/key1_2.png");
                        article.setDescription("设计的灵魂不断的绽放");
                        article.setUrl("https://mp.weixin.qq.com/s?__biz=MzI2MzU3NDQ4Ng==&tempkey=g7AmId1Nr6mBGfhLw9AjrJv7EuB8yp%2F9NzKoBvAkCihfQiOCvBcf2DKixBUIJIxJ%2BzDZTNixqg1xzhCkhsL2JnJl25F%2BK1cnf%2BxrFWx6qR4AZia8ONs4cqNJdeniStNzpy8l%2B04evlXDWHyjH8wSrg%3D%3D&chksm=6ab887fb5dcf0eedb3ba38df3910de2709d3b08627c168f67d2c185a8948491c885c4adb11c4#rd");
                        article.setTitle("CDPiazza荣誉展示");

                        articleList.add(article);
                        newsMessage.setArticleCount(articleList.size());
                        newsMessage.setArticles(articleList);
                        respMessage = MessageUtil.newsMessageToXml(newsMessage);

                    }else if ("key1_3".equals(eventKey)){
                        Article article1 = new Article();
                        article1.setPicUrl("http://yanmai.wechat.com.ngrok.cc/images/key1_3_1.png");
                        article1.setDescription("创意家纺");
                        article1.setUrl("https://mp.weixin.qq.com/s?__biz=MzI2MzU3NDQ4Ng==&tempkey=g7AmId1Nr6mBGfhLw9AjrJv7EuB8yp%2F9NzKoBvAkCih7FheJJVdB4tf5AYQIgF4zdj7x0mxDT5IDjVZtucjSrColGZjriW6%2BAkUS1npKcFcAZia8ONs4cqNJdeniStNz73sKAMdBtff0oArKDibk7A%3D%3D&chksm=6ab887f05dcf0ee688c5d0454fa1d036bbaf6ec968f5d049acfec73f5b7fb8a83813d134a034#rd");
                        article1.setTitle("创意家纺");

                        Article article2 = new Article();
                        article2.setPicUrl("http://yanmai.wechat.com.ngrok.cc/images/key1_3_2.png");
                        article2.setUrl("https://mp.weixin.qq.com/s?__biz=MzI2MzU3NDQ4Ng==&tempkey=g7AmId1Nr6mBGfhLw9AjrJv7EuB8yp%2F9NzKoBvAkCig3fBwG0O722w80yHDRzqENEvSkyS4Mm52h6%2FyCw3iwL342QLnJ9xWX2FcZ8hFHmtAAZia8ONs4cqNJdeniStNz43uAvKRaAE05jyCp3Aapqw%3D%3D&chksm=6ab887f05dcf0ee6df3bf2b84df32e08e33b22595d6505acc61fc1f7fb436886937be7e9560f#rd");
                        article2.setDescription("使用物品");
                        article2.setTitle("使用物品");

                        Article article3 = new Article();
                        article3.setPicUrl("http://yanmai.wechat.com.ngrok.cc/images/key1_3_3.png");
                        article3.setUrl("https://mp.weixin.qq.com/s?__biz=MzI2MzU3NDQ4Ng==&tempkey=g7AmId1Nr6mBGfhLw9AjrJv7EuB8yp%2F9NzKoBvAkCigkPLitX362%2BPUTuLOyBobzWa%2FiL1sCTRHyIcHnIwzU%2Ff8z%2BBojpGDJyG4oU6%2F6NZkAZia8ONs4cqNJdeniStNz9ZezLhM52dChUyBb%2BewkFg%3D%3D&chksm=6ab887f05dcf0ee66485a6164b5f64783d2ef9454e1ef92d0412c832536c7806cd7795097011#rd");
                        article3.setDescription("时尚小件");
                        article3.setTitle("时尚小件");

                        Article article4 = new Article();
                        article4.setPicUrl("http://yanmai.wechat.com.ngrok.cc/images/key1_3_4.png");
                        article4.setUrl("https://mp.weixin.qq.com/s?__biz=MzI2MzU3NDQ4Ng==&tempkey=g7AmId1Nr6mBGfhLw9AjrJv7EuB8yp%2F9NzKoBvAkCijL6t0Zfk9UJ5uAdE9Kz8foddc99wAXgkmP3skwqwwTXtzfFMkWRlWkBqQsRbgLipkAZia8ONs4cqNJdeniStNzv2Btb4k5485cUGysHGosIg%3D%3D&chksm=6ab887f05dcf0ee6b512d22710d9cfd930099b8bf30c58b439fae8459d68e780ed6b554d7e50#rd");
                        article4.setDescription("香精蜡烛");
                        article4.setTitle("香精蜡烛");

                        articleList.add(article1);
                        articleList.add(article2);
                        articleList.add(article3);
                        articleList.add(article4);
                        newsMessage.setArticleCount(articleList.size());
                        newsMessage.setArticles(articleList);
                        respMessage = MessageUtil.newsMessageToXml(newsMessage);

                    }else if ("key3_1".equals(eventKey)){
                        Article article = new Article();
                        article.setPicUrl("http://yanmai.wechat.com.ngrok.cc/images/key3_1.png");
                        article.setDescription("欢迎来到威泰创意");
                        article.setUrl("https://mp.weixin.qq.com/s?__biz=MzI2MzU3NDQ4Ng==&tempkey=g7AmId1Nr6mBGfhLw9AjrJv7EuB8yp%2F9NzKoBvAkCihxQm9F01i5M6b2AEU3pciH7FrJXxhF5HbLUBnzWMZHNuurMRHlMnkA%2BE93Fv8CozIAZia8ONs4cqNJdeniStNzCzWZ56XtO%2BDBGIf6FSL0qA%3D%3D&chksm=6ab887a75dcf0eb17ebeb1ac8aa654e9841969eb34844f571f2937c08ead9e2b5e13a1f1ec10#rd");
                        article.setTitle("威泰创意");

                        articleList.add(article);
                        newsMessage.setArticleCount(articleList.size());
                        newsMessage.setArticles(articleList);
                        respMessage = MessageUtil.newsMessageToXml(newsMessage);

                    }else if ("key3_3".equals(eventKey)){
                        respContent = "0553-5802580";
                        textMessage.setContent(respContent);
                        respMessage = MessageUtil.textMessageToXml(textMessage);

                    }else if ("key3_4".equals(eventKey)){
                        Article article = new Article();
                        article.setPicUrl("http://yanmai.wechat.com.ngrok.cc/images/key3_4.png");
                        article.setDescription("威泰创意成立于2006年，志在结合台湾特有精致文化与现代化时尚流行的元素，精选生活美学的精致商品，呈现给国内外人士属于台湾敦厚且爽快、朴实又新潮的原创味道。");
                        article.setUrl("https://mp.weixin.qq.com/s?__biz=MzI2MzU3NDQ4Ng==&tempkey=g7AmId1Nr6mBGfhLw9AjrJv7EuB8yp%2F9NzKoBvAkCij6NNfAirP2cxtLmYbfBGzg4RcFUj5D0IAnYYh9UfwxtdHT2N4xG7Gx9RINhRqBNQ0AZia8ONs4cqNJdeniStNzx853ToW9fVUAM%2FzzkGljGg%3D%3D&chksm=6ab887975dcf0e81148e4e0f252d52e43964e4f3bdf8f7fcb5a7afc1f958251e5eaefd70f189#rd");
                        article.setTitle("欢迎加盟威泰创意");

                        articleList.add(article);
                        newsMessage.setArticleCount(articleList.size());
                        newsMessage.setArticles(articleList);
                        respMessage = MessageUtil.newsMessageToXml(newsMessage);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return respMessage;
    }
}
