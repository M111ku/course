package com.edu.web.servlet.student;

import com.edu.pojo.Apply;
import com.edu.pojo.User;
import com.edu.service.ApplyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/confirmApply")
public class ConfirmApplyServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String cid = request.getParameter("cid");
        String state = request.getParameter("state");
        User user = (User)request.getSession().getAttribute("user");
        String studentid = user.getUid();
        System.out.println(cid+state);
        //找到对应申请
        Apply apply =  applyService.selectByCidAndSid(cid, user.getUid());
        System.out.println(apply);
        //新建申请，更新状态
        if(apply.getState().equals("5")){
            System.out.println(apply);
            apply.setState("7");
            applyService.updateApply(apply);
        }else if(state.equals("6")){
            apply.setState("8");
            applyService.updateApply(apply);
        }

        response.sendRedirect("checkQuery");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
