<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/5/22
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>申请列表</title>
    <script language="JavaScript" type="application/javascript">
        function apply(id){
            window.location.href="courseapply?courseid=" + id;
        }
        function logout(){
            window.location.href="studenthome.jsp";
        }
        function del(cid){
            window.location.href="deleteApply?cid=" + cid;
        }
        function update(cid){
            window.location.href="updateApply?cid=" + cid;
        }
        function conf(cid,state){
            window.location.href = "confirmApply?cid=" + cid + "&state=" + state;
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
<h3 align="center">进度查询</h3>
<table align="center" border="1">
    <tr>
        <th>序号</th>
        <th>课程编号</th>
        <th>申请状态</th>
        <th>申请原因</th>
        <th>证明</th>
        <th>修改</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${applyList1}" var="apply" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${apply.courseid}</td>
            <td>${apply.statement}</td>
            <td>${apply.reason}</td>
            <td><a href="download?filename=${apply.prove}">${apply.prove}</a> </td>
            <td><input type="button" value="修改" onclick="update('${apply.courseid}')"/> </td>
            <td><input type="button" value="删除" onclick="del('${apply.courseid}')"/> </td>
        </tr>
    </c:forEach>
</table>
<br/>
<table align="center" border="1">
    <tr>
        <th>序号</th>
        <th>课程编号</th>
        <th>申请状态</th>
        <th>申请原因</th>
        <th>证明</th>
        <th>确认</th>
    </tr>
    <c:forEach items="${applyList2}" var="apply" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${apply.courseid}</td>
            <td>${apply.statement}</td>
            <td>${apply.reason}</td>
            <td><a href="download?filename=${apply.prove}">${apply.prove}</a> </td>
            <td><input type="button" value="确认" onclick="conf('${apply.courseid}','${apply.state}')"/> </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
