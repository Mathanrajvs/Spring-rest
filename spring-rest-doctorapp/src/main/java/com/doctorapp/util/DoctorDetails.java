package com.doctorapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialization;
@Component
public class DoctorDetails {
	private List<Doctor> doctors;

	public List<Doctor> getDoctors() {
		return showDoctors();
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = showDoctors();
	}

	private List<Doctor> showDoctors() {
		return Arrays.asList(new Doctor("Rani", 1, Specialization.CARDIO.type, 1200),
				new Doctor("Kevin", 2, Specialization.ORTHO.type, 1100),
				new Doctor("Somu", 3, Specialization.PEADO.type, 120),
				new Doctor("Nirmal", 4, Specialization.CARDIO.type, 100),
				new Doctor("Ravidhra", 5, Specialization.CARDIO.type, 200));
	}
}
