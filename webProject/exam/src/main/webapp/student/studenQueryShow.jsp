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
    
    <title>查看学生</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">


</head>

<body>
    <table>
        <tr>
            <td>学生编号</td>
            <td>所在班级</td>
            <td>姓名</td>
            <td>成绩</td>
        </tr>
        <c:if test="${not empty students}">
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.studentID}</td>
                    <td>${student.sclass }</td>
                    <td>${student.studentName}</td>
                    <td>${student.result }</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</table>
</body>
<script type="text/javascript">

</script>
</html>