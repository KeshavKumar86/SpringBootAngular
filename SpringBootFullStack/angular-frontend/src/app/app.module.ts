import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { CreateDoctorComponent } from './create-doctor/create-doctor.component';
import { FormsModule } from '@angular/forms';
import { DoctorDetailsComponent } from './doctor-details/doctor-details.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { SearchPatientComponent } from './search-patient/search-patient.component';


@NgModule({
  declarations: [
    AppComponent,
    DoctorListComponent,
    CreateDoctorComponent,
    DoctorDetailsComponent,
    CreatePatientComponent,
    PatientDetailsComponent,
    SearchPatientComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
