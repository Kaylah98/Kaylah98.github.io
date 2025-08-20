import { HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Dog } from "../model/Dog";
import { Cat } from "../model/Cat";
import { Pet } from "../model/Pet";

@Injectable({
    providedIn: 'root'
})
export class PetService {
// url for Spring Boot
private baseUrl = "http://localhost:8082";

    constructor(private http: HttpClient){}

    checkPetIn(data: any): Observable<any>{
        const endPoint = 'checkin';
        return this.http.post(this.baseUrl + endPoint, data);
    }

   getDogData(data: any): Observable<any>{
        const endPoint = 'dog';
        return this.http.get(this.baseUrl + endPoint, data);
    }

    getAllDogDocuments(): Observable<Dog[]> {
            const endPoint = 'dogs';
            return this.http.get<Dog[]>(this.baseUrl + endPoint);
    }

    getAllCatDocuments(): Observable<Cat[]> {
            const endPoint = 'cats';
            return this.http.get<Cat[]>(this.baseUrl + endPoint);
    }

    checkoutPet(data: any, petgroom: string): Observable<any> {
        const endPoint = 'checkout';
        return this.http.post<Pet>(this.baseUrl + endPoint, data);
    }

    updatePet(data: any): Observable<HttpResponse<any>>{
        const endPoint = 'update';
        return this.http.put<any>(this.baseUrl + endPoint, data);
    }

    deletePet(data: any): Observable<any>{
        const endPoint = 'delete';
        return this.http.delete<any>(this.baseUrl + endPoint, data);
    }
}