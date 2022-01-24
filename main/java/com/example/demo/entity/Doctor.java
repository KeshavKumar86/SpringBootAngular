package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Doctor {
	@Id
private int dId;
private String name;
private int age;
private String gender;
private String specialist;
int numberOfPatientAttended;
@OneToMany(mappedBy="doctor")
@JsonManagedReference
private List<Patient> patients;


public Doctor() {
	super();
	// TODO Auto-generated constructor stub
}
public Doctor(int dId, String name, int age, String gender, String specialist,int numberOfPatientAttended, List<Patient> patients) {
	super();
	this.dId = dId;
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.specialist = specialist;
	this.numberOfPatientAttended=numberOfPatientAttended;
	this.patients = patients;
}
public int getdId() {
	return dId;
}
public void setdId(int dId) {
	this.dId = dId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getSpecialist() {
	return specialist;
}
public void setSpecialist(String specialist) {
	this.specialist = specialist;
}

public int getNumberOfPatientAttended() {
	return numberOfPatientAttended;
}
public void setNumberOfPatientAttended(int numberOfPatientAttended) {
	this.numberOfPatientAttended = numberOfPatientAttended;
}
public List<Patient> getPatients() {
	return patients;
}
public void setPatients(List<Patient> patients) {
	this.patients = patients;
}


}
