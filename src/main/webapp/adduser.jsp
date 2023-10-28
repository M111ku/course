<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2023/5/21
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, Helvetica, sans-serif;
        }
        .container {
            width: 80%;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-table {
            width: 100%;
            border-collapse: collapse;
        }
        .form-table th, .form-table td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        .form-table th {
            width: 30%;
        }
        .form-table input[type="text"] {
            padding: 8px;
            border-radius: 6px;
            border: 1px solid #ccc;
            width: 70%;
        }
        .submit-button {
            background-color: #0077cc;
            color: #fff;
            padding: 10px;
            border-radius: 6px;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }
        .submit-button:hover {
            background-color: #005faa;
        }
        .logout-button {
            background-color: #fff;
            color: #0077cc;
            font-size: 16px;
            border: none;
            cursor: pointer;
            transition: all 0.3s ease-in-out;
        }
        .logout-button:hover {
            color: #005faa;
            transform: scale(1.1);
        }
    </style>
</head>
<body>
<div class="container">
    <h3 align="center">新增用户</h3>
    <br/>
    <div align="right">
        <button class="logout-button" onclick="logout()">返回</button>
    </div>
    <form action="useradd" method="post">
        <table class="form-table">
            <tr>
                <th>学工号</th>
                <td><input type="text" name="uid" /></td>
            </tr>
            <tr>
                <th>用户名</th>
                <td><input type="text"  name="username" /></td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input type="text"  name="password" /></td>
            </tr>
            <tr>
                <th>身份编号</th>
                <td><input type="text" name="identity" /></td>
            </tr>
            <tr>
                <th>姓名</th>
                <td><input type="text"  name="name" /></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input class="submit-button" type="submit" value="提交" /></td>
            </tr>
        </table>
    </form>
</div>
<script>
    function logout() {
        window.location.href="usermanage";
    }
</script>
</body>
</html>
