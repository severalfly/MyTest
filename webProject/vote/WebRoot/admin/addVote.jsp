<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加投票</title>
    
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
    <form action="<%=path %>/addVote.action" method="post" name="addForm">
    	选择投票频道：<select name="channel">
    		<option value="1">NBA</option>
    		<option value="2">CBA</option>
    		<option value="3">世界杯</option>
    	</select><br/>
    	请输入投票名称：
    	<input type="text" name="voteName"/><br/>
    	<div id="voteOptionList">
    		选项 1 名称：<input type="text" name="voteOption"/><br/>
    		选项 2 名称：<input type="text" name="voteOption"/><br/>
    		选项 3 名称：<input type="text" name="voteOption"/><br/>
    	</div>
    	<input type="submit" value="提交"/>
    	<input type="reset" value="重置"/>
    </form>
  </body>
 <script type="text/javascript">

 </script>
</html>