<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/5/16
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>后台界面</title>
    <script language="JavaScript" type="application/javascript">
        function usermanage(){
            window.location.href="usermanage";
        }
        function  coursemanage(){
            var pageSize = 5;
            var currentPage = 1;
            window.location.href = "coursemanage?currentPage=" + currentPage + "&pageSize=" + pageSize;
        }
        function permissionmanage(){
            window.location.href="permissionmanage"
        }
        function applyManage(){
            window.location.href="applyManage"
        }

        function consentapply(){
            window.location.href="consentapply"
        }
        function logout(){
            window.location.href="logout";
        }
    </script>
<%--    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700&display=swap" rel="stylesheet">--%>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #F7F9FA;
            margin: 0;
            padding: 0;
        }

        h1, h2, h3, h4, h5, h6 {
            font-weight: 500;
        }

        .container {
            max-width: 800px;
            margin: auto;
            padding: 40px;
            box-sizing: border-box;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        .welcome-message {
            text-align: center;
            margin-bottom: 20px;
        }

        hr {
            margin-top: 30px;
            margin-bottom: 30px;
            border: 0;
            height: 1px;
            background-color: #f5f5f5;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            text-align: center;
            font-weight: 500;
            color: #2196F3;
            padding: 10px;
            border-bottom: 2px solid #f5f5f5;
        }

        td {
            padding: 10px;
            border-bottom: 1px solid #f5f5f5;
            text-align: center;
        }

        input[type="button"] {
            background-color: #2196F3;
            border: none;
            color: #fff;
            cursor: pointer;
            padding: 10px 20px;
            border-radius: 4px;
            font-weight: 500;
            transition: background-color 0.2s ease-in-out;
        }

        input[type="button"]:hover {
            background-color: #1976D2;
        }

        .logout-button {
            background-color: transparent;
            border: none;
            color: #666;
            cursor: pointer;
            font-size: 16px;
            font-weight: 500;
        }

        .logout-button:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <div align="right">
        <button class="logout-button" onclick="logout()">退出</button>
    </div>

    <h3 class="welcome-message">欢迎管理人员${user.name},请选择功能</h3>

    <form action="login" method="get">
        <table>
            <tr>
                <td><input type="button" onclick="usermanage()" value="用户管理"/></td>
            </tr>
            <tr>
                <td><input type="button" onclick="coursemanage()" value="课程管理"/></td>
            </tr>
            <tr>
                <td><input type="button" onclick="applyManage()" value="审批记录查询"/></td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
