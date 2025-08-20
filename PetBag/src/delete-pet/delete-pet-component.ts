import { Component } from '@angular/core';
import { DashboardComponent } from '../dashboard/dashboard-component';
import { HttpResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { DogService } from '../service/DogService';
import { CatService } from '../service/CatService';

@Component({
  selector: 'app-delete-pet-component',
  imports: [DashboardComponent, FormsModule, CommonModule],
  templateUrl: './delete-pet-component.html',
  styleUrl: './delete-pet-component.css'
})
export class DeletePetComponent {

  showErrorMessage: boolean = false;
    submitted: boolean = false;
    userInfo: any;
    responseData: any;


  // values from HTML page
  pet = { isDog: '', petid: '', optionsyesno: ''};
    
  constructor(private dogService: DogService, private catService: CatService, private router: Router){}
  
  // deletes pet from database
  deletePet(){
    if (this.pet.optionsyesno == "no"){
      return;
    }
    console.log(this.pet.petid);
    if (this.pet.isDog == 'yes'){
    this.dogService.deleteDog(this.pet.petid).subscribe(
    (response: HttpResponse<string>) => {
        this.responseData = response.body;
        console.log(this.responseData);
        this.router.navigate(["/home"]);
        
      },
        error  => {
          this.showErrorMessage = true;
          console.error("error...aww", error.status);
        });
      
    }
else {
  this.catService.deleteCat(this.pet.petid).subscribe(
   (response: HttpResponse<string>) => {
        this.responseData = response.body;
        console.log(this.responseData);
        this.router.navigate(["/home"]);
      },
        error  => {
          this.showErrorMessage = true;
          console.error("error...aww", error.status);
        });
      
    }}
}
