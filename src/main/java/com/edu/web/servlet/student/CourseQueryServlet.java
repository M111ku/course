package com.edu.web.servlet.student;

import com.edu.mapper.TakesMapper;
import com.edu.pojo.Course;
import com.edu.pojo.Takes;
import com.edu.pojo.User;
import com.edu.service.ApplyService;
import com.edu.service.CourseService;
import com.edu.service.TakesService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/courseQuery")
public class CourseQueryServlet extends HttpServlet {
    public TakesService takesService = new TakesService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        List<Takes> userList = takesService.selectApplyCourse(user.getUid());
        request.getSession().setAttribute("courseList",userList);
        response.sendRedirect("studentcourse.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
