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
    
    <title>显示所有投票</title>
    
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

        <table border="1">
        <c:forEach items="${voteResultList }" var="voteResult">
            <tr>
                <td>${voteResult.vote.voteID}</td>
                <td>${voteResult.vote.voteName}</td>
                <c:forEach items="${voteResult.voteOptions}" var="voteOption">
                    <td>${voteOption.voteOptionName}</td>
                </c:forEach>
                <td><a href="<%=basePath %>deleteVote.action?voteID=${voteResult.vote.voteID}">删除</a></td>
            </tr>
        </c:forEach>
        </table>
  </body>
 <script type="text/javascript">

 </script>
</html>