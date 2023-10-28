package com.edu.web.servlet.teacher;

import com.edu.pojo.Apply;
import com.edu.pojo.Process;
import com.edu.pojo.User;
import com.edu.service.ApplyService;
import com.edu.service.CourseService;
import com.edu.service.ProcessService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/applyConsent")
public class ApplyConsentServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    public CourseService courseService = new CourseService();
    public ProcessService processService = new ProcessService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        String sid = request.getParameter("sid");
        User user = (User)request.getSession().getAttribute("user");

        Apply apply = new Apply();
        apply = applyService.selectByCidAndSid(cid,sid);

        //获取流程，第一二审批人
        Process process = processService.selectByCid(cid);

        if(process.getFirst().equals(user.getUid())
                && process.getSecond().equals("")){
            //用户为第一审批人 且 没有第二审批人
            apply.setState("5");
            applyService.updateApply(apply);
        }else
        if(process.getSecond().equals(user.getUid())){
            //用户是第二审批人
            apply.setState("5");
            applyService.updateApply(apply);
        }else
        if(process.getFirst().equals(user.getUid())
                &&process.getSecond() != ""){
            //用户是第一审批人 且 有第二审批人
            apply.setState("3");
            applyService.updateApply(apply);
        }
        response.sendRedirect("teacherApplyQuery");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
