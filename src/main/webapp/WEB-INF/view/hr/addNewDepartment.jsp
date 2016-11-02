<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image:url(/MVC/img/정유미.jpg); color: #000;">
	<form method="post" action="/MVC/hr/doDepartmentAction">
		<label for="departmentId">부서 번호 : </label>
		<input type="text" id="departmentId" name="departmentId"><br/>
		
		<label for="departmentName">부서 이름 : </label>
		<input type="text" id="departmentName" name="departmentName"><br/>
		
		<label for="managerId">사원 번호 : </label>
		<input type="text" id="managerId" name="managerId"><br/>
		
		<label for="locationId">지역 번호 : </label>
		<input type="text" id="locationId" name="locationId"><br/>
	
		<input type="submit" value="등록"/>
	</form>
</body>
</html>