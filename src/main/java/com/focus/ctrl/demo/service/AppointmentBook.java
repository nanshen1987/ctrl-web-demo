package com.focus.ctrl.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.focus.ctrl.demo.model.Appointment;

@Service
public class AppointmentBook {
	private static Map<String, Appointment> appointments = new HashMap<String, Appointment>();
	static {
		Date date = new Date();
		for (int i = 0; i < 10; i++) {
			Appointment appointment = new Appointment();
			appointment.setAge(10 + i);
			appointment.setName("Beauty" + i);
			appointment.setEvent("Watch Film");
			appointment.setDesc("A happy day!");
			appointment.setDate(new Date(date.getTime() + i * 24 * 60 * 60
					* 1000));
			appointments.put("Beauty" + i, appointment);
		}
		for (int i = 0; i < 10; i++) {
			Appointment appointment = new Appointment();
			appointment.setAge(10 + i);
			appointment.setName("Beast" + i);
			appointment.setEvent("Play football");
			appointment.setDesc("A tough day!");
			appointment.setDate(new Date(date.getTime() + i * 24 * 60 * 60
					* 1000));
			appointments.put("Beast" + i, appointment);
		}
	}

	public Map<String, Appointment> getAppointmentsForToday() {
		Date date = new Date();
		return getAppointmentsForDay(date);
	}

	public Map<String, Appointment> getAppointmentsForDay(Date day) {
		Map<String, Appointment> result = new HashMap<String, Appointment>();
		for (Map.Entry<String, Appointment> entry : appointments.entrySet()) {
			Appointment appointment = entry.getValue();
			if (day.getDay() == appointment.getDate().getDay()) {
				result.put(entry.getKey(), appointment);
			}
		}
		return result;
	}

	public void addAppointment(Appointment appointment) {
		appointments.put(appointment.getName(), appointment);
	}
}
