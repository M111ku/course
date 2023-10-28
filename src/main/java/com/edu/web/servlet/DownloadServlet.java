package com.edu.web.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename").toString();
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));
        FileInputStream fileInputStream = new FileInputStream("e://uploadfiles//" + filename);
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        while(fileInputStream.read(buffer)>0){
            outputStream.write(buffer);
        }
        fileInputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
