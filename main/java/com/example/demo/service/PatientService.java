package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
private PatientRepository patientRepository;
	
	public List<Patient> getAllPatient()
	{
		return patientRepository.findAll();
	}
	
	public Optional<Patient> getPatientById(int id)
	{
		return patientRepository.findById(id);
	}
	
	public String addPatient(Patient patient)
	{
		patientRepository.save(patient);
		return patient.getName()+" added successfully";
	}
	
	public void deletePatient(int id)
	{
		patientRepository.deleteById(id);
	}
	

	public PatientService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientService(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	public PatientRepository getPatientRepository() {
		return patientRepository;
	}

	public void setPatientRepository(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	
	
}
