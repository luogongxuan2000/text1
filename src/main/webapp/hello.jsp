<%--
  Created by IntelliJ IDEA.
  User: legendluo
  Date: 2020/11/9
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--使用el表达式 是否当做字符串处理--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table border="1">
        <tr><a href="/user">查询所有</a></tr>
        <tr>
            <th>用户id</th>
            <th>用户姓名</th>
            <th>用户地址</th>
            <th>用户性别</th>
            <th>操作</th>
            <th><a href="add.jsp">新增</a></th>
        </tr>

        <c:forEach var="user" items="${user}">
            <tr>
                <td>${user.u_id}</td>
                <td>${user.u_name}</td>
                <td>${user.u_pass}</td>
                <td>${user.u_email}</td>
                <td>${user.u_gender}</td>
                <td>
                    <a href="user?action=update&id=${user.u_id}">修改</a>
                    <a href="user?action=del&id=${user.u_id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
