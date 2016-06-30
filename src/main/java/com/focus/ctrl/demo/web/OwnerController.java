package com.focus.ctrl.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focus.ctrl.demo.model.Owner;
import com.focus.ctrl.demo.model.Pet;
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

	@RequestMapping(value = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
	public String findPet(@PathVariable String ownerId,
			@PathVariable String petId, Model model) {
		Owner owner = ownerService.findOwner(ownerId);
		Pet pet = owner.getPet(petId);
		model.addAttribute("pet", pet);
		return "displayPet";
	}

	// @RequestMapping(value = "/owners/{ownerId}/pets/{petId}", method =
	// RequestMethod.GET)
	// public String findPet(@PathVariable Map<String, String> params, Model
	// model) {
	// Owner owner = ownerService.findOwner(params.get("ownerId"));
	// Pet pet = owner.getPet(params.get("petId"));
	// model.addAttribute("pet", pet);
	// return "displayPet";
	// }
}
