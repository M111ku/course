package com.edu.web.servlet.coursemanage;

import com.edu.pojo.Course;
import com.edu.pojo.Process;
import com.edu.pojo.User;
import com.edu.service.CourseService;
import com.edu.service.ProcessService;
import com.edu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/courseadd")
public class CourseAddServlet extends HttpServlet {

    public UserService userService = new UserService();
    public CourseService courseService = new CourseService();
    public ProcessService processService = new ProcessService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        request.setCharacterEncoding("UTF-8");
        String cid = request.getParameter("cid");
        String cname = request.getParameter("cname");
        String lecturer = request.getParameter("lecturer");
        String header = request.getParameter("header");

        if(userService.selectByUid(lecturer) != null && userService.selectByUid(header) != null){
            User userLecturer = userService.selectByUid(lecturer);
            User userHeader = userService.selectByUid(header);
        }

        //获取参数不可为空
        if(cid == null ||cid == ""
                ||cname == null ||cname == ""
                ||lecturer == null ||lecturer == ""
                ||header == null ||header == ""
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
        }else if(userService.selectTeacherByUid(lecturer) == null || userService.selectTeacherByUid(header) == null){
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print("<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "    <meta charset=\"UTF-8\">" +
                    "    <title>教师不存在</title>" +
                    "</head>" +
                    "<body>" +
                    "    <h1>教师不存在，请重新输入编号</h1>" +
                    "    <br/>" +
                    "    <a href='javascript:window.history.back()'>点击返回</a>" +
                    "" +
                    "</body>" +
                    "</html>");
        }else if(courseService.selectByCid(cid) != null){
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print("<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "    <meta charset=\"UTF-8\">" +
                    "    <title>冲突</title>" +
                    "</head>" +
                    "<body>" +
                    "    <h1>课程编号已存在,请重新输入</h1>" +
                    "    <br/>" +
                    "    <a href='javascript:window.history.back()'>点击返回</a>" +
                    "" +
                    "</body>" +
                    "</html>");
        }else{
            //新建课程信息
            Course course = new Course();
            course.setCid(cid);
            course.setCname(cname);
            course.setLecturer(lecturer);
            course.setHeader(header);

            //新建课程后审批流默认为主讲教师为第一审批人，主讲教师为第二审批人
            Process process  = new Process();
            process.setCid(cid);
            process.setFirst(lecturer);
            process.setSecond(header);

            //新增课程数据
            //新增流程数据
            courseService.addCourse(course);
            processService.addDefault(process);
            response.sendRedirect("coursemanage");
        }
    }
}
