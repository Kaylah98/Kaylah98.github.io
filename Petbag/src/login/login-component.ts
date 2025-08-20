
import { Component} from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpResponse } from '@angular/common/http';
import { LoginService } from '../service/LoginService';



@Component({
  selector: 'app-login-component',
  imports: [FormsModule, CommonModule],
  templateUrl: './login-component.html',
  styleUrl: './login-component.css'
})
export class LoginComponent {
    
    showErrorMessage: boolean = false;
    submitted: boolean = false;
    userInfo: any;
    loginInfo = {
      uname: '',
      password: '' 
  }
    
  constructor(private loginService: LoginService, private router: Router){}

 
  
 
  // submits form to PetService class
  onSubmit() {
    this.loginService.login(this.loginInfo).subscribe(
      (response: HttpResponse<any>) => {
        this.userInfo = response;
        this.submitted = true;
        
      },
      (error) => {
        this.showErrorMessage = true;
        console.log("this message shows theres an error")
        
      }
    );
  
}

    
  
  // sends user to home page
    goToHomePage(){
    if (this.submitted) {
      console.log("complete");
    this.router.navigate(['/home']);
  }
  }
  
 }
