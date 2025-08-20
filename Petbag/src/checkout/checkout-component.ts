import { Component } from '@angular/core';
import { DashboardComponent } from '../dashboard/dashboard-component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpResponse } from '@angular/common/http';
import { DogService } from '../service/DogService';
import { Router } from '@angular/router';
import { CatService } from '../service/CatService';

@Component({
  selector: 'app-checkout-component',
  imports: [DashboardComponent,FormsModule, CommonModule],
  templateUrl: './checkout-component.html',
  styleUrl: './checkout-component.css'
})
export class CheckoutComponent {

  constructor(private dogService: DogService, private catService: CatService, private router: Router){}
  showErrorMessage: boolean = false;
  selectdogcat: String = '';
  responseData: any;
  groompet: boolean = false;
  
  pet = {
    dogcat: '', petgroom: '',  petid: '', 
  }
  onSubmit(){
    console.log(this.pet.dogcat);
    if (this.pet.dogcat == "yes"){
      
      if (this.pet.petgroom == 'yes'){
        this.groompet = true;
      }
    this.dogService.checkoutDog(this.pet.petid, this.groompet).subscribe((response: HttpResponse<string>) => {
        this.responseData = response.body;
        console.log(this.responseData);
        this.router.navigate(["/home"]);
        return;
        
       },
       error => {
        this.showErrorMessage = true;
        console.error("error...aww", error.status);
        return;
       }
      )
    }
    else{
   
      this.catService.checkoutCat(this.pet.petid, false).subscribe((response: HttpResponse<string>) => {
        this.responseData = response.body;
        console.log(this.responseData);
        this.router.navigate(["/home"]);
        return
    }
    )}}

}
