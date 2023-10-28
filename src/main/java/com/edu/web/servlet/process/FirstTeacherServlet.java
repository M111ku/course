package com.edu.web.servlet.process;

import com.edu.pojo.Course;
import com.edu.pojo.Process;
import com.edu.service.CourseService;
import com.edu.service.ProcessService;
import com.edu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/firstteacher")
public class FirstTeacherServlet extends HttpServlet {
    public UserService userService = new UserService();
    public CourseService courseService = new CourseService();
    public ProcessService processService = new ProcessService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = request.getParameter("uid");

        Course course = (Course)request.getSession().getAttribute("course");

        //把该教师的信息存入session不能在第二审批人中出现
        request.getSession().setAttribute("uid",uid);

        //更新审批流的第一审批人和第二审批人
        Process process = new Process();
        process.setCid(course.getCid());
        process.setFirst(uid);
        process.setSecond(null);

        processService.updateProcess(process);

        response.sendRedirect("secondteacher");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
