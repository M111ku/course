package com.edu.web.servlet.process;

import com.edu.pojo.Course;
import com.edu.pojo.Process;
import com.edu.pojo.User;
import com.edu.service.CourseService;
import com.edu.service.ProcessService;
import com.edu.service.UserService;
import org.apache.ibatis.annotations.Param;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/createprocess")
public class CreateSlefServlet extends HttpServlet {
    public UserService userService = new UserService();
    public CourseService courseService = new CourseService();
    public ProcessService processService = new ProcessService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        Course course = courseService.selectByCid(cid);
        request.getSession().setAttribute("course",course);

        //跳转到创建动态审批页面
        response.sendRedirect("createself.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ap = request.getParameter("approvalType");
        Course course = (Course)request.getSession().getAttribute("course");

        if(ap.equals("") || ap == null){
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
        }else {
            Process process = new Process();
            process.setCid(course.getCid());
            if(ap.equals("lecture-only")){//主讲教师审批
                process.setFirst(course.getLecturer());
                process.setSecond("");
                processService.updateProcess(process);
                response.sendRedirect("coursemanage");
            }else if(ap.equals("header-only")){//主管教师审批
                process.setFirst(course.getHeader());
                process.setSecond("");
                processService.updateProcess(process);
                response.sendRedirect("coursemanage");
            }else if(ap.equals("custom")){//自定义审批
                List<User> teacherList = userService.selectTeacher();

                //获取教师列表，选择第一第二审批人
                request.getSession().setAttribute("teacherList",teacherList);
                response.sendRedirect("firstteacher.jsp");
            }
        }
    }
}
