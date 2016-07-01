package com.focus.ctrl.demo.web.reqmap;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focus.ctrl.demo.model.Appointment;
import com.focus.ctrl.demo.service.AppointmentBook;

@Controller
@RequestMapping("/appointments")
public class AppointmentsController {
	// @InitBinder
	// public void dataBinder(WebDataBinder binder) {
	// DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	// PropertyEditor propertyEditor = new CustomDateEditor(dateFormat, true);
	// // 第二个参数表示是否允许为空
	// binder.registerCustomEditor(Date.class, propertyEditor);
	// }

	@Autowired
	private AppointmentBook appointmentBook;

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Appointment> get() {
		return appointmentBook.getAppointmentsForToday();
	}

	@RequestMapping(value = "/{day}", method = RequestMethod.GET)
	public Map<String, Appointment> getForDay(
			@PathVariable @DateTimeFormat(iso = ISO.DATE) Date day, Model model) {
		return appointmentBook.getAppointmentsForDay(day);
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public Appointment getNewForm(Model model) {
		return new Appointment();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String add(@Validated Appointment appointment, BindingResult result) {
		if (result.hasErrors()) {
			return "appointments/new";
		}
		appointmentBook.addAppointment(appointment);
		return "redirect:/appointments";
	}

	@ModelAttribute
	public void addDefaultVal(Model model) {
		model.addAttribute("message", "@ModelAttribute Method add Message");
		System.out.println();
	}

	@ModelAttribute
	public Appointment addModelInAnotherWay() {
		/**
		 * Appointment appointment = new Appointment(); appointment.setAge(1);
		 * appointment.setDate(new Date()); appointment.setDesc("desc");
		 * appointment.setEvent("event"); appointment.setName("name"); return
		 * appointment;
		 **/
		return new Appointment();
	}
}
