<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>消息详情页面</title>
    
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
  	 <a href="<%=path %>/index.jsp">首页</a><br/>
  	 <br/>
    <p><font color="red">${error}</font></p>
    <p>消息标题：${message.messageTitle }</p>
    <p>消息内容：${message.messageContent }</p>
    <div align="center">
    	发布人ID：${message.employeeID }&nbsp;&nbsp;发布时间：${message.publishTime }
    </div>
    <c:forEach items="${replyes }" var="reply">
    	<p>${reply.replyContent } </p>
    	<p>回复ID：${reply.employeeID}:回复时间${reply.replyTime} </p>
    </c:forEach>


    <div align="left">
    	<p>回复</p>
    	<p><font color="red">${error }</font></p>
    	<form action="<%=path %>/servlet/CommitReply" method="post">
    		<textarea name="replyContent"></textarea><br/>
    		<input type="hidden" name="messageID" value="${message.messageID}" />
    		<input type="submit" value="提交"/>
    		<input type="reset" value="重置"/>
    	</form>
    </div>

  </body>
</html>
