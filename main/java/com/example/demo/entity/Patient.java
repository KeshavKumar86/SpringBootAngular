package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity

public class Patient {
	@Id
private int pId;
	private String name;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	private Date dateOfVisit;
	private int age;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="d_id",referencedColumnName="dId")
	@JsonBackReference
	private Doctor doctor;
	
	
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(int pId, String name, Date dateOfVisit, int age, Doctor doctor) {
		super();
		this.pId = pId;
		this.name = name;
		this.dateOfVisit = dateOfVisit;
		this.doctor = doctor;
		this.age=age;
		this.doctor.numberOfPatientAttended+=1;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(Date dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
