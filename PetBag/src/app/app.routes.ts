import { RouterModule, Routes } from '@angular/router';
import { CheckinComponent } from '../checkin/checkin-component';
import { NgModule } from '@angular/core';
import { LoginComponent } from '../login/login-component';
import { HomeComponent } from '../home/home-component';
import { CheckoutComponent } from '../checkout/checkout-component';
import { UpdatePetComponent } from '../update-pet/update-pet-component';
import { DeletePetComponent } from '../delete-pet/delete-pet-component';
import { GetPetComponent } from '../get-pet/get-pet-component';
import { CleaningComponent } from '../cleaning/cleaning-component';

export const routes: Routes = [
    { path: 'checkin', component: CheckinComponent},
    {path: '', component: HomeComponent},
    {path: 'checkout', component: CheckoutComponent},
     { path: 'login', component: LoginComponent},
     {path: 'update', component: UpdatePetComponent},
     {path: 'delete', component: DeletePetComponent},
     {path: 'get', component: GetPetComponent},
     {path: 'cleaning', component: CleaningComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }