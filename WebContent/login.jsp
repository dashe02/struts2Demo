<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 14-4-8
  Time: 上午12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
     <form action="studentService!login" method="post">
	      姓名:<input type="text" name="student.name"><br>
	      密码:<input type="password" name="student.password">
      <input type="submit" value="登录">
     </form>
</body>
</html>