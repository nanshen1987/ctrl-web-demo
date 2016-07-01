package com.focus.ctrl.demo.web.reqmap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focus.ctrl.demo.model.Owner;
import com.focus.ctrl.demo.service.OwnerService;

@Controller
public class OwnerController {
	@Autowired
	private OwnerService ownerService;

	@RequestMapping(value = "/owners/{ownerId}", method = RequestMethod.GET)
	public String findOwner(@PathVariable String ownerId, Model model) {
		Owner owner = ownerService.findOwner(ownerId);
		model.addAttribute("owner", owner);
		return "displayOwner";
	}

	// @RequestMapping(value = "/owners/{ownerId}", method = RequestMethod.GET)
	// public String findOwner(@PathVariable("ownerId") String theOwner,
	// Model model) {
	// Owner owner = ownerService.findOwner(theOwner);
	// model.addAttribute("owner", owner);
	// return "displayOwner";
	// }

	// @RequestMapping(value = "/owners/{ownerId}/pets/{petId}", method =
	// RequestMethod.GET)
	// public String findPet(@PathVariable String ownerId,
	// @PathVariable String petId, Model model) {
	// Owner owner = ownerService.findOwner(ownerId);
	// Pet pet = owner.getPet(petId);
	// model.addAttribute("pet", pet);
	// return "displayPet";
	// }

	// @RequestMapping(value = "/owners/{ownerId}/pets/{petId}", method =
	// RequestMethod.GET)
	// public String findPet(@PathVariable Map<String, String> params, Model
	// model) {
	// Owner owner = ownerService.findOwner(params.get("ownerId"));
	// Pet pet = owner.getPet(params.get("petId"));
	// return "displayPet";
	// }

	// GET /owners/42;q=11/pets/21;q=22
	// @RequestMapping(value = "/owners/{ownerId}/pets/{petId}", method =
	// RequestMethod.GET)
	// public void findPet(
	// @MatrixVariable(value = "q", pathVar = "ownerId") int q1,
	// @MatrixVariable(value = "q", pathVar = "petId") int q2) {
	// // q1 == 11
	// // q2 == 22
	// System.out.println();
	// }
	// GET /owners/42;q=11;r=12/pets/21;q=22;s=23
	@RequestMapping(value = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
	public void findPet(@MatrixVariable Map<String, String> matrixVars,
			@MatrixVariable(pathVar = "petId") Map<String, String> petMatrixVars) {
		// matrixVars: ["q" : [11,22], "r" : 12, "s" : 23]
		// petMatrixVars: ["q" : 11, "s" : 23]
		System.out.println();
	}

	// GET /pets/42;q=11;r=22
	// @RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET)
	// public void findPet(@PathVariable String petId, @MatrixVariable int q) {
	// // petId == 42
	// // q == 11
	// System.out.println();
	// }
	// GET /pets/42
	@RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET)
	public void findPet(
			@MatrixVariable(required = true, defaultValue = "1") int q) {
		// q == 1
		System.out.println();
	}
}
