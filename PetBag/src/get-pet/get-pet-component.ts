import { Component } from '@angular/core';
import { DashboardComponent } from '../dashboard/dashboard-component';
import { Dog } from '../model/Dog';
import { Cat } from '../model/Cat';

import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CatService } from '../service/CatService';
import { DogService } from '../service/DogService';
import { Router } from '@angular/router';



@Component({
  selector: 'app-get-pet-component',
  imports: [DashboardComponent, FormsModule, CommonModule],
  templateUrl: './get-pet-component.html',
  styleUrl: './get-pet-component.css'
})
export class GetPetComponent {
  showErrorMessage: boolean = false;
  dogs: Dog[] = [];
  cats: Cat[] = [];
  dog?: Dog;
  cat?: Cat;
  showdogs: boolean = false;
  showcats: boolean = false;

  constructor(private dogService: DogService, private catService: CatService, private router: Router){}

  // gets all dogs from database
  getAllDogs(){


    this.dogService.getAllDogDocuments().subscribe(
      (data: Dog[]) => {
        this.dogs = data || [];
        console.log(this.dogs);
        this.showdogs = true;
        
       },
       error => {
        this.showErrorMessage = true;
        console.error("error...aww", error.status);
       }
      )
    }

  // gets all cats from database
  getAllCats(){
    this.catService.getAllCatDocuments().subscribe(
      (data: Cat[]) => {
        this.cats = data || [];
        this.showcats = true;
        
      },
      error => {
        this.showErrorMessage = true;
        console.error("error...aww", error.status);
      }
    )
  }

}

