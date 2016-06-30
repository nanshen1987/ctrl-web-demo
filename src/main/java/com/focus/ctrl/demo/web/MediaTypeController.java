package com.focus.ctrl.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focus.ctrl.demo.model.Pet;

@Controller
public class MediaTypeController {
	@RequestMapping(value = "/media/pets", method = RequestMethod.POST, consumes = "application/json")
	public void addPet(@RequestBody Pet pet, Model model) {
		// implementation omitted
		System.out.println();
	}
}
