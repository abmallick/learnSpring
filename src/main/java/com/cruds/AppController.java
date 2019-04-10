package com.cruds;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cruds.beans.DoctorBean;
import com.cruds.beans.PatientBean;
import com.cruds.beans.UserBean;
import com.cruds.service.DoctorService;
import com.cruds.service.PatientService;
import com.cruds.service.UserService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@RequestMapping(value = "/greet.html", method = RequestMethod.GET)
	public String sayHello() {
		return "welcome";
	}
	
	@RequestMapping(value = "/greet.html", method = RequestMethod.POST)
	public ModelAndView processHello(@RequestParam("username") String name, @RequestParam("password") String password) {
		UserService us = new UserService();
		String type = us.authenticate(name, password);
		if(type.contentEquals("admin"))
				return new ModelAndView("admin", "USER", name);
		if(type.contentEquals("patient"))
				return new ModelAndView("patient", "USER", name);
		if(type.contentEquals("doctor")) {
				return new ModelAndView("doctor", "USER", name);
		}
		return new ModelAndView("welcome", "USER_NAME", type);
	}

	@RequestMapping(value = "/add.html", method = RequestMethod.POST)
	public String processAdmin(@RequestParam("userType") String userType, @RequestParam("userId") String userId, @RequestParam("password") String password) {
		UserService us = new UserService();
		UserBean user = new UserBean(userType, userId, password);
		us.persist(user);
		return "admin";
	}
	
	@RequestMapping(value = "/remove.html", method = RequestMethod.POST)
	public String processRemove(@RequestParam("removeId") String removeID) {
		UserService us = new UserService();
		us.delete(removeID);
		return "admin";
	}
	@RequestMapping(value = "/appoint.html", method = RequestMethod.POST)
	public ModelAndView processDoctor(@RequestParam("user") String user, @RequestParam("ailment") String ailment) {
		PatientBean patient = new PatientBean(user, user, ailment);
		PatientService ps = new PatientService();
		ps.persist(patient);
		return new ModelAndView("patient", "USER", user);
	}
}
