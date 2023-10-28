package com.edu.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest)request;
        if(req.getSession().getAttribute("username") !=null
                || req.getRequestURI().endsWith("login")
                || req.getRequestURI().endsWith("login.html")
        ){
            chain.doFilter(request, response);
        }else{
            HttpServletResponse resp = (HttpServletResponse) response;
            resp.sendRedirect("login.html");
        }
    }
}

