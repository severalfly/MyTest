<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  
<html>
<head>


  <title>员工身份识别</title>

</head>

<body>
     <a href="<%=path %>/index.jsp">首页</a><br/><br/>
    <div id="shenfenshibie">
      <font color="red">${requestScope.error}</font>
      <form action="<%=path %>/servlet/StatusRecogniseAction" method="post">
        <p>员工编号：<input type="text" name="employeeID" value="${param.employeeID}"/></p>
        <p>&nbsp;</p>
        <p>系统口令：<input type="password" name="password"/></p>
        <p><input type="submit" value="提交"/>
            <input type="reset" value="重置"/></p>
      </form>
    </div>

</body>
</html>
