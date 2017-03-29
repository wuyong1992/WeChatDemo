package com.yanmai.wechat.main;

import com.yanmai.wechat.pojo.*;
import com.yanmai.wechat.utils.MessageUtil;
import com.yanmai.wechat.utils.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 菜单管理器
 * 创建、获取、删除菜单
 * Created by admin on 2017/3/29.
 */
public class MenuManager {

    private static Logger log = LoggerFactory.getLogger(MenuManager.class);

    //创建菜单
    private static Menu getMenu() {

        //一级菜单
        ComplexButton complexButton1 = new ComplexButton();
        complexButton1.setName("创意设计");
        ComplexButton complexButton2 = new ComplexButton();
        complexButton2.setName("超级商城");
        ComplexButton complexButton3 = new ComplexButton();
        complexButton3.setName("关于我们");

        //按钮一子菜单
        ClickButton clickButton1_1 = new ClickButton();
        clickButton1_1.setName("新闻资讯");
        clickButton1_1.setType(MessageUtil.BUTTON_TYPE_CLICK);
        clickButton1_1.setKey("key1_1");
        ClickButton clickButton1_2 = new ClickButton();
        clickButton1_2.setName("荣誉殿堂");
        clickButton1_2.setType(MessageUtil.BUTTON_TYPE_CLICK);
        clickButton1_2.setKey("key1_2");
        ClickButton clickButton1_3 = new ClickButton();
        clickButton1_3.setName("创意展示");
        clickButton1_3.setType(MessageUtil.BUTTON_TYPE_CLICK);
        clickButton1_3.setKey("key1_3");

        //按钮二子菜单
        ViewButton viewButton2_1 = new ViewButton();
        viewButton2_1.setName("新品上市");
        viewButton2_1.setType(MessageUtil.BUTTON_TYPE_VIEW);
        viewButton2_1.setUrl("http://mp.weixin.qq.com/bizmall/mallshelf?id=&t=mall/list&biz=MzI2MzU3NDQ4Ng==&shelf_id=5&showwxpaytitle=1#wechat_redirect");
        ViewButton viewButton2_2 = new ViewButton();
        viewButton2_2.setName("超值精选");
        viewButton2_2.setType(MessageUtil.BUTTON_TYPE_VIEW);
        viewButton2_2.setUrl("http://mp.weixin.qq.com/bizmall/mallshelf?id=&t=mall/list&biz=MzI2MzU3NDQ4Ng==&shelf_id=1&showwxpaytitle=1#wechat_redirect");
        ViewButton viewButton2_3 = new ViewButton();
        viewButton2_3.setName("超值精选");
        viewButton2_3.setType(MessageUtil.BUTTON_TYPE_VIEW);
        viewButton2_3.setUrl("http://mp.weixin.qq.com/bizmall/mallshelf?id=&t=mall/list&biz=MzI2MzU3NDQ4Ng==&shelf_id=2&showwxpaytitle=1#wechat_redirect");
        ViewButton viewButton2_4 = new ViewButton();
        viewButton2_4.setName("时尚3C");
        viewButton2_4.setType(MessageUtil.BUTTON_TYPE_VIEW);
        viewButton2_4.setUrl("http://mp.weixin.qq.com/bizmall/mallshelf?id=&t=mall/list&biz=MzI2MzU3NDQ4Ng==&shelf_id=3&showwxpaytitle=1#wechat_redirect");
        ViewButton viewButton2_5 = new ViewButton();
        viewButton2_5.setName("办公舒压");
        viewButton2_5.setType(MessageUtil.BUTTON_TYPE_VIEW);
        viewButton2_5.setUrl("http://mp.weixin.qq.com/bizmall/mallshelf?id=&t=mall/list&biz=MzI2MzU3NDQ4Ng==&shelf_id=4&showwxpaytitle=1#wechat_redirect");

        //按钮三子菜单
        ClickButton clickButton3_1 = new ClickButton();
        clickButton3_1.setName("企业介绍");
        clickButton3_1.setType(MessageUtil.BUTTON_TYPE_CLICK);
        clickButton3_1.setKey("key3_1");
        ViewButton viewButton3_2 = new ViewButton();
        viewButton3_2.setName("企业网站");
        viewButton3_2.setType(MessageUtil.BUTTON_TYPE_VIEW);
        viewButton3_2.setUrl("http://www.chaoxiang99.com/");
        ClickButton clickButton3_3 = new ClickButton();
        clickButton3_3.setName("联系我们");
        clickButton3_3.setKey("key3_3");
        clickButton3_3.setType(MessageUtil.BUTTON_TYPE_CLICK);
        ClickButton clickButton3_4 = new ClickButton();
        clickButton3_4.setName("加盟合作");
        clickButton3_4.setKey("key3_4");
        clickButton3_4.setType(MessageUtil.BUTTON_TYPE_CLICK);

        //子按钮封装
        complexButton1.setSub_button(new ClickButton[]{clickButton1_1, clickButton1_2, clickButton1_3});
        complexButton2.setSub_button(new ViewButton[]{viewButton2_1, viewButton2_2, viewButton2_3, viewButton2_4, viewButton2_5});
        complexButton3.setSub_button(new Button[]{clickButton3_1, viewButton3_2, clickButton3_3, clickButton3_4});

        //封装菜单
        Menu menu = new Menu();
        //menu.setButtons(new Button[]{complexButton1,complexButton2,complexButton3});
        menu.setButton(new Button[]{complexButton1, complexButton2, complexButton3});
        return menu;

    }

    public static void main(String[] args) {
        //调用接口获取access_token
        AccessToken accessToken = WeixinUtil.getAccessToken(MessageUtil.APPID, MessageUtil.APPSECRET);

        if (null != accessToken) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), accessToken.getToken());
            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }

    }
}
