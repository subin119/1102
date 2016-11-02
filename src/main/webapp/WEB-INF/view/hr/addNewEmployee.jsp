<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image:url(/MVC/img/정유미.jpg); color: #000;">

	<form method="post" action="/MVC/hr/doAddEmployeeAction">
		<label for="employeeId">사번 : </label>
		<input type="text" id="employeeId" name="employeeId" /><br/>
		
		<label for="lastName">이름 : </label>
		<input type="text" id="lastName" name="lastName" /><br/>
		
		<label for="email">이메일 : </label>
		<input type="text" id="email" name="email" /><br/>

		<label for="jobId">직무 번호 : </label>
		<input type="text" id="jobId" name="jobId" /><br/>
		
		<input type="submit" value="등록" />
	</form>
</body>
</html>