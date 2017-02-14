<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>


  <title>首页</title>

</head>

<body>
 <a href="<%=path %>/index.jsp">首页</a><br/><br/>
  <div id="messageBox">
    <p><font color="red">${error}</font></p>
    <form action="<%=path %>/servlet/MsgPublish" method="post">
    <p>消息标题:<input type="text" name="title" size="50"/></p>
    <p>消息内容:<textarea name="content" height="400" width="600"></textarea></p>
    <p align="center"><input type="submit" value="提交"/>
      <input type="reset" value="重置"/></p>
    </form>
  </div>   

</body>
</html>
