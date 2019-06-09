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
  <table border="1">
    <tr>
        <td>
            编号
        </td>
        <td>试题标题</td>
        <td>正确答案</td>
        <td>查看试题</td>
        <td>更新试题</td>
        <td>删除试题</td>
    </tr>
    <c:forEach items="${result.list}" var="subject">
        <tr>
            <td>
                ${subject.subjectID}
            </td>
            <td>${subject.subjectTitle}</td>
            <td>${subject.subjectAnswer}</td>
            <td>
                <a href="<%=basePath %>subjectParticular.action?subjectID=${subject.subjectID}">查看</a>
            </td>
            <td>
                <a href="<%=basePath %>subjectUpdateBefore.action?subjectID=${subject.subjectID}">更新</a>
            </td>
            <td>
                <a href="<%=basePath %>subjectDelete.action?subjectID=${subject.subjectID}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<script type="text/javascript">

</script>
</html>