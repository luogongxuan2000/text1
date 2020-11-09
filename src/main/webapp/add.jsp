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
    <input type="hidden" name="action" value="add">
    姓名:<input type="text" name="name" ><br>
    密码:<input type="text" name="pass" ><br>
    邮箱:<input type="text" name="email"><br>
    性别:<input type="text" name="gender"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
