package com.focus.ctrl.demo.model;

import java.io.Serializable;

public class Pet implements Serializable {

	public Pet() {
		super();
	}

	private String petId;

	private String cls;

	private String petName;

	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

}
