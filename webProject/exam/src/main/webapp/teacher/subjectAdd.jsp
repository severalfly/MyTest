<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>录入试题</title>
    
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
    <form action="<%=path %>/subjectAdd.action" method="post" name="addForm">
    	试题题目<input type="text" name="subjectTitle" id="subjectTitle" value=""/>
        <br>
        选项A：<input type="text" name="subjectOptionA" id="subjectOptionA"/>
        <br>
        选项B：<input type="text" name="subjectOptionB" id="subjectOptionB"/>
        <br>
        选项C：<input type="text" name="subjectOptionC" id="subjectOptionC"/>
        <br>
        选项D：<input type="text" name="subjectOptionD" id="subjectOptionD"/>
        <br>
        答案： <input type="radio" name="subjectAnswer" value="1">A
        <input type="radio" name="subjectAnswer" value="2">B
        <input type="radio" name="subjectAnswer" value="3">C
        <input type="radio" name="subjectAnswer" value="4">D
        <br>
        解析：<input type="textArea" name="subjectParse" id="subjectParse">
        <br>
    	<input type="submit" value="提交"/>
    	<input type="reset" value="重置"/>
    </form>
  </body>
 <script type="text/javascript">

 </script>
</html>