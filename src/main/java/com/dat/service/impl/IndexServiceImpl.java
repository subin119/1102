package com.dat.service.impl;

import java.util.List;

import com.dat.biz.IndexBiz;
import com.dat.service.IndexService;
import com.dat.vo.DepartmentsVO;
import com.dat.vo.EmployeesVO;

public class IndexServiceImpl implements IndexService{
	
	private IndexBiz indexBiz;

	public void setIndexBiz(IndexBiz indexBiz) {
		this.indexBiz = indexBiz;
	}
	
	@Override
	public String getNowDateTime() {
		return indexBiz.getNowDateTime();
	}
	
	@Override
	public List<EmployeesVO> getAllEmployees() {
		return indexBiz.getAllEmployees();
	}
	
	public List<DepartmentsVO> getAllDepartments() {
		return indexBiz.getAllDepartments();
	}
	
	@Override
	public EmployeesVO getEmployeeByEmployeeId(String employeeId) {
		return indexBiz.getEmployeeByEmployeeId(employeeId);
	}
	
	@Override
	public DepartmentsVO getDepartmentByDepartmentId(String departmentId) {
		return indexBiz.getDepartmentByDepartmentId(departmentId);
	}
	
	@Override
	public boolean addNewEmployee(EmployeesVO employee) {
		return indexBiz.addNewEmployee(employee);
	}
	
	@Override
	public boolean deleteEmployee(String employeeId) {
		return indexBiz.deleteEmployee(employeeId);
	}
	
	@Override
	public boolean addNewDepartment(DepartmentsVO department) {
		return indexBiz.addNewDepartment(department);
	}
	
	@Override
	public boolean deleteDepartment(String departmentId) {
		return indexBiz.deleteDepartment(departmentId);
	}
}
