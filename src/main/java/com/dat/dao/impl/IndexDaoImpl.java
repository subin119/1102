package com.dat.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.dat.dao.IndexDao;
import com.dat.vo.DepartmentsVO;
import com.dat.vo.EmployeesVO;

public class IndexDaoImpl extends SqlSessionDaoSupport implements IndexDao{
	public String getNowDateTime() {
		return getSqlSession().selectOne("indexDao.getNowDateTime");
	}
	
	@Override
	public List<EmployeesVO> getAllEmployees() {
		return getSqlSession().selectList("indexDao.getAllEmployees");
	}
	
	@Override
	public List<DepartmentsVO> getAllDepartments() {
		return getSqlSession().selectList("indexDao.getAllDepartments");
	}
	
	@Override
	public EmployeesVO getEmployeeByEmployeeId(String employeeId) {
		return getSqlSession().selectOne("indexDao.getEmployeeByEmployeeId", employeeId); //변수는 한개뿐이 못받는다.
	}
	
	@Override
	public DepartmentsVO getDepartmentByDepartmentId(String departmentId) {
		return getSqlSession().selectOne("indexDao.getDepartmentByDepartmentId",departmentId);
	}
	
	@Override
	public int addNewEmployee(EmployeesVO employee) {
		return getSqlSession().insert("indexDao.addNewEmployee", employee);
	}
	
	@Override
	public int deleteEmployee(String employeeId) {
		return getSqlSession().delete("indexDao.deleteEmployee", employeeId);
	}
	
	@Override
	public int addNewDepartment(DepartmentsVO department) {
		return getSqlSession().insert("indexDao.addNewDepartment", department);
	}
	
	@Override
	public int deleteDepartment(String departmentId) {
		return getSqlSession().delete("indexDao.deleteDepartment", departmentId);
	}
}
