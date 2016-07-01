package com.focus.ctrl.demo.web.reqmap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HeaderController {
	// @RequestMapping(value = "/header/pets/{petId}", method =
	// RequestMethod.GET, params = "myParam=myValue")
	// public void findPet(@PathVariable String petId, Model model) {
	// // implementation omitted
	// System.out.println();
	// }

	@RequestMapping(value = "/header/pets/{petId}", method = RequestMethod.GET, headers = "myHeader=myValue")
	public void findPet(@PathVariable String petId, Model model) {
		// implementation omitted
		System.out.println();
	}
}
