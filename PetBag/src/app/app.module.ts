import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { AppRoutingModule } from "./app.routes";
import {provideHttpClient } from "@angular/common/http";
import { CommonModule } from "@angular/common";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";


@NgModule({
  declarations: [
    ],
    
    imports: [
    BrowserModule,
    AppRoutingModule,
    NgModule,
    FormsModule,
    ReactiveFormsModule
    
     
  ],
  providers: [provideHttpClient()],
  bootstrap: []
})
export class AppModule { }
