package com.doctorapp.model;

import java.time.LocalDateTime;

public class Doctor {
	private String doctName;
	private Integer doctotId;
	private String speciality;
	private double fees;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String doctName, Integer doctotId, String speciality, double fees) {
		super();
		this.doctName = doctName;
		this.doctotId = doctotId;
		this.speciality = speciality;
		this.fees = fees;
	}
	public String getDoctName() {
		return doctName;
	}
	public void setDoctName(String doctName) {
		this.doctName = doctName;
	}
	public Integer getDoctotId() {
		return doctotId;
	}
	public void setDoctotId(Integer doctotId) {
		this.doctotId = doctotId;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Doctor [doctName=" + doctName + ", doctotId=" + doctotId + ", speciality=" + speciality + ", fees="
				+ fees + "]";
	}
	
	
}
