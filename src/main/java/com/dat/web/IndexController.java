package com.dat.web;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dat.service.IndexService;
import com.dat.vo.DepartmentsVO;
import com.dat.vo.EmployeesVO;

@Controller
public class IndexController {
	
	private IndexService indexService;

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}

	@RequestMapping("/")
	public String viewIndexPage() {
		return "index";
	}
	
	@RequestMapping("/now")
	public ModelAndView viewNowDateTimePage() {
		
		String nowDateTime = indexService.getNowDateTime();
		System.out.println(nowDateTime);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("now");
		view.addObject("nowDateTime",nowDateTime);
		return view;
		
	}
	
	@RequestMapping("/hr/employees")
	public ModelAndView viewAllEmployeesPage() {
		
		List<EmployeesVO> allEmployees = indexService.getAllEmployees();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("hr/employees");
		view.addObject("allEmployees", allEmployees);
		return view;
	}
	
	@RequestMapping("/hr/employee/{employeeId}")
	public ModelAndView viewEmployeePage(@PathVariable String employeeId) {
		
		EmployeesVO employee = indexService.getEmployeeByEmployeeId(employeeId);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("hr/employees");
		view.addObject("employee", employee);
		return view;
	}	
									
	@RequestMapping("/hr/addNewEmployee")
	public String viewAddNewEmployeePage(HttpSession session) {
		
		return "hr/addNewEmployee";
	}
	
	@RequestMapping("hr/doAddEmployeeAction")
	public ModelAndView doAddEmployeeAction(@Valid EmployeesVO employee, Errors errors, HttpSession session) {
		ModelAndView view = new ModelAndView();
		
		if(errors.hasErrors()) {
			view.setViewName("hr/addNewEmployee");
		}
		else {
			boolean isSuccess = indexService.addNewEmployee(employee);
			view.setViewName("redirect:/hr/employees");
		}
		
		return view;
	}
	
	@RequestMapping("hr/doDeleteEmployeeAction/{employeeId}")
	public ModelAndView doDeleteEmployeeAction(@PathVariable String employeeId) {
		
		boolean isSuccess = indexService.deleteEmployee(employeeId);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/hr/employees");
		return view;
	}
	
	@RequestMapping("/hr/departments")
	public ModelAndView viewAllDepartmentsPage() {
		
		List<DepartmentsVO> allDepartments = indexService.getAllDepartments();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("hr/departments");
		view.addObject("allDepartments", allDepartments);
		return view;
	}
									//PathParam
	@RequestMapping("/hr/department/{departmentId}")
	public ModelAndView viewDepartmentPage(@PathVariable String departmentId) {
		
		DepartmentsVO department = indexService.getDepartmentByDepartmentId(departmentId);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("hr/departments");
		view.addObject("department", department);
		return view;
	}
	
	@RequestMapping("/hr/addNewDepartment")
	public String viewAddNewDepartmentPage() {
		return "hr/addNewDepartment";
	}
	
	@RequestMapping("/hr/doDepartmentAction")
	public ModelAndView doDepartmentAction(DepartmentsVO department) {
		
		boolean isSuccess = indexService.addNewDepartment(department);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/hr/departments");
		return view;
	}
	
	@RequestMapping("/hr/doDeleteDepartmentAction/{departmentId}")
	public ModelAndView doDeleteDepartmentAction(@PathVariable String departmentId) {
		
		boolean isSuccess = indexService.deleteDepartment(departmentId);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/hr/departments");
		return view;
	}
}
