package com.dat.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dat.service.IndexService;
import com.dat.vo.DepartmentsVO;
import com.dat.vo.EmployeesVO;
import com.dat.vo.UploadVO;

@Controller
public class IndexController {
	
	private IndexService indexService;
	private Logger logger = LoggerFactory.getLogger(IndexController.class);

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
		logger.debug(nowDateTime);
		
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
		
		if(employee == null) {
			throw new RuntimeException(employeeId + "번 사원은 존재하지 않습니다!");
		}
		ModelAndView view = new ModelAndView();
		view.setViewName("hr/employees");
		view.addObject("employee", employee);
		logger.debug(employeeId);
		return view;
	}	
									
	@RequestMapping("/hr/addNewEmployee")
	public String viewAddNewEmployeePage(HttpSession session) {
		
		Integer.parseInt("ABC");
		
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
	
	@RequestMapping("/fileUpload")
	public String viewFileUploadPage() {
		return "fileUpload";
	}
	
	@RequestMapping("/doFileUpload")
	public ModelAndView doFileUploadAction(UploadVO uploadVO) {
		
	/*public ModelAndView doFileUploadAction(HttpServletRequest request) {*/
		/*MultipartFile file = request.getFile("attachedFile");*/
		/*String name = request.getParameter("name");*/
		
		MultipartFile file = uploadVO.getAttachedFile();
		String name= uploadVO.getName();
		
		logger.info(name + "이 업로드 요청함");
		
		if(!file.isEmpty()) {
			File uploadFile = new File("D:\\uploadFiles\\" + file.getOriginalFilename());
			
			//getAbsolutePath() : 파일의 전체경로가 나온다!
			logger.info(uploadFile.getAbsolutePath() + "에 업로드 함.");
			
			try {
				file.transferTo(uploadFile);
			} catch (IllegalStateException e) {
				throw new RuntimeException(e.getMessage(), e);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("redirect:/fileUpload");
		return view;
	}
	
	//Ajax 전용
	@RequestMapping("/hr/ajax/employees")
	public void getAllEmployees(HttpServletResponse response) {
		
		List<EmployeesVO> allEmployees = indexService.getAllEmployees();
		
		StringBuffer  employeesInfo = new StringBuffer();
		for (EmployeesVO employeesVO : allEmployees) {
			employeesInfo.append(employeesVO.getLastName() + "<br/>");
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			out.write(employeesInfo.toString());
			out.flush();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e); 
		}
		finally {
			if(out != null) {
				out.close();
			}
		}
	}

	//JSON 전용
	@RequestMapping("/hr/ajax/json/employees")
	@ResponseBody //객체를 쓸때만 적어준다!!
	public List<EmployeesVO> getAllEmployeesJSON() {
		return indexService.getAllEmployees();
	}
}
