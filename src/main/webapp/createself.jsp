<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/5/22
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建动态审批流</title>


    <style>
        label {
            display: block;
            margin-bottom: 10px;
        }
        .checkbox-group {
            border: 1px solid #ccc;
            padding: 10px;
            border-radius: 5px;
            max-width: 300px;
            margin: 0 auto 20px;
            text-align: center;
        }
        .checkbox-group label {
            font-size: 16px;
        }
        .submit-btn {
            display: block;
            margin: 0 auto;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<form action="createprocess" method="post">
    <div class="checkbox-group">
        <label>
            <input type="radio" name="approvalType" value="lecture-only"/>
            只有主讲教师审批
        </label>
        <label>
            <input type="radio" name="approvalType" value="header-only"/>
            只有主管教师审批
        </label>
        <label>
            <input type="radio" name="approvalType" value="custom"/>
            自定义教师审批
        </label>
    </div>
    <input type="submit" value="下一步" class="submit-btn">
</form>
</body>
</html>