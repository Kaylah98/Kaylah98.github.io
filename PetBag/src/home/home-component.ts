import { Component } from '@angular/core';
import { DashboardComponent } from '../dashboard/dashboard-component';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-home-component',
  imports: [RouterLink, RouterOutlet, DashboardComponent],
  templateUrl: './home-component.html',
  styleUrl: './home-component.css'
})
export class HomeComponent {

}
