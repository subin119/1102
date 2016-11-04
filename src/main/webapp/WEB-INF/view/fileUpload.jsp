<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form 	method="post" 
			enctype="multipart/form-data" 
			action="<c:url value="/doFileUpload" />">
		<input type="text" name="name" /><br/><br/>
		<input type="file" name="attachedFile" /> 	
	</form>
</body>
</html>