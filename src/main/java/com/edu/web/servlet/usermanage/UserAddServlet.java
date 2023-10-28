package com.edu.web.servlet.usermanage;

import com.edu.pojo.User;
import com.edu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/useradd")
public class UserAddServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        request.setCharacterEncoding("UTF-8");
        String uid = request.getParameter("uid");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ide = request.getParameter("identity");
        String name = request.getParameter("name");

        //获取参数不可为空
        if(uid == null ||uid == ""
                ||username == null ||username == ""
                ||password == null ||password == ""
                ||ide == null ||ide == ""
                ||name == null ||name == ""
        ){
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print("<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "    <meta charset=\"UTF-8\">" +
                    "    <title>填写内容不可为空</title>" +
                    "</head>" +
                    "<body>" +
                    "    <h1>填写内容不可为空</h1>" +
                    "    <br/>" +
                    "    <a href='javascript:window.history.back()'>点击返回</a>" +
                    "" +
                    "</body>" +
                    "</html>");
        }else{
            int identity = Integer.parseInt(ide);

            User userSelectByUsername = userService.selectByUsername(username);
            User userSelectByUid = userService.selectByUid(uid);

            //如果用户名或学工号已存在则不可新增
            if(userSelectByUsername == null && userSelectByUid == null){
                //赋值
                User user = new User();
                user.setUid(uid);
                user.setUsername(username);
                user.setPassword(password);
                user.setName(name);
                user.setIdentity(identity);

                userService.addUser(user);

                response.sendRedirect("usermanage");

            }else {
                                response.setCharacterEncoding("UTF-8");
                response.getWriter().print("<!DOCTYPE html>" +
                        "<html lang=\"en\">" +
                        "<head>" +
                        "    <meta charset=\"UTF-8\">" +
                        "    <title>填写内容冲突</title>" +
                        "</head>" +
                        "<body>" +
                        "    <h1>学工号或用户名重复，请更换</h1>" +
                        "    <br/>" +
                        "    <a href='javascript:window.history.back()'>点击返回</a>" +
                        "" +
                        "</body>" +
                        "</html>");
            }
        }


    }
}
