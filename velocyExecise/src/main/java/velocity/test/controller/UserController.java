package velocity.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import velocity.test.model.User;
import velocity.test.service.UserService;


@Controller("userController")
@RequestMapping("/")
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@RequestMapping("list")
	public String getUserList(Model model){
		List<User> list=this.userService.getUserList();
		model.addAttribute("list",list);
		return "userList";
	}
	
	//测试
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config/applicationContext.xml");
		UserService userService=(UserService) context.getBean("userService");
		List<User> list=userService.getUserList();
		System.out.println(list);
	}
}
