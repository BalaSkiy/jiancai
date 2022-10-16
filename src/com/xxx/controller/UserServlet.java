package com.xxx.controller;


import com.xxx.entity.vo.MessageModel;
import com.xxx.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {

    //实例化UserService对象
    private UserService userService=new UserService();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收用户端的请求（接收参数 姓名和密码）
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        //调用service层的方法，返回消息模型对象
        MessageModel messageModel= userService.userLogin(uname,upwd);
        //判断消息模型的状态码
        if (messageModel.getCode()==1){//成功
            //将消息模型中的用户信息设置到session作用域中，重定向跳转到index.jsp
            request.getSession().setAttribute("user",messageModel.getObject());
            response.sendRedirect("index.jsp");
        }else {//失败
            //将消息模型对象设置到session作用域中，请求转发跳转到login.jsp
            request.setAttribute("messageModel",messageModel);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}

