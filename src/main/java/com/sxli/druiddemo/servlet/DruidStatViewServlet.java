package com.sxli.druiddemo.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/druid/*")
public class DruidStatViewServlet extends StatViewServlet {

    /**
     * 重写初始化方法并且定义监控界面登录密码
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.username = "sxli";
        super.password = "sxli";
        super.init();
    }
}
