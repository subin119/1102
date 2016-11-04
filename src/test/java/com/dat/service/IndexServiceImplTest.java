package com.dat.service;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.dat.vo.EmployeesVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/rootContext.xml",
								"file:src/main/webapp/WEB-INF/spring/indexContext.xml"})
public class IndexServiceImplTest {
	
	private Logger logger = LoggerFactory.getLogger(IndexServiceImplTest.class);
	
	@Autowired
	private IndexService indexService;
	
	@Before
	public void setUp() {
		logger.info("Before 입니다........");
		EmployeesVO newEmployee = new EmployeesVO();
		newEmployee.setEmployeeId("9999");
		newEmployee.setFirstName("TEST_FirstName");
		newEmployee.setLastName("TEST_LastName");
		newEmployee.setEmail("TEST_Email");
		newEmployee.setJobId("IT_PROG");
		indexService.addNewEmployee(newEmployee);
	}

	@After
	public void tearDown() {
		logger.info("After 입니다.........");
		indexService.deleteEmployee("9999");
		indexService.deleteEmployee("9998");
	}
	
	@Test
	public void getNowDateTime() {
		String nowDateTime = indexService.getNowDateTime();
		logger.info("현재시간은 "+ nowDateTime + " 입니다!");
		Assert.notNull(nowDateTime);
	}
	
	@Test
	public void getAllEmployees(){
		List<EmployeesVO> allEmployees = indexService.getAllEmployees();
		Assert.notNull(allEmployees);
		Assert.isTrue(allEmployees.size() > 0);
	}
	
	@Test
	public void getAllDepartments(){
		
	}
	
	@Test
	public void getEmployeeByEmployeeId(){
		EmployeesVO employee = indexService.getEmployeeByEmployeeId("9999");
		Assert.notNull(employee);
	}
	
	@Test
	public void getDepartmentByDepartmentId(){
		
	}
	
	@Test
	public void addNewEmployee(){
		EmployeesVO newEmployee = new EmployeesVO();
		newEmployee.setEmployeeId("9998");
		newEmployee.setFirstName("TEST_FirstName");
		newEmployee.setLastName("TEST_LastName");
		newEmployee.setEmail("TEST_EmailTwo");
		newEmployee.setJobId("IT_PROG");
		boolean result = indexService.addNewEmployee(newEmployee);
		Assert.isTrue(result);
		
		EmployeesVO employee = indexService.getEmployeeByEmployeeId("9998");
		Assert.notNull(employee);
		Assert.isTrue(newEmployee.getEmployeeId().equals(employee.getEmployeeId()));
		Assert.isTrue(newEmployee.getLastName().equals(employee.getLastName()));
	}
	
	@Test(expected=DuplicateKeyException.class)
	public void addNewEmployeeDuplicatedID() {
		EmployeesVO newEmployee = new EmployeesVO();
		newEmployee.setEmployeeId("9999");
		newEmployee.setFirstName("TEST_FirstName");
		newEmployee.setLastName("TEST_LastName");
		newEmployee.setEmail("TEST_EmailTwo");
		newEmployee.setJobId("IT_PROG");
		indexService.addNewEmployee(newEmployee);
	}
	
	@Test
	public void deleteEmployee(){
		
	}
	
	@Test
	public void addNewDepartment(){
		
	}
	
	@Test
	public void deleteDepartment(){
		
	}
	

}
