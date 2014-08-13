package com.aab.otocare.model;

public class ReminderModel {
	String idRemind, nameRemind, descRemind;

	public ReminderModel (String idRemind, String nameRemind, String descRemind) {
		this.idRemind = idRemind;
		this.nameRemind = nameRemind;
		this.descRemind = descRemind;
	}

	public String getIdRemind() {
		return idRemind;
	}

	public void setIdRemind(String idRemind) {
		this.idRemind = idRemind;
	}

	public String getNameRemind() {
		return nameRemind;
	}

	public void setNameRemind(String nameRemind) {
		this.nameRemind = nameRemind;
	}

	public String getDescRemind() {
		return descRemind;
	}

	public void setDescRemind(String descRemind) {
		this.descRemind = descRemind;
	}
}
