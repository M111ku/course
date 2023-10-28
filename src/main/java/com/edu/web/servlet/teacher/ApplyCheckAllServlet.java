package com.edu.web.servlet.teacher;

import com.edu.pojo.Apply;
import com.edu.pojo.PageBean;
import com.edu.pojo.User;
import com.edu.service.ApplyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/applyCheck")
public class ApplyCheckAllServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        User user = (User)request.getSession().getAttribute("user");

        //赋初值
        if(_currentPage == null){
            _currentPage = "1";
        }
        if(_pageSize == null){
            _pageSize = "2";
        }

        if(_currentPage != null && _currentPage !=""){
            int currentPage = Integer.parseInt(_currentPage);
            int pageSize = Integer.parseInt(_pageSize);
            PageBean<Apply> pageBean = new PageBean<Apply>();
            pageBean = applyService.selectTeacherApplyByPage(user.getUid(),currentPage,pageSize);

            for(Apply apply:pageBean.getRows()){
                apply.setStatement(apply.getState());
            }


            request.getSession().setAttribute("applyList",pageBean.getRows());
            request.getSession().setAttribute("totalCount",pageBean.getTotalCount());

            response.sendRedirect("teacherAllApply.jsp");
        }else {
            PageBean<Apply> pageBean = new PageBean<Apply>();
            pageBean = applyService.selectTeacherApplyByPage(user.getUid(), 1,2);
            for(Apply apply:pageBean.getRows()){
                apply.setStatement(apply.getState());
            }
            request.getSession().setAttribute("applyList",pageBean.getRows());
            request.getSession().setAttribute("totalCount",pageBean.getTotalCount());

            response.sendRedirect("teacherAllApply.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
