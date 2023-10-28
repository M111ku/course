<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/5/25
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <title>申请列表</title>
  <script language="JavaScript" type="application/javascript">
    function logout() {
      if ("${user.getIdentity()}" === "2" || "${user.getIdentity()}" === "3") {
        window.location.href = "applyCheck";
      } else {
        window.location.href = "checkAllApply";
      }
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
</head>
<body>
<div align="right">
  <input type="button" onclick="logout()" value="返回">
</div>
<h3 align="center">审批列表</h3>
<br/>

<%--<div align="center">--%>
<%--  <form action="searchApply" method="get">--%>
<%--    <label for="courseId">课程编号:</label>--%>
<%--    <input type="text" id="courseId" name="courseId" />--%>
<%--    <label for="studentId">学生编号:</label>--%>
<%--    <input type="text" id="studentId" name="studentId" />--%>
<%--    <button type="submit">搜索</button>--%>
<%--  </form>--%>
<%--</div>--%>

<table align="center" border="1">
  <tr>
    <th>序号</th>
    <th>课程编号</th>
    <th>学生编号</th>
    <th>申请状态</th>
    <th>申请原因</th>
    <th>证明</th>

  </tr>
  <c:forEach items="${applyList}" var="apply" varStatus="status">
    <tr>
      <td>${status.index+1}</td>
      <td>${apply.courseid}</td>
      <td>${apply.studentid}</td>
<%--      <td>${apply.statement}</td>--%>
      <td>${apply.reason}</td>
      <td><a href="download?filename=${apply.prove}">${apply.prove}</a> </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
