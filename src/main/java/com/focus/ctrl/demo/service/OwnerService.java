package com.focus.ctrl.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.focus.ctrl.demo.model.Owner;
import com.focus.ctrl.demo.model.Pet;

@Service
public class OwnerService {

	private static List<Owner> owners = new ArrayList<Owner>();
	static {
		String[] cls = { "dog", "cat" };
		for (int i = 0; i < 10; i++) {
			Owner owner = new Owner();
			owner.setOwnerId(i + "");
			owner.setOwnerName("ownerName" + i);
			List<Pet> pets = new ArrayList<Pet>();
			for (int j = 0; j < 5; j++) {
				Pet pet = new Pet();
				pet.setPetId(j + "");
				pet.setCls(cls[j % 2]);
				pet.setPetName(cls[j % 2] + j);
				pets.add(pet);
			}
			owner.setPets(pets);
			owners.add(owner);
		}
	}

	public Owner findOwner(String ownerId) {
		Owner owner = null;
		for (Owner o : owners) {
			if (ownerId.equals(o.getOwnerId())) {
				owner = o;
				break;
			}
		}
		return owner;
	}
}
