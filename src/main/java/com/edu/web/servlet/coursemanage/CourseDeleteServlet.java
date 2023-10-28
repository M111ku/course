package com.edu.web.servlet.coursemanage;

import com.edu.service.CourseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/coursedelete")
public class CourseDeleteServlet extends HttpServlet {
    public CourseService courseService = new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        courseService.deleteCourse(cid);
        response.sendRedirect("coursemanage");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
