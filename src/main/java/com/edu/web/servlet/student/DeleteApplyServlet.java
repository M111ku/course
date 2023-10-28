package com.edu.web.servlet.student;

import com.edu.pojo.User;
import com.edu.service.ApplyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteApply")
public class DeleteApplyServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        User user = (User)request.getSession().getAttribute("user");

        applyService.deleteApply(user.getUid(),cid);

        response.sendRedirect("checkQuery");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
