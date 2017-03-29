package com.jueyunqi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jueyunqi.simple.entity.Employee;

@Controller
@RequestMapping("/")
public class WebController {
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String loginView(Model model)
	throws Exception
	{
		
		System.out.println("login ......");

		return "login";
	}
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	@ResponseBody
	public String loginEvent(Model model, @RequestBody Employee employee){
		System.out.println(employee.toString());
		return "success";
	}
}
