package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.DoctorService;

@RestController
@CrossOrigin()
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	
	@RequestMapping(method=RequestMethod.POST,value="/adddoctor")
	public void addDoctor(@RequestBody Doctor doctor)
	{
		doctorService.addDoctor(doctor);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getalldoctor")
	@ResponseBody
	public List<Doctor> getAllDoctor()
	{
		return doctorService.getAllDoctor();
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET,value="/getdoctorbyid/{id}")
	@ResponseBody
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int id)
	{
		Doctor doctor= doctorService.getDoctorById(id)
				.orElseThrow(()-> new ResourceNotFoundException
						("Doctor not exist with id"+id));
		return ResponseEntity.ok(doctor);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getdoctorbyname/{name}")
	
	public Doctor getDoctorByName(@PathVariable String name)
	{
		Doctor doctor= doctorService.getDoctorByName(name);
		
		doctor.setNumberOfPatientAttended(doctorService.numberOfPatient(name));
		return doctor;
	}
	
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deletedoctor/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteDoctor(@PathVariable int id)
	{
		doctorService.deleteDoctor(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("delete",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	

	public DoctorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}

	public DoctorService getDoctorService() {
		return doctorService;
	}

	public void setDoctorService(DoctorService doctorService) {
		this.doctorService = doctorService;
	}
	
	

}
