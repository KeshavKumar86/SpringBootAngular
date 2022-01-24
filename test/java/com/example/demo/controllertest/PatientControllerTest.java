package com.example.demo.controllertest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientService;
@RunWith(SpringRunner.class)
@SpringBootTest
class PatientControllerTest {
    @Autowired
    private PatientService service;
    @MockBean
    private PatientRepository repository;
  /*  @Test
	public void getAllPatientTest()
	{   String date_string = "26-09-1989";
    //Instantiating the SimpleDateFormat class
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
    //Parsing the given String to Date object
    Date date;
	try {
		date = formatter.parse(date_string);
		when(repository.findAll()).thenReturn(Stream.of(
				new Patient(376,"Patient",(java.sql.Date) date,34,null),new Patient(377,"Patient2",(java.sql.Date) date,34,null)).collect(Collectors.toList()));
		assertEquals(2,service.getAllPatient().size());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}      
   
		
	}*/

}
