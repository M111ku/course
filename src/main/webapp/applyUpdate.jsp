<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/5/23
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
  <title>提交申请</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }

    h3 {
      text-align: center;
    }

    form {
      width: 500px;
      margin: 0 auto;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      padding: 10px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    th {
      color: #666;
    }

    input[type="text"], input[type="file"] {
      border: none;
      padding: 5px;
      width: 100%;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: white;
      border: none;
      padding: 10px 20px;
      border-radius: 5px;
      cursor: pointer;
      float: right;
      margin-top: 20px;
    }

    input[type="submit"]:hover {
      background-color: #3e8e41;
    }
  </style>
</head>
<body>
<h3>申请信息更新</h3>
<form action="updateApply" method="post" enctype="multipart/form-data">
  <table>
    <tr>
      <th>课程编号</th>
      <td><input type="text" value="${course.cid}" name="courseid" readonly/></td>
    </tr>
    <tr>
      <th>课程名称</th>
      <td><input type="text" value="${course.cname}" name="coursename" readonly/></td>
    </tr>
    <tr>
      <th>主讲教师编号</th>
      <td><input type="text" value="${course.lecturer}" name="lecturer" readonly/></td>
    </tr>
    <tr>
      <th>主管教师编号</th>
      <td><input type="text" value="${course.header}" name="header" readonly/></td>
    </tr>
    <tr>
      <th>申请原因</th>
      <td><input type="text"  name="reason" /></td>
    </tr>
    <tr>
      <th>申请证明</th>
      <td><input type="file" name="f1" /></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="提交申请" /></td>
    </tr>
  </table>
</form>
</body>
</html>
