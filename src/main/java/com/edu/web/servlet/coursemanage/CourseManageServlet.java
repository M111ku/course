package com.edu.web.servlet.coursemanage;

import com.edu.pojo.Course;
import com.edu.pojo.PageBean;
import com.edu.pojo.User;
import com.edu.service.CourseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/coursemanage")
public class CourseManageServlet extends HttpServlet {
    public CourseService courseService = new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        if(_currentPage != null && _currentPage !=""){
            int currentPage = Integer.parseInt(_currentPage);
            int pageSize = Integer.parseInt(_pageSize);
            PageBean<Course> pageBean = new PageBean<Course>();
            pageBean = courseService.selectByPage(currentPage,pageSize);

            request.getSession().setAttribute("courseList",pageBean.getRows());
            request.getSession().setAttribute("totalCount",pageBean.getTotalCount());

            response.sendRedirect("coursemanage.jsp");
        }else {
            PageBean<Course> pageBean = new PageBean<Course>();
            pageBean = courseService.selectByPage(1,5);

            request.getSession().setAttribute("courseList",pageBean.getRows());
            request.getSession().setAttribute("totalCount",pageBean.getTotalCount());

            response.sendRedirect("coursemanage.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
