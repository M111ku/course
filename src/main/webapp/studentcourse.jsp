<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/5/22
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>课程列表</title>
    <script language="JavaScript" type="application/javascript">
        function apply(id){
            window.location.href="courseapply?courseid=" + id;
        }
        function logout(){
            window.location.href="studenthome.jsp";
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
<div align="right">
    <input type="button" onclick="logout()" value="返回主界面">
</div>
<h3 align="center">${user.name}的课程列表</h3>
<table align="center" border="1">
    <tr>
        <th>序号</th>
        <th>课程编号</th>
        <th>课程名称</th>
        <th>主讲编号</th>
        <th>主管编号</th>
        <th>第一审批人</th>
        <th>第二审批人</th>
        <th>选择</th>
    </tr>
    <c:forEach items="${courseList}" var="course" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${course.courseid}</td>
            <td>${course.cname}</td>
            <td>${course.lecturer}</td>
            <td>${course.header}</td>
            <td>${course.first}</td>
            <td>${course.second}</td>
            <td><input type="button" value="申请" onclick="apply('${course.courseid}')"/> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
