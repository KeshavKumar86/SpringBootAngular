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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.PatientService;

@RestController
@CrossOrigin()
@RequestMapping("/patient")
public class PatientController {
	@Autowired
private PatientService patientService;
	
	@RequestMapping(method=RequestMethod.GET,value="/getallpatient")
	public List<Patient> getAllPatient()
	{
		return patientService.getAllPatient();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getpatient/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable int id)
	{
		Patient patient=patientService.getPatientById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Patient not exist with id"+id));
		return ResponseEntity.ok(patient);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/addpatient")
	public String addPatient(@RequestBody Patient patient)
	{
		patientService.addPatient(patient);
		return patient.getName()+" added successfully";
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deletepatient/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable int id)
	{
		patientService.deletePatient(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}

	public PatientController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	

}
