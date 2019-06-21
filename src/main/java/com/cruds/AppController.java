package com.cruds;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cruds.beans.DoctorBean;
import com.cruds.beans.PatientBean;
import com.cruds.beans.ScheduleBean;
import com.cruds.beans.UserBean;
import com.cruds.service.DoctorService;
import com.cruds.service.PatientService;
import com.cruds.service.ScheduleService;
import com.cruds.service.UserService;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private PatientService patientService;
	@RequestMapping(value = "/greet.html", method = RequestMethod.GET)
	public String sayHello() {
		return "welcome";
	}
	
	@RequestMapping(value = "/greet.html", method = RequestMethod.POST)
	public ModelAndView processHello(@RequestParam("username") String name, @RequestParam("password") String password, HttpSession session) {
		UserService us = new UserService();
		String type = us.authenticate(name, password);
		if(type.contentEquals("admin")) {
			session.setAttribute("user", name);
				
				List<PatientBean> patients = patientService.listAll();
				DoctorService ds = new DoctorService();
				List<DoctorBean> doctors = ds.listAll();
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("user", name);
				params.put("patients", patients);
				params.put("doctors", doctors);
				return new ModelAndView("admin", "params", params);
		}
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
	public ModelAndView processPatient(@RequestParam("user") String user, @RequestParam("ailment") String ailment) {
		PatientBean patient = new PatientBean(user, user, ailment);
		PatientService ps = new PatientService();
		ps.persist(patient);
		return new ModelAndView("patient", "USER", user);
	}
	@RequestMapping(value = "/addSpec.html", method = RequestMethod.POST)
	public ModelAndView processDoctor(@RequestParam("user") String user, @RequestParam("specialization") String specialization) {
		DoctorBean doctor = new DoctorBean(user, user, specialization);
		DoctorService ds = new DoctorService();
		ds.persist(doctor);
		return new ModelAndView("doctor", "USER", user);
	}
	@RequestMapping(value = "/docAppoint.html", method = RequestMethod.POST)
	public ModelAndView processAppointment(@RequestParam("user") String user, @RequestParam("patient") String patient, @RequestParam("doctor") String doctor, @RequestParam("date") String date, @RequestParam("time") String time) {
		PatientService ps = new PatientService();
		PatientBean pb = ps.findById(patient);
		String ailment = pb.getAilmentDetails();
		String scheduleId = (doctor+patient).substring(0, 10);
		ScheduleBean sb = new ScheduleBean(scheduleId, date, time, doctor, patient, ailment);
		ScheduleService ss = new ScheduleService();
		ss.persist(sb);
		return new ModelAndView("admin", "USER", user);
	}
	@RequestMapping(value = "/schedule.html", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	public String processSchedule(@RequestParam("user") String user) {
		ScheduleService ss = new ScheduleService();
		ScheduleBean sb = ss.findById(user);
		Map<String, Object> params = new HashMap<String, Object>();
		return "<html><body>"+sb+"</body></html>";
	}
}
