package com.edu.web.servlet.process;

import com.edu.pojo.User;
import com.edu.service.CourseService;
import com.edu.service.ProcessService;
import com.edu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/secondteacher")
public class SecondTeacherServlet extends HttpServlet {
    public UserService userService = new UserService();
    public CourseService courseService = new CourseService();
    public ProcessService processService = new ProcessService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getSession().getAttribute("uid").toString();
        System.out.println(uid);

        List<User> teacherList = userService.selectTeacher();

        //找到第一审批人并删除
        int i = 0;
        for(User user: teacherList){
            if(user.getUid().equals(uid)){
                break;
            }
            i++;
        }
        teacherList.remove(i);



        //获取教师列表，选择第一第二审批人
        request.getSession().setAttribute("teacherList",teacherList);
        response.sendRedirect("secondteacher.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
