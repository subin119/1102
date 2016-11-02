package com.dat.biz.impl;

import java.util.List;

import com.dat.biz.IndexBiz;
import com.dat.dao.IndexDao;
import com.dat.vo.DepartmentsVO;
import com.dat.vo.EmployeesVO;

public class IndexBizImpl implements IndexBiz{
	private IndexDao indexDao;

	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}
	
	@Override
	public String getNowDateTime() {
		return indexDao.getNowDateTime();
	}
	
	@Override
	public List<EmployeesVO> getAllEmployees() {
		return indexDao.getAllEmployees();
	}
	
	@Override
	public List<DepartmentsVO> getAllDepartments() {
		return indexDao.getAllDepartments();
	}
	
	@Override
	public EmployeesVO getEmployeeByEmployeeId(String employeeId) {
		return indexDao.getEmployeeByEmployeeId(employeeId);
	}
	
	@Override
	public DepartmentsVO getDepartmentByDepartmentId(String departmentId) {
		return indexDao.getDepartmentByDepartmentId(departmentId);
	}
	
	@Override
	public boolean addNewEmployee(EmployeesVO employee) {
		return indexDao.addNewEmployee(employee) > 0;
	}
	
	@Override
	public boolean deleteEmployee(String employeeId) {
		return indexDao.deleteEmployee(employeeId) > 0;
	}
	
	@Override
	public boolean addNewDepartment(DepartmentsVO department) {
		return indexDao.addNewDepartment(department) > 0;
	}
	
	@Override
	public boolean deleteDepartment(String departmentId) {
		return indexDao.deleteDepartment(departmentId) > 0;
	}
}
