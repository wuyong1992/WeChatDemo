package com.yanmai.wechat.servlet;

import com.yanmai.wechat.service.CoreService;
import com.yanmai.wechat.utils.SignUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 核心Servlet
 * Created by wuyong on 2017/3/28.
 */
public class CoreServlet extends HttpServlet {

    /**
     * 确认请求来自微信服务器
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
        out = null;     //便于垃圾回收
    }

    /**
     * 处理微信服务器发来的消息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respMessage = CoreService.processRequest(request);

        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();

    }
}
