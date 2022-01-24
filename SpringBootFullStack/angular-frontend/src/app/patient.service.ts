import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Patient} from './patient'

@Injectable({
  providedIn: 'root'
})
export class PatientService {
private url="http://localhost:9090/patient/getpatient";
private url1="http://localhost:9090/patient/addpatient";
  constructor(private httpClient:HttpClient) { }

  getPatientById(id:number):Observable<Patient>
{
  return this.httpClient.get<Patient>(`${this.url}/${id}`);
}
addPatient(patient:Patient):Observable<Object>
{
  return this.httpClient.post(`${this.url1}`,patient);
}
}
