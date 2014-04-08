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
    <title>更新页面</title>
</head>
<body>
<form action="studentService!updateStudent" method="post">
<table>
<tr>
<s:hidden name="student.id"></s:hidden>
<td>姓名:<s:textfield name="student.name" /></td>
<td>密码:<s:textfield name="student.password" /></td>
<td>年龄:<s:textfield name="student.age" /></td>
<td>生日:<s:textfield name="student.birthday" /></td>
<td><input type="submit" value="更新"> 
</tr>
</table>
</form>
</body>
</html>