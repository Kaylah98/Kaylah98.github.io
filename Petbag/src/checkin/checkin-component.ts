import { Component } from '@angular/core';
import { DashboardComponent } from '../dashboard/dashboard-component';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Dog } from '../model/Dog';
import { Cat } from '../model/Cat';
import { DogService } from '../service/DogService';
import { Owner } from '../model/Owner';
import { CatService } from '../service/CatService';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-checkin-component',
  imports: [DashboardComponent, FormsModule, CommonModule],
  templateUrl: './checkin-component.html',
  styleUrl: './checkin-component.css'
})
export class CheckinComponent {

  submitted: boolean = false;
  showErrorMessage: boolean = false;
  responseData: any;
  
  // values from HTML page
  pet = { petname: '', petweight: 0, petage: 0, petbreed: '', petstay: 1, isDog: '', isGroomed: ''};
  owner = { firstName: '', lastName: ''};
  groom = false;

  constructor(private dogService: DogService, private catService: CatService, private router: Router){}

  // sends request and receives response
  onSubmit(){
    if (this.pet.isDog == 'true'){
        
      console.log("this is seen before it is sent. pet is a dog");
      if (this.pet.isGroomed == 'true'){
      this.groom = true;
      console.log("this is also seen before it is sent. groom pet is true");
    }
      const checkInOwner = new Owner(this.owner.firstName, this.owner.lastName, false, false);
      
      const dog = new Dog(checkInOwner, this.pet.petname, this.pet.petbreed, this.pet.petage, true, this.pet.petweight, this.pet.petstay, this.groom);

      console.log("owner and dog are created before check in method is executed");

      this.dogService.checkDogIn(dog).subscribe(
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
      
      const catOwner = new Owner(this.owner.firstName, this.owner.lastName, false, false);
      const cat = new Cat(catOwner, this.pet.petname, this.pet.petbreed, this.pet.petage, false, this.pet.petweight, this.pet.petstay, this.groom);
      this.catService.checkCatIn(cat).subscribe(
       (response: HttpResponse<string>) => {
        this.responseData = response.body;
        console.log(this.responseData);
        this.router.navigate(["/home"]);
        
       },
       error => {
        this.showErrorMessage = true;
        console.error("error...aww", error.status);
       }
      )
    }
  }

  }

