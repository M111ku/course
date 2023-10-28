package com.edu.web.servlet.process;

import com.edu.pojo.Course;
import com.edu.pojo.Process;
import com.edu.service.CourseService;
import com.edu.service.ProcessService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/createdefault")
public class CreateDefaultServlet extends HttpServlet {
    public CourseService courseService = new CourseService();
    public ProcessService processService = new ProcessService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        Course course  = courseService.selectByCid(cid);
        Process process = new Process();
        process.setCid(cid);
        process.setFirst(course.getLecturer());
        process.setSecond(course.getHeader());


        //更新审批流为默认审批流
        //System.out.println(process);
        processService.updateProcess(process);

        response.sendRedirect("coursemanage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
