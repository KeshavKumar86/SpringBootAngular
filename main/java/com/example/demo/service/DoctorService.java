package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	
	public String addDoctor(Doctor doctor)
	{
		doctorRepository.save(doctor);
		return doctor.getName()+" added successfully";
	}
	
	public List<Doctor> getAllDoctor()
	{
		return doctorRepository.findAll();
	}
	
	public Optional<Doctor> getDoctorById(int id)
	{
		return doctorRepository.findById(id);
	}
	
	public Doctor getDoctorByName(String name)
	{
		return doctorRepository.getDoctorByName(name);
	}
	public int numberOfPatient(String name)
	{   System.out.println(doctorRepository.numberOfPatient(name));
		return doctorRepository.numberOfPatient(name);
	}
	public void deleteDoctor(int id)
	{
		doctorRepository.deleteById(id);
	}
	
	
	

	public DoctorService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorService(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}

	public DoctorRepository getDoctorRepository() {
		return doctorRepository;
	}

	public void setDoctorRepository(DoctorRepository doctorRepository) {
		this.doctorRepository = doctorRepository;
	}
	
	
	

}
