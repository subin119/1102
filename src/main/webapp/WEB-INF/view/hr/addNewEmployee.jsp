<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image:url(/MVC/img/정유미2.jpg); color: #fff;">

	<form:form	commandName="employeesVO"
				method="post" 
				action="/MVC/hr/doAddEmployeeAction"
				cssStyle="font-size:20px; margin:0 auto; width:400px; margin-top:350px;">
				
		<label for="employeeId">사번 : </label>
		<input type="text" id="employeeId" name="employeeId" /><br/>
		<form:errors path="employeeId" cssStyle="color:red;"/><br/>
		
		<label for="lastName">이름 : </label>
		<input type="text" id="lastName" name="lastName" /><br/>
		<form:errors path="lastName" cssStyle="color:red;" /><br/>
		
		<label for="email">이메일 : </label>
		<input type="text" id="email" name="email" /><br/>
		<form:errors path="email" cssStyle="color:red;" /><br/>

		<label for="jobId">직무 번호 : </label>
		<input type="text" id="jobId" name="jobId" /><br/>
		<form:errors path="jobId" cssStyle="color:red;" /><br/>
		
		<input type="submit" value="등록" />
	</form:form>
</body>
</html>