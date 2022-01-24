package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
	

}
