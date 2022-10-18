package com.doctorapp.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doctorapp.model.Doctor;
import com.doctorapp.service.IDoctorService;
@RestController
public class DoctorController {
	@Autowired
	IDoctorService doctorService;
	
	
public void setDoctorService(IDoctorService doctorService) {
		this.doctorService = doctorService;
	}
	//	https://localhost:8080/doctors/speciality/ORTHO
	@GetMapping("/doctors/speciality/{speciality}")
	List<Doctor> getBySpeciality(@PathVariable("speciality")String speciality){
		return doctorService.getBySpeciality(speciality);
	}

//	https://localhost:8080/doctors/doctorId?doctorId=1
	@RequestMapping(value="/doctors/doctorId",method=RequestMethod.GET)
	Doctor getById(@RequestParam("doctorId") int doctorId) {
		return doctorService.getById(doctorId);
	}
//	https://localhost:8080/doctors/
	@GetMapping("/doctors")
	List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
//	https://localhost:8080/doctors/speciality/ORTHO/fees/1100
	@GetMapping("/doctors/speciality/{speciality}/fees/{fees}")
	List<Doctor> getBySpecialityAndFees(@PathVariable("speciality") String speciality,@PathVariable("fees") double fees){
		return doctorService.getBySpecialityAndFees(speciality, fees);
	}
	
//	https://localhost:8080/doctors/speciality/ORTHO/name/Kevin
	@GetMapping("/doctors/speciality/{speciality}/name/{name}")
	List<Doctor> getBySpecialityName(@PathVariable("speciality")String speciality,@PathVariable("name")String name){
		return doctorService.getBySpecialityName(speciality, name);
	}
}
