import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateDoctorComponent } from './create-doctor/create-doctor.component';
import { CreatePatientComponent } from './create-patient/create-patient.component';
import { DoctorDetailsComponent } from './doctor-details/doctor-details.component';
import { DoctorListComponent } from './doctor-list/doctor-list.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { SearchPatientComponent } from './search-patient/search-patient.component';

const routes: Routes = [
  { path:'doctors',component:DoctorListComponent},
  { path:'create-doctor',component:CreateDoctorComponent},
  {path:'',redirectTo:'doctors',pathMatch:'full'},
  {path:'doctor-details/:name',component:DoctorDetailsComponent},
  {path:'serach-patient',component:SearchPatientComponent},
  {path:'patient-details/:id',component:PatientDetailsComponent},
  {path:'create-patient',component:CreatePatientComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
