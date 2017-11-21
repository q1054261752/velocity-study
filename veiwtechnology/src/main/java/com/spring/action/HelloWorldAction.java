package com.spring.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldAction {
	
	@RequestMapping(value="/helloworld")
	public ModelAndView hello(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("login/hello");
		modelAndView.addObject("message", "Hello,SpringMvc");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/welcome")
	public ModelAndView helloVm(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("welcome");
		modelAndView.addObject("message", "Hello,Velocity");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/free")
	public ModelAndView helloFreeMarker(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("freemarker");
		modelAndView.addObject("message", "Hello,FreeMarker");
		return modelAndView;
	}
	
}
