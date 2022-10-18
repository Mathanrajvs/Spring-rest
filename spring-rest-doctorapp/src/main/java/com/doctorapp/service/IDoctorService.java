package com.doctorapp.service;

import java.util.List;

import com.doctorapp.model.Doctor;

public interface IDoctorService {
	
	Doctor getById(int doctorId) ;
	
	List<Doctor> getAllDoctors() ;
	List<Doctor> getBySpeciality(String speciality);
	List<Doctor> getBySpecialityAndFees(String speciality,double fees);
	List<Doctor> getBySpecialityName(String speciality,String name);
	
}
