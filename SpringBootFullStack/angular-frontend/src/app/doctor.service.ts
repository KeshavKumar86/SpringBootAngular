import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Doctor} from './doctor'

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private url="http://localhost:9090/doctor/getalldoctor"
  private url1="http://localhost:9090/doctor/adddoctor";
  private url2="http://localhost:9090/doctor/getdoctorbyname";
  private dUrl="http://localhost:9090/doctor/deletedoctor";
  constructor(private httpClient:HttpClient) { }

  getDoctorList():Observable<Doctor[]>
  {
    return this.httpClient.get<Doctor[]>(`${this.url}`);
  }

createDoctor(doctor:Doctor):Observable<Object>
{
  return this.httpClient.post(`${this.url1}`,doctor);
}
getDoctorByName(name:string):Observable<Doctor>
{
  return this.httpClient.get<Doctor>(`${this.url2}/${name}`);
}

deleteDoctor(id:number):Observable<Object>
{
  return this.httpClient.delete(`${this.dUrl}/${id}`);
}

}
