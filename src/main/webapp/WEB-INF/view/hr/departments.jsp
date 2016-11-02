<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DEPARTMENT</title>
</head>
<body style="background-image:url(/MVC/img/정유미.jpg); color: #000;">
	<c:if test="${not empty allDepartments}">
	<c:forEach items="${allDepartments}" var="department">
		${department.departmentId} / ${department.departmentName} / ${department.managerId} / ${department.locationId}<br/>
	</c:forEach>
	</c:if>
	
	<c:if test="${not empty department}">
		${department.departmentId} / ${department.departmentName} / 
		<c:if test="${empty department.managerId}">♣</c:if> ${department.managerId} / ${department.locationId}<br/>
	<input type="button" value="삭제" onclick="location.href='/MVC/hr/doDeleteDepartmentAction/${department.departmentId}'"/>
	</c:if>
</body>
</html>