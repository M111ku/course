package com.edu.web.servlet.teacher;

import com.edu.pojo.Apply;
import com.edu.pojo.User;
import com.edu.service.ApplyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/applyRecover")
public class ApplyRecoverListServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        List<Apply> applyList = applyService.selectTeacherApplyStateIsEight(user.getUid(), user.getUid());

        for(Apply apply : applyList){
            apply.setStatement(apply.getState());
        }

        request.getSession().setAttribute("applyList",applyList);
        response.sendRedirect("recoverList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
