package com.edu.web.servlet.student;

import com.edu.pojo.Apply;
import com.edu.pojo.Course;
import com.edu.pojo.User;
import com.edu.service.ApplyService;
import com.edu.service.CourseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

@WebServlet("/courseapply")
@MultipartConfig
public class CourseApplyServlet extends HttpServlet {
    public CourseService courseService = new CourseService();
    public ApplyService applyService = new ApplyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("courseid");
        User user = (User)request.getSession().getAttribute("user");

        Apply apply = applyService.selectByCidAndSid(cid,user.getUid());

        if(apply != null){
            if(apply.getState().equals("2")
                    ||apply.getState().equals("3")
                    ||apply.getState().equals("4")
                    ||apply.getState().equals("5")
                    ||apply.getState().equals("6")
                    ||apply.getState().equals("7")
                    ||apply.getState().equals("8")){
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print("<!DOCTYPE html>" +
                        "<html lang=\"en\">" +
                        "<head>" +
                        "    <meta charset=\"UTF-8\">" +
                        "    <title>申请冲突</title>" +
                        "</head>" +
                        "<body>" +
                        "    <h1>课程已申请</h1>" +
                        "    <br/>" +
                        "    <a href='javascript:window.history.back()'>点击返回</a>" +
                        "" +
                        "</body>" +
                        "</html>");
            }
            else if(apply.getState().equals("1")){
                Course course = courseService.selectByCid(cid);
                request.getSession().setAttribute("course",course);
                response.sendRedirect("applyinfo.jsp");
            }
        }
        else if(apply == null){
            Course course = courseService.selectByCid(cid);
            request.getSession().setAttribute("course",course);
            response.sendRedirect("applyinfo.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String courseid = request.getParameter("courseid");
        String cname = request.getParameter("coursename");
        String reason = request.getParameter("reason");
        User user = (User)request.getSession().getAttribute("user");

        //取文件操作
        String path= new String();
        Collection<Part> parts = request.getParts();
        for(Part part:parts){
            String fileName = part.getSubmittedFileName();
            if(fileName!=null && !fileName.equals("")){
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                path =  UUID.randomUUID().toString()+suffix;
                part.write("e://uploadfiles//" +path);
            }
        }

        //新建申请，更新数据库
        Apply apply = new Apply();
        apply.setCourseid(courseid);
        apply.setReason(reason);
        apply.setStudentid(user.getUid());
        apply.setState("2");
        apply.setProve(path);

        //如果找到了申请，已经存在，说明等待重新提交
        Apply app = applyService.selectByCidAndSid(courseid,user.getUid());
        if(app!=null){
            applyService.updateApply(apply);
            response.sendRedirect("courseQuery");
        }else if(app == null){
            applyService.addApply(apply);
            response.sendRedirect("courseQuery");
        }
    }
}
