<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="utf-8">
<title>test</title>


</head>
<body>
	<c:choose>
		<c:when test='${not empty imageList }'>
			not empty
			<c:forEach items="${imageList}" varStatus="status" var="image">
    		${image.a}
    	</c:forEach>
		</c:when>
		<c:when test='${empty imageList }'>
			empty
		</c:when>
	</c:choose>
	<c:if test="${user.username == null }"> 空串</c:if>
	<c:if test="${user.username eq '' }"> 空串</c:if>
	<c:if test="${user.username == '' }"> 空串</c:if>
	
	${user.username }
</body>
</html>