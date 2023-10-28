package com.edu.web.servlet.student;

import com.edu.pojo.Apply;
import com.edu.pojo.PageBean;
import com.edu.pojo.User;
import com.edu.service.ApplyService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/checkAllApply")
public class CheckAllApplyServlet extends HttpServlet {
    public ApplyService applyService = new ApplyService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        User user = (User)request.getSession().getAttribute("user");

        //赋初值 初始页为1 容量为5
        if(_currentPage == null){
            _currentPage = "1";
        }
        if(_pageSize == null){
            _pageSize = "5";
        }

        if(_currentPage != null && _currentPage !=""){
            int currentPage = Integer.parseInt(_currentPage);
            int pageSize = Integer.parseInt(_pageSize);
            PageBean<Apply> pageBean = new PageBean<Apply>();
            pageBean = applyService.selectStudentApplyByPage(user.getUid(),currentPage,pageSize);

            for(Apply apply:pageBean.getRows()){
                apply.setStatement(apply.getState());
            }

            request.getSession().setAttribute("applyList",pageBean.getRows());
            request.getSession().setAttribute("totalCount",pageBean.getTotalCount());

            response.sendRedirect("studentAllApply.jsp");
        }else {
            PageBean<Apply> pageBean = new PageBean<Apply>();
            pageBean = applyService.selectTeacherApplyByPage(user.getUid(), 1,2);
            for(Apply apply:pageBean.getRows()){
                apply.setStatement(apply.getState());
            }
            request.getSession().setAttribute("applyList",pageBean.getRows());
            request.getSession().setAttribute("totalCount",pageBean.getTotalCount());

            response.sendRedirect("studentAllApply.jsp");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
