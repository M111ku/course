package com.edu.web.servlet;

import com.edu.pojo.User;
import com.edu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //调用service层
        User user =  userService.selectByUsername(username);


        //用户名以及密码都不能为空，不然会报空指针错误
        if(!username.equals("")
                && !password.equals("")
                && password.equals(user.getPassword())
                && user!=null){

            //session中存入数据
            request.getSession().setAttribute("username",username);//用户名
            request.getSession().setAttribute("identity",user.getIdentity());//身份int
            request.getSession().setAttribute("user",user);

            if(user.getIdentity() == 1){
                //学生进入课程列表界面
                response.sendRedirect("studenthome.jsp");//跳转到课程列表CourseQueryServlet
            }else if(user.getIdentity() == 2){
                //跳转到主讲教师申请审批列表
                response.sendRedirect("lecturerhome.jsp");
            }else if(user.getIdentity() == 3){
                //跳转到主管教师申请审批列表
                response.sendRedirect("lecturerhome.jsp");
            }else if(user.getIdentity() == 4){
                //跳转到管理员界面
                response.sendRedirect("adminhome.jsp");
            }
        }else{
            response.sendRedirect("login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
