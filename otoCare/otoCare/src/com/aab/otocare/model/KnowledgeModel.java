package com.aab.otocare.model;

public class KnowledgeModel {
	String idKnow, urlImgKnow, nameKnow;
	
	public KnowledgeModel(String idKnow, String urlImgKnow, String nameKnow) {
		this.idKnow = idKnow;
		this.urlImgKnow = urlImgKnow;
		this.nameKnow = nameKnow;
	}

	public String getIdKnow() {
		return idKnow;
	}

	public void setIdKnow(String idKnow) {
		this.idKnow = idKnow;
	}

	public String getUrlImgKnow() {
		return urlImgKnow;
	}

	public void setUrlImgKnow(String urlImgKnow) {
		this.urlImgKnow = urlImgKnow;
	}

	public String getNameKnow() {
		return nameKnow;
	}

	public void setNameKnow(String nameKnow) {
		this.nameKnow = nameKnow;
	}

}
