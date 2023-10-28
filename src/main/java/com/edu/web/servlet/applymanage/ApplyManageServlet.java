package com.edu.web.servlet.applymanage;

import com.edu.pojo.Apply;
import com.edu.service.ApplyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/applyManage")
public class ApplyManageServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Apply> applyList = new ArrayList<Apply>();
        applyList = applyService.selectAll();

        for(Apply apply : applyList){
            apply.setStatement(apply.getState());
        }

        request.getSession().setAttribute("applyList",applyList);
        response.sendRedirect("applyManage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
