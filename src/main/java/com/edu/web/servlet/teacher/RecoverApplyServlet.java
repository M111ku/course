package com.edu.web.servlet.teacher;

import com.edu.pojo.Apply;
import com.edu.service.ApplyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/recover")
public class RecoverApplyServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        String sid = request.getParameter("sid");
        Apply apply = new Apply();
        apply.setState("1");
        apply.setCourseid(cid);
        apply.setStudentid(sid);
        applyService.updateApply(apply);

        response.sendRedirect("applyRecover");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
