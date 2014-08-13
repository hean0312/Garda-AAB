package com.aab.otocare.model;

public class LocationDetailsModel {
	String idPlace, namePlace, addressPlace, phonePlace, websitePlace, jumRating, totRating, jumReview, lastReview, picPlace, picMarker;
	double longitudePlace, latitudePlace, distance;
	
	public LocationDetailsModel(String idPlace, String namePlace, String addressPlace, String phonePlace, String websitePlace, String jumRating, String totRating, String jumReview, String lastReview, String picPlace, String picMarker, double longitudePlace, double latitudePlace, double distance) {
		this.idPlace = idPlace;
		this.namePlace = namePlace;
		this.addressPlace = addressPlace;
		this.phonePlace = phonePlace;
		this.websitePlace = websitePlace;
		this.jumRating = jumRating;
		this.totRating = totRating;
		this.jumReview = jumReview;
		this.lastReview = lastReview;
		this.picPlace = picPlace;
		this.picMarker = picMarker;
		this.longitudePlace = longitudePlace;
		this.latitudePlace = latitudePlace;
		this.distance = distance;
		
		
	}

	public String getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(String idPlace) {
		this.idPlace = idPlace;
	}

	public String getNamePlace() {
		return namePlace;
	}

	public void setNamePlace(String namePlace) {
		this.namePlace = namePlace;
	}

	public String getAddressPlace() {
		return addressPlace;
	}

	public void setAddressPlace(String addressPlace) {
		this.addressPlace = addressPlace;
	}

	public String getPhonePlace() {
		return phonePlace;
	}

	public void setPhonePlace(String phonePlace) {
		this.phonePlace = phonePlace;
	}

	public String getWebsitePlace() {
		return websitePlace;
	}

	public void setWebsitePlace(String websitePlace) {
		this.websitePlace = websitePlace;
	}

	public String getJumRating() {
		return jumRating;
	}

	public void setJumRating(String jumRating) {
		this.jumRating = jumRating;
	}

	public String getTotRating() {
		return totRating;
	}

	public void setTotRating(String totRating) {
		this.totRating = totRating;
	}

	public String getJumReview() {
		return jumReview;
	}

	public void setJumReview(String jumReview) {
		this.jumReview = jumReview;
	}

	public String getLastReview() {
		return lastReview;
	}

	public void setLastReview(String lastReview) {
		this.lastReview = lastReview;
	}

	public String getPicPlace() {
		return picPlace;
	}

	public void setPicPlace(String picPlace) {
		this.picPlace = picPlace;
	}

	public String getPicMarker() {
		return picMarker;
	}

	public void setPicMarker(String picMarker) {
		this.picMarker = picMarker;
	}

	public double getLongitudePlace() {
		return longitudePlace;
	}

	public void setLongitudePlace(double longitudePlace) {
		this.longitudePlace = longitudePlace;
	}

	public double getLatitudePlace() {
		return latitudePlace;
	}

	public void setLatitudePlace(double latitudePlace) {
		this.latitudePlace = latitudePlace;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
