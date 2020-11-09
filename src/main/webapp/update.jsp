<%--
  Created by IntelliJ IDEA.
  User: legendluo
  Date: 2020/11/9
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="user" method="post">
    <input type="hidden" name="action" value="subUpdate">
    <input type="hidden" name="id" value="${user.u_id}">
    姓名:<input type="text" name="name" value="${user.u_name}"><br>
    密码:<input type="text" name="pass" value="${user.u_pass}"><br>
    邮箱:<input type="text" name="email" value="${user.u_email}"><br>
    性别:<input type="text" name="gender" value="${user.u_gender}"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
