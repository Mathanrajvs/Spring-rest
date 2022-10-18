package com.doctorapp.service;

import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//import java.util.stream.Collectors;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.model.Doctor;
import com.doctorapp.util.DoctorDetails;

@Service
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
	DoctorDetails dotorDetails;

	@Override
	public Doctor getById(int doctorId) {

		return dotorDetails.getDoctors().stream().filter((doctor) -> doctor.getDoctotId() == doctorId).findAny().get();
	}

	@Override
	public List<Doctor> getAllDoctors() {
		return dotorDetails.getDoctors().stream().collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpeciality(String speciality) {
		return dotorDetails.getDoctors().stream()
				.filter((doctor) -> doctor.getSpeciality().equalsIgnoreCase(speciality)).sorted((doctor1, doctor2) -> {
					return doctor1.getDoctName().compareTo(doctor2.getDoctName());
				}).collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityAndFees(String speciality, double fees) {
		return dotorDetails.getDoctors().stream()
				.filter((doctor) -> doctor.getSpeciality().equalsIgnoreCase(speciality) && doctor.getFees() == fees)
				.sorted((doctor1, doctor2) -> {
					return doctor1.getDoctName().compareTo(doctor2.getDoctName());
				}).collect(Collectors.toList());
	}

	@Override
	public List<Doctor> getBySpecialityName(String speciality, String name) {
		return dotorDetails.getDoctors().stream().filter((doctor) -> doctor.getSpeciality().equalsIgnoreCase(speciality)
				&& doctor.getDoctName().equalsIgnoreCase(name)).sorted((doctor1, doctor2) -> {
					return doctor1.getDoctName().compareTo(doctor2.getDoctName());
				}).collect(Collectors.toList());
	}

}
