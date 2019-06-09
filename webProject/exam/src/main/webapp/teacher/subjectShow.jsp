<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>显示试题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  ${subject.subjectID }
    <table border="1">
        <tr>
            <td>试题编号</td>
            <td>${subject.subjectID }</td>
        </tr>
        <tr>
            <td>试题题目</td>
            <td>${subject.subjectTitle }</td>
        </tr>
        <tr>
            <td>选项A</td>
            <td>${subject.subjectOptionA }</td>
        </tr>
        <tr>
            <td>选项B</td>
            <td>${subject.subjectOptionB }</td>
        </tr>
        <tr>
            <td>选项C</td>
            <td>${subject.subjectOptionC }</td>
        </tr>
        <tr>
            <td>选项D</td>
            <td>${subject.subjectOptionD }</td>
        </tr>
        <tr>
            <td>答案</td>
            <td>${subject.subjectAnswer }</td>
        </tr>
        <tr>
            <td>答案解析</td>
            <td>${subject.subjectParse }</td>
        </tr>
    </table>
  </body>
 <script type="text/javascript">

 </script>
</html>