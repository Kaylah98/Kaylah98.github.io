import { Component } from '@angular/core';
import { DashboardComponent } from '../dashboard/dashboard-component';
import { Dog } from '../model/Dog';
import { Cat } from '../model/Cat';
import { Router } from '@angular/router'
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DogService } from '../service/DogService';
import { Owner } from '../model/Owner';
import { CatService } from '../service/CatService';



@Component({
  selector: 'app-update-pet-component',
  imports: [DashboardComponent, FormsModule, CommonModule],
  templateUrl: './update-pet-component.html',
  styleUrl: './update-pet-component.css'
})
export class UpdatePetComponent {


  submitted: boolean = false;
  showErrorMessage: boolean = false;
  data: any;

  // values from HTML page
  pet = { dogcat: '', groomdog: '', petid: '', petname: '', petweight: 0, petage: 0, petstay: 1, yesno: '', petbreed: ''};

  constructor(private dogService: DogService, private router: Router, private catService: CatService){}

    // submits form to update pet info
    onSubmit(){
      if (this.pet.dogcat == "Dog"){
        
    const dog = new Dog(new Owner('', '', false, true), this.pet.petname, this.pet.petbreed, this.pet.petage, true, this.pet.petweight,
      this.pet.petstay, true);
    dog.setId(this.pet.petid);
    this.dogService.updateDog(dog).subscribe({
      next: (response) => {
        this.data = response
      
    
      },
      error: (err)=> {
        this.showErrorMessage = true;
      }});

      // takes user back to home page
      if(this.submitted){
          this.router.navigate(["/home"]);
      }
      
  }
  else {
    const cat = new Cat(new Owner('', '', false, true), this.pet.petname, this.pet.petbreed, this.pet.petage, true, this.pet.petweight,
      this.pet.petstay, false);
      cat.setId(this.pet.petid);
      this.catService.updateCat(cat).subscribe({
        next: (response: any) => {
          this.data = response;
          this.router.navigate(["/home"]);
        }
      })
  }
console.log("no execution");
console.log(this.pet.petid);}

}
