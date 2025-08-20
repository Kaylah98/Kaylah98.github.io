import { Component } from '@angular/core';
import { DashboardComponent } from '../dashboard/dashboard-component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { Cage } from '../model/Cage';
import { CageService } from '../service/CageService';

@Component({
  selector: 'app-cleaning-component',
  imports: [DashboardComponent, FormsModule, CommonModule],
  templateUrl: './cleaning-component.html',
  styleUrl: './cleaning-component.css'
})
export class CleaningComponent {

  constructor(private cageService: CageService, private router: Router){}
    showErrorMessage: boolean = false;
    response: any;

    cage: Cage = {
    cageNumber: 0,
    isCageReady: true
    }

    submitted: boolean = false;
    submittedReady: boolean = false;
    isCageReady: boolean = false;

    // submits form to PetService class
  updateCleanCage() {
    this.cageService.cleanCage(this.cage).subscribe(
      (data: HttpResponse<any>) => {
        console.log("successfully submitted!");
        this.submitted = true;
        
      },
      (error) => {
        this.showErrorMessage = true;
        console.log("this message shows theres an error");
        
      }
    );
    // takes user back to home page
    if (this.submitted){
        this.router.navigate(["/home"]);
    }
  
}

// lets user submit if cage is ready
cageStatus(){
  this.cageService.updateCageStatus(this.cage.isCageReady).subscribe(
    (data: HttpResponse<any>) => {
      console.log("successfully submitted");
      this.submittedReady = true;
      
    },
    (error) => {
      this.showErrorMessage = true;
      console.log("this message shows theres an error");
    });

    if (this.submittedReady){
      this.router.navigate(["/home"]);
    }
  
}
}
