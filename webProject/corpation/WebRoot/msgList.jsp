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
    
    <title>消息列表</title>
    
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
    <a href="<%=path %>/index.jsp">首页</a><br/><br/>


    <c:if test="${not empty list}" >
    	<c:forEach items="${list}" var="message">
    		<a href="<%=path %>/servlet/GetMessage?messageID=${message.messageID}">${message.messageTitle}</a><br/>
    	</c:forEach>
    </c:if>

    <div align="center">
    	<c:choose>
    		<c:when test="${page.hasPrePage}">
    			<a href="<%=path %>/servlet/GetMessageList?currentPage=1">首页</a>
    			<a href="<%=path %>/servlet/GetMessageList?currentPage=${page.currentPage-1}">上一页</a>
    		</c:when>
    		<c:otherwise>首页｜上一页</c:otherwise>
    	</c:choose>

    	<c:choose>
    		<c:when test="${page.hasNextPage}">
    			<a href="<%=path %>/servlet/GetMessageList?currentPage=${page.currentPage+1}">下一页</a>
    			<a href="<%=path %>/servlet/GetMessageList?currentPage=${page.totalPage}">尾页</a>
    		</c:when>
    		<c:otherwise>下一页｜尾页</c:otherwise>
    	</c:choose>
    </div>

  </body>
</html>
