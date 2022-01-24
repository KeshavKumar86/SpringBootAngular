import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Doctor} from '../doctor'
import { DoctorService } from '../doctor.service';

@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.css']
})
export class DoctorListComponent implements OnInit {
doctors:Doctor[];

  constructor(private doctorService: DoctorService,private router:Router) {
    this.doctors=[];
   }

  ngOnInit(): void {
   this.getDoctors();
  }
  getDoctors()
  {
    this.doctorService.getDoctorList().subscribe(data=>{
      this.doctors=data;
      console.log(this.doctors);
    })
  }


  deleteDoctor(id:number)
  {
    this.doctorService.deleteDoctor(id).subscribe(data=>{
      console.log(data);
      this.getDoctors();
    });
  }

  doctorDetails(name:string)
  {
         this.router.navigate(['/doctor-details',name]);
  }

}
