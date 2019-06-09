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
    <c:if test="${employee== null}">
      <a href="<%=path %>/statusRecognise.jsp">点击登录</a>
    </c:if>
    <c:if test="${employee != null}" >
      ${employee.employeeID} 已登录
      <ul>
      	<li>员工编号：${employee.employeeID}</li>
      	<li>员工姓名：${employee.employeeName}</li>
      	<li>管理层领导：${employee.isLead?'是':'否'}</li>
      </ul>
      <a href="<%=path %>/servlet/GetMessageList">消息列表</a><br/>
      <a href="<%=path %>/publishNewMsg.jsp">发布消息</a>
    </c:if>

</body>
</html>
