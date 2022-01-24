import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from '../patient';

@Component({
  selector: 'app-search-patient',
  templateUrl: './search-patient.component.html',
  styleUrls: ['./search-patient.component.css']
})
export class SearchPatientComponent implements OnInit {
id:number;

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  onSubmit(id:number)
  {
    this.router.navigate(['/patient-details',id]);
  }

}
