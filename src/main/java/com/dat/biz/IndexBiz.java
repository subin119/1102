package com.dat.biz;

import java.util.List;

import com.dat.vo.DepartmentsVO;
import com.dat.vo.EmployeesVO;

public interface IndexBiz {

	public String getNowDateTime();
	public List<EmployeesVO> getAllEmployees();
	public List<DepartmentsVO> getAllDepartments();
	public EmployeesVO getEmployeeByEmployeeId(String employeeId);
	public DepartmentsVO getDepartmentByDepartmentId(String departmentId);
	public boolean addNewEmployee(EmployeesVO employee);
	public boolean deleteEmployee(String employeeId);
	public boolean addNewDepartment(DepartmentsVO department);
	public boolean deleteDepartment(String departmentId);

}
