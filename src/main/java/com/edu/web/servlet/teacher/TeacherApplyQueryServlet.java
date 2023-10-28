package com.edu.web.servlet.teacher;

import com.edu.pojo.Apply;
import com.edu.pojo.User;
import com.edu.service.ApplyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacherApplyQuery")
public class TeacherApplyQueryServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");

        //查询教师可以审批的课程，审批权限管理
        List<Apply> applyList = applyService.selectTeacherApply(user.getUid(), user.getUid());

        for(Apply apply : applyList){
            apply.setStatement(apply.getState());
        }
        request.getSession().setAttribute("applyList",applyList);
        response.sendRedirect("teacherApplyList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
