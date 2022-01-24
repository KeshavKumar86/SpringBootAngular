import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Doctor } from '../doctor';
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrls: ['./doctor-details.component.css']
})
export class DoctorDetailsComponent implements OnInit {
name:string;
doctor:Doctor;
  constructor(private route:ActivatedRoute,private doctorService:DoctorService) { }

  ngOnInit(): void {
    this.name=this.route.snapshot.params['name'];
    this.doctor=new Doctor();
    this.doctorService.getDoctorByName(this.name).subscribe(data=>{
      this.doctor=data;
    });

  }

}
