<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 14-4-8
  Time: 上午12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
    <script type="text/javascript">
     function goAdd(){
    	 window.location.href="studentService!goAddStudent";
     }
     function deleteStu(id){
    	 var x=window.confirm("是否要删除!");
    	 if(x){
    	 window.location.href="studentService!deleteStudent?student.id="+id;
    	 }else{
    		 
    	 }
     }
    </script>
</head>
<body>
 <table>
     <thead>
     <tr>
         <th>名字</th>
         <th>年龄</th>
         <th>生日</th>
         <th colspan="2">操作</th>
     </tr>
     </thead>
     <tbody>
     <s:iterator value="studentList">
     <tr>
     <td><s:property value="name"/></td>
     <td><s:property value="age"/></td>
     <td><s:property value="birthday"/></td>
     <td><a href="studentService!goUpdateStudent?student.id=<s:property value="id"/>">更新</a></td>
     <td><input type="button" value="删除" onclick="deleteStu(<s:property value="id"/>)"></td>
     </tr>
     </s:iterator>
     <tr>
     <td><input type="button" value="添加" onclick="goAdd()"></td>
     </tr>
     </tbody>
 </table>
</body>
</html>