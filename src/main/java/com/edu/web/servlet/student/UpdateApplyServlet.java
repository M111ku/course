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

@WebServlet("/updateApply")
@MultipartConfig
public class UpdateApplyServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    public CourseService courseService = new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        User user = (User)request.getSession().getAttribute("user");
        Course course = courseService.selectByCid(cid);
        request.getSession().setAttribute("course",course);
        System.out.println("即将进入更新界面");
        response.sendRedirect("applyUpdate.jsp");
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

        applyService.updateApply(apply);

        response.sendRedirect("checkQuery");
    }
}
