package com.dat.dao;

import java.util.List;

import com.dat.vo.DepartmentsVO;
import com.dat.vo.EmployeesVO;

public interface IndexDao {
	public String getNowDateTime();
	public List<EmployeesVO> getAllEmployees();
	public List<DepartmentsVO> getAllDepartments();
	public EmployeesVO getEmployeeByEmployeeId(String employeeId);
	public DepartmentsVO getDepartmentByDepartmentId(String departmentId);
	public int addNewEmployee(EmployeesVO employee);
	public int deleteEmployee(String employeeId);
	public int addNewDepartment(DepartmentsVO department);
	public int deleteDepartment(String departmentId);
}
