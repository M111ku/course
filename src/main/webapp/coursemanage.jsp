<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/5/21
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>课程管理</title>


    <script language="JavaScript" type="application/javascript">
        function logout(){
            window.location.href="adminhome.jsp"
        }
        function del(cid){
            window.location.href="coursedelete?cid=" + cid
        }
        function addCourse(){
            window.location.href="addcourse.jsp"
        }
        function createSlef(cid){
            window.location.href="createprocess?cid=" + cid
        }
        function createDefault(cid){
            window.location.href="createdefault?cid=" + cid
        }
        function setPage(page) {
            window.location.href = "coursemanagement?page=" + page;
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
        td:nth-child(3) {
            width: 20%;
        }
        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .pagination ul {
            display: inline-flex;
            padding-left: 0;
            list-style: none;
        }

        .pagination li {
            display: inline-block;
            border: 1px solid #ddd;
            margin-left: -1px;
        }

        .pagination li a {
            display: inline-block;
            padding: 8px 16px;
            color: #333;
        }

        .pagination li.active a {
            background-color: #007bff;
            color: #fff;
        }

        .pagination li a:hover:not(.active) {
            background-color: #ddd;
        }


    </style>
</head>
<body>
<div class="header">
    <div align="right" class="logout-btn">
        <input align="right" type="button" onclick="logout()" value="返回主页">
    </div>
</div>
<h3>课程列表</h3>
<div align="right" class="btn-group">
    <input type="button" onclick="addCourse()" value="新增课程">
</div>
<table>
    <thead>
    <tr>
        <th>序号</th>
        <th>课程编号</th>
        <th>课程名称</th>
        <th>主讲编号</th>
        <th>主管编号</th>
        <th>删除</th>
        <th>创建默认审批流</th>
        <th>自定义审批流</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${courseList}" var="course" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${course.cid}</td>
            <td>${course.cname}</td>
            <td>${course.lecturer}</td>
            <td>${course.header}</td>

            <td><input type="button" value="删除" onclick="del('${course.cid}')"></td>
            <td><input type="button" value="创建" onclick="createDefault('${course.cid}')"></td>
            <td><input type="button" value="创建" onclick="createSlef('${course.cid}')"></td>
        </tr>
    </c:forEach>
    </tbody>
</table>




<%--<div class="pagination">--%>
<%--    <c:set var="numLinks" value="${totalCount / 5 + 1}" /> <!-- 设置需要生成的超链接数量 -->--%>
<%--    <ul>--%>
<%--        <c:forEach begin="1" end="${numLinks}" var="i">--%>
<%--            <li><a href="coursemanage?currentPage=${i}&pageSize=${5}">${i}</a></li>--%>
<%--        </c:forEach>--%>
<%--    </ul>--%>
<%--</div>--%>

<div class="pagination">
    <c:set var="numLinks" value="${totalCount/ 5 + 1}" />
    <ul>
        <c:forEach begin="1" end="${numLinks}" var="i">
            <li class="<c:if test='${currentPage == i}'>active</c:if>"><a href="coursemanage?currentPage=${i}&pageSize=${5}">${i}</a></li>
        </c:forEach>
    </ul>
</div>
</body>
</html>