<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 14-4-8
  Time: 上午12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>添加页面</title>
</head>
<body>
<form action="studentService!addStudent" method="post">
<table>
<tr>
<td>姓名:<s:textfield name="student.name"></s:textfield></td>
<td>密码:<s:textfield name="student.password"></s:textfield></td>
<td>年龄:<s:textfield name="student.age"></s:textfield></td>
<td>生日:<s:textfield name="student.birthday"></s:textfield></td>
<td><input type="submit" value="添加">
</tr>
</table>
</form>
</body>
</html>