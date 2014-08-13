package com.aab.otocare.model;

public class LocationModel {
	String idLoc, urlImgLoc, nameLoc;
	
	public LocationModel (String idLoc, String urlImgLoc, String nameLoc) {
		this.idLoc = idLoc;
		this.urlImgLoc = urlImgLoc;
		this.nameLoc = nameLoc;
	}

	public String getIdLoc() {
		return idLoc;
	}

	public void setIdLoc(String idLoc) {
		this.idLoc = idLoc;
	}

	public String getUrlImgLoc() {
		return urlImgLoc;
	}

	public void setUrlImgLoc(String urlImgLoc) {
		this.urlImgLoc = urlImgLoc;
	}

	public String getNameLoc() {
		return nameLoc;
	}

	public void setNameLoc(String nameLoc) {
		this.nameLoc = nameLoc;
	}
	
}
