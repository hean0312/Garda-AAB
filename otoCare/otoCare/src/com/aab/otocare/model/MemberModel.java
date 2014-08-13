package com.aab.otocare.model;

public class MemberModel {
	String name, email, telephoneNumber, homeAddress, DOB, simExpiredDate, policeNumber, vehicleBrand, vehicleType, vehicleYear, chassisNumber, engineNumber, stnkExpiredDate, policyNumber, insuranceName, policyPeriodFrom, policyPeriodTo, coverage;
	
	public MemberModel(String name, String email, String telephoneNumber, String homeAddress, String DOB, String simExpiredDate, String policeNumber, String vehicleBrand, String vehicleType, String vehicleYear, String chassisNumber, String engineNumber, String stnkExpiredDate, String policyNumber, String insuranceName, String policyPeriodFrom, String policyPeriodTo, String coverage) {
		this.name = name;
		this.email = email;
		this.telephoneNumber = telephoneNumber;
		this.homeAddress = homeAddress;
		this.DOB = DOB;
		this.simExpiredDate = simExpiredDate;
		this.policeNumber = policeNumber;
		this.vehicleBrand = vehicleBrand;
		this.vehicleType = vehicleType;
		this.vehicleYear = vehicleYear;
		this.chassisNumber = chassisNumber;
		this.engineNumber = engineNumber;
		this.stnkExpiredDate = stnkExpiredDate;
		this.policyNumber = policyNumber;
		this.insuranceName = insuranceName;
		this.policyPeriodFrom = policyPeriodFrom;
		this.policyPeriodTo = policyPeriodTo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getSimExpiredDate() {
		return simExpiredDate;
	}

	public void setSimExpiredDate(String simExpiredDate) {
		this.simExpiredDate = simExpiredDate;
	}

	public String getPoliceNumber() {
		return policeNumber;
	}

	public void setPoliceNumber(String policeNumber) {
		this.policeNumber = policeNumber;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getStnkExpiredDate() {
		return stnkExpiredDate;
	}

	public void setStnkExpiredDate(String stnkExpiredDate) {
		this.stnkExpiredDate = stnkExpiredDate;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getPolicyPeriodFrom() {
		return policyPeriodFrom;
	}

	public void setPolicyPeriodFrom(String policyPeriodFrom) {
		this.policyPeriodFrom = policyPeriodFrom;
	}

	public String getPolicyPeriodTo() {
		return policyPeriodTo;
	}

	public void setPolicyPeriodTo(String policyPeriodTo) {
		this.policyPeriodTo = policyPeriodTo;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
}
