package com.focus.ctrl.demo.model;

import java.util.List;

public class Owner {

	private String ownerId;

	private String ownerName;

	private List<Pet> pets;

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public Pet getPet(String petId) {
		Pet pet = null;
		for (Pet p : pets) {
			if (p.getPetId().equals(petId)) {
				pet = p;
			}
		}
		return pet;
	}

}
