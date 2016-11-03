package com.dat.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class EmployeesVO {
	
	@NotNull(message="사원 번호는 필수값 입니다!")
	@NotEmpty(message="사원 번호는 필수값 입니다!(공백불가)")
	private String employeeId;
	private String firstName;
	@NotNull(message="이름은 필수값 입니다!")
	@NotEmpty(message="이름은 필수값 입니다!(공백불가)")
	private String lastName;
	@NotNull(message="이메일은 필수값 입니다!")
	@NotEmpty(message="이메일은 필수값 입니다!(공백불가)")
	private String email;
	private String hireDate;
	private int salary;
	@NotNull(message="직무 번호는 필수값 입니다!")
	@NotEmpty(message="직무 번호는 필수값 입니다!(공백불가)")
	private String jobId;
	private String departmentId;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
}
