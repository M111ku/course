<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/5/20
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>


    <script language="JavaScript" type="application/javascript">
        function logout(){
            window.location.href="adminhome.jsp"
        }
        function del(uid){
            window.location.href="userdelete?uid=" + uid
        }
        function addUser(){
            window.location.href="adduser.jsp"
        }
    </script>


    <style>
        body {
            font-family: Arial, sans-serif;
            font-size: 16px;
            line-height: 1.5;
        }

        h3 {
            margin-top: 30px;
            text-align: center;
        }

        hr {
            border: none;
            border-top: 1px solid #999;
            margin: 20px 0;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 800px;
            margin: 0 auto;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #eee;
            font-weight: bold;
        }

        tr:nth-child(odd) {
            background-color: #f2f2f2;
        }

        input[type="button"] {
            padding: 10px 20px;
            margin-right: 10px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            outline: none;
            background-color: #337ab7;
            color: #fff;
        }

        input[type="button"]:hover {
            background-color: #23527c;
        }

        input[type="button"]:active {
            background-color: #1a3d5e;
        }
    </style>
</head>
<body>
<div class="header">
    <div align="right" class="logout-btn">
        <input align="right" type="button" onclick="logout()" value="退出">
    </div>
</div>
<h3>用户列表</h3>
<div align="right" class="btn-group">
    <input type="button" onclick="addUser()" value="新增用户">

</div>
<table>
    <thead>
    <tr>
        <th>序号</th>
        <th>学工号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>身份编号</th>
        <th>姓名</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="user" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${user.uid}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.identity}</td>
            <td>${user.name}</td>

            <td><input type="button" value="删除" onclick="del('${user.uid}')"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
