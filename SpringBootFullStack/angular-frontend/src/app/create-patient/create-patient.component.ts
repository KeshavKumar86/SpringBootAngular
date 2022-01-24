import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css']
})
export class CreatePatientComponent implements OnInit {
doctors:Doctor[];
patient:Patient;
d :Doctor=new Doctor();

 
  constructor(private doctorService:DoctorService,private patientService:PatientService,
    private router:Router) {
    this.doctors=[];
    this.patient=new Patient();
    this.patient.doctor=new Doctor();
   }

  ngOnInit(): void 
  {
    this.getDoctors();
  }
  //to get list of doctors
  getDoctors()
  {
    this.doctorService.getDoctorList().subscribe(data=>{
      this.doctors=data;
     
    })
  }
  //to fetch details of doctor selected from list
  getSelectedDoctor()
  {
    this.doctorService.getDoctorByName(this.patient.doctor.name).subscribe(data=>{
     // this.patient.doctor=data;
     //console.log(data);
     this.d=data;
     //console.log(this.d);
     this.patient.doctor.dId=this.d.dId;
     this.patient.doctor.name=this.d.name;
     this.patient.doctor.age=this.d.age;
     this.patient.doctor.gender=this.d.gender;
     this.patient.doctor.specialist=this.d.specialist
     console.log(this.patient.doctor )
     this.savePatient();
    


    })
  }
  //invoke on submit of form
  onSubmit()
  {  
    
     this.getSelectedDoctor();
     //console.log(this.patient);
     //console.log(this.patient.doctor);
     
   //this.d=this.patient.doctor;
   //console.log(this.d);

  }
  //to navigate to patient-details
  goToPatientDetail()
  {
    this.router.navigate(['/patient-details',this.patient.pId]);
  }
  //to save the patient in the database
  savePatient()
  {
    this.patientService.addPatient(this.patient).subscribe(data=>
      {
        console.log(data);
        this.goToPatientDetail();
       
      });
  }
  


}
