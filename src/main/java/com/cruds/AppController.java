package com.cruds;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cruds.beans.DoctorBean;
import com.cruds.beans.UserBean;
import com.cruds.service.DoctorService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@RequestMapping(value = "/greet.html", method = RequestMethod.GET)
	public String sayHello() {
		return "welcome";
	}
	
	@RequestMapping(value = "/greet.html", method = RequestMethod.POST)
	public ModelAndView processHello(@RequestParam("username") String name, @RequestParam("type") String type, @RequestParam("password") String password) {
		UserBean user = new UserBean(type, name, password);
		if(type.contentEquals("admin"))
			return new ModelAndView("admin", "USER", name);
		if(type.contentEquals("patient"))
			return new ModelAndView("patient", "USER", name);
		if(type.contentEquals("doctor")) {
			DoctorService doc = new DoctorService();
			if(doc.authenticate(name, password))
				return new ModelAndView("doctor", "USER", name);
		}
		return new ModelAndView("welcome", "USER_NAME", user);
	}

	@RequestMapping(value = "/admin.html", method = RequestMethod.POST)
	public String processAdmin(@RequestParam("action") String action) {
		if(action.equals("add")) {
			return "adduser";
		}
		if(action.equals("remove")) {
			return "removeuser";
		}
		if(action.equals("schedule")) {
			return "adduser";
		}
		
		return "error";
	}
	
	@RequestMapping(value="/doctor.html", method = RequestMethod.POST)
	public String processDoctor(@RequestParam("user") String name) {
		return "appoint";
	}
}
