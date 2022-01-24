package com.example.demo.controllertest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.service.DoctorService;
@RunWith(SpringRunner.class)
@SpringBootTest
class DoctorControllerTest {
    @Autowired
	private DoctorService service;
	@MockBean
	private com.example.demo.repository.DoctorRepository doctorRepository;
	@Test
	public void getAllDoctorTest()
	{  // List<Patient> patient=new ArrayList<>();
		when(doctorRepository.findAll()).thenReturn(Stream.of(
				new Doctor(376,"Doctor1",34,"male","physician",0,null),new Doctor(377,"Doctor2",34,"female","physician",0,null)).collect(Collectors.toList()));
		assertEquals(2,service.getAllDoctor().size());
	}
	@Test
	public void getDoctorByIdTest()
	{
		int id=500;
		//new Doctor(500,"Name",35,"male","special",0,null)
		Optional<Doctor> doctor=Optional.ofNullable(new Doctor(500,"Name",35,"male","special",0,null));
		when(doctorRepository.findById(id)).thenReturn(doctor);
		assertEquals(true,service.getDoctorById(id).isPresent());
	}
	@Test
	public void getDoctorByNameTest()
	{
		String name="Doctor1";
		Doctor doctor=new Doctor(500,"Doctor1",35,"male","special",0,null);
		when(doctorRepository.getDoctorByName(name)).thenReturn(doctor);
		assertEquals(doctor,service.getDoctorByName(name));
		
	}
	@Test
	public void addDoctorTest()
	{
		Doctor doctor=new Doctor(1000,"Doctor1000",37,"female","special",0,null);
		when(doctorRepository.save(doctor)).thenReturn(doctor);
		assertEquals("Doctor1000 added successfully",service.addDoctor(doctor));
	}
	@Test
	public void numberOfPatientTest()
	{
		int numberOfPatient=4;
		when(doctorRepository.numberOfPatient("Doctor")).thenReturn(numberOfPatient);
		assertEquals(4,service.numberOfPatient("Doctor"));
	}
	@Test
	public void deleteDoctorTest()
	{
		Doctor doctor=new Doctor(5000,"Doctor5000",35,"male","special",0,null);
		service.deleteDoctor(doctor.getdId());
		verify(doctorRepository,times(1)).deleteById(doctor.getdId());
		
	
	}

	
	


}
