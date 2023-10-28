package com.edu.web.servlet.student;

import com.edu.pojo.Apply;
import com.edu.pojo.User;
import com.edu.service.ApplyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/checkQuery")
public class CheckQueryServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        List<Apply> applyList1 = new ArrayList<Apply>();
        List<Apply> applyList2 = new ArrayList<Apply>();
        applyList1 = applyService.selectStudentApplyStateIsTwoToFour(user.getUid());
        applyList2 = applyService.selectStudentApplyStateIsFiveToSix(user.getUid());
        for(Apply apply : applyList1){
            apply.setStatement(apply.getState());
        }
        for(Apply apply : applyList2){
            apply.setStatement(apply.getState());
        }
        request.getSession().setAttribute("applyList1",applyList1);
        request.getSession().setAttribute("applyList2",applyList2);
        response.sendRedirect("applyCheck.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
