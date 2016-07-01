package com.focus.ctrl.demo.web.reqmap;

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

	// @RequestMapping(value = "/media/pets/{petId}", method =
	// RequestMethod.GET, produces = "application/json")
	// @ResponseBody
	// public Pet getPet(@PathVariable String petId, Model model) {
	// // implementation omitted
	// System.out.println();
	// return null;
	// }
}
