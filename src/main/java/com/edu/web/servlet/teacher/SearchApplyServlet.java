package com.edu.web.servlet.teacher;

import com.edu.pojo.Apply;
import com.edu.pojo.User;
import com.edu.service.ApplyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchApply")
public class SearchApplyServlet extends HttpServlet {
    private ApplyService applyService = new ApplyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("courseId");
        String uid = request.getParameter("studentId");
        String state = request.getParameter("state");

        User user = (User)request.getSession().getAttribute("user");

        List<Apply> applyList = applyService.selectMultip(cid,uid,state);

        request.getSession().setAttribute("applyList",applyList);

        System.out.println(applyList);

        if(user.getIdentity() == 1){
            response.sendRedirect("studentSearchApply.jsp");
        }else{
            response.sendRedirect("teacherSearchApply.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
