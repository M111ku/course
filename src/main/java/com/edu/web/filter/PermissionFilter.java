package com.edu.web.filter;

import com.edu.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/")
public class PermissionFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse) response;
        User user = (User)req.getSession().getAttribute("user");


        if(req.getRequestURI().endsWith("Manage") || req.getRequestURI().endsWith("manage")
                || req.getRequestURI().endsWith("useradd")
                || req.getRequestURI().endsWith("userdelete")
                || req.getRequestURI().endsWith("courseadd")
                || req.getRequestURI().endsWith("coursedelete")
                || req.getRequestURI().endsWith("coursemanage")){
            if(user.getIdentity() == 4){
                chain.doFilter(request, response);
            }else{
                response.setCharacterEncoding("UTF-8");
                res.sendRedirect("permissionError.html");
            }
        }else if(req.getRequestURI().endsWith("Check")
                ||req.getRequestURI().endsWith("Consent")
                ||req.getRequestURI().endsWith("recover")
                ||req.getRequestURI().endsWith("Reject")
                ||req.getRequestURI().endsWith("Recover")){
            if(user.getIdentity() == 2 ||user.getIdentity() == 3 ){
                chain.doFilter(request, response);
            }else{
                response.setCharacterEncoding("UTF-8");
                res.sendRedirect("permissionError.html");
            }
        }else{
            chain.doFilter(request, response);
        }
    }
}
