package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
	@Query("select d from Doctor d where d.name=?1")
	Doctor getDoctorByName(String name);
	@Query(value="select count(*) from doctor join patient where doctor.d_id=patient.d_id and doctor.name=?1",nativeQuery=true)
	int numberOfPatient(String name);
	

}
