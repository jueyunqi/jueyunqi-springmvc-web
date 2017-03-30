package com.jueyunqi.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jueyunqi.service.EmployeeService;
import com.jueyunqi.simple.entity.Employee;

@Controller
@RequestMapping("/")
public class WebController {
	@Resource
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String loginView(Model model){
		return "login";
	}
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String loginEvent(HttpSession session, Model model, @RequestBody Employee employee)
		throws Exception
	{
		if(null == employee || null == employee.getName() || null == employee.getPasswd()){
			throw new Exception("用户信息为空！");
		}
		try {
			Long id = employeeService.addEmployee(employee);
			session.setAttribute("userId", id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
		return "index";
	}
	
	@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	public String register(Model model, @RequestBody Employee employee){
		return "login";
	}
	
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String indexView(HttpSession session, Model model)
			throws Exception
	{
		Long id = (Long) session.getAttribute("userId");
		if(null == id){
			throw new Exception("用户id不存在！");
		}
		
		Employee employee = employeeService.findById(id);
		if(null == employee){
			throw new Exception("用户信息为空！");
		}
		model.addAttribute("name", employee.getName());
		return "index";
	}
	
	@RequestMapping(value = "/link/{id}.htm", method = RequestMethod.GET)
	public String linkView(Model model,@PathVariable(value="id") Integer id){
		model.addAttribute("id", id);
		return "link";
	}
}
