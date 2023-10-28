package com.edu.web.servlet.teacher;

import com.edu.pojo.Apply;
import com.edu.pojo.User;
import com.edu.service.ApplyService;
import com.edu.service.CourseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/applyReject")
public class ApplyRejectServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    public CourseService courseService = new CourseService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        String sid = request.getParameter("sid");

        Apply apply = applyService.selectByCidAndSid(cid,sid);

        request.getSession().setAttribute("apply",apply);
        response.sendRedirect("rejectReason.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cid = request.getParameter("courseid");
        String sid = request.getParameter("studentid");
        String rejectReason = request.getParameter("reject");
        User user = (User)request.getSession().getAttribute("user");

        Apply apply = new Apply();
        apply = applyService.selectByCidAndSid(cid,sid);
        apply.setState("6");
        apply.setReject(rejectReason);
        applyService.updateApply(apply);

        response.sendRedirect("teacherApplyQuery");
    }
}
