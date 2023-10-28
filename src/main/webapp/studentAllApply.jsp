<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/5/23
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>申请列表</title>
    <script language="JavaScript" type="application/javascript">

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
    <head>
        <title>所有申请</title>
    </head>

<body>
<div align="right">
    <input type="button" onclick="logout()" value="返回主界面">
</div>

<h3 align="center">所有申请</h3>

<div align="center">
    <form action="searchApply" method="get">
        <label for="courseId">课程编号:</label>
        <input type="text" id="courseId" name="courseId" />
        <label for="courseId">申请状态:</label>
        <input type="text" id="state" name="state" />
        <button type="submit">搜索</button>
    </form>
</div>

<table align="center" border="1">
    <tr>
        <th>序号</th>
        <th>课程编号</th>
        <th>申请状态</th>
        <th>申请原因</th>
        <th>驳回原因</th>
        <th>证明</th>
    </tr>
    <c:forEach items="${applyList}" var="apply" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${apply.courseid}</td>
            <td>${apply.statement}</td>
            <td>${apply.reason}</td>
            <td>${apply.reject}</td>
            <td><a href="download?filename=${apply.prove}">${apply.prove}</a> </td>
        </tr>
    </c:forEach>
</table>

<div class="pagination">
    <c:set var="numLinks" value="${totalCount / 5 + 1}" />
    <ul>
        <c:forEach begin="1" end="${numLinks}" var="i">
            <li class="<c:if test='${currentPage == i}'>active</c:if>"><a href="checkAllApply?currentPage=${i}&pageSize=${5}">${i}</a></li>
        </c:forEach>
    </ul>
</div>
</body>

</html>
