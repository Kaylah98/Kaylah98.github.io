import { HttpClient, HttpParams, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { Dog } from "../model/Dog";

@Injectable({
    providedIn: 'root'
})
export class DogService{
    
    // url for Spring Boot
    private baseUrl = `http://localhost:8082`;

    constructor(private http: HttpClient){}

    checkDogIn(data: Dog): Observable<any>{
            const endPoint = '/checkindog';
            console.log("this service method is called");
            return this.http.post(this.baseUrl + endPoint, data, { observe: 'response', responseType: 'text'});
            
        }
    
    getAllDogDocuments(): Observable<Dog[]> {
                const endPoint = '/dogs';
                return this.http.get<Dog[]>(this.baseUrl + endPoint);
        }

    checkoutDog(id: string, groompet: boolean): Observable<any> {
        const endPoint = 'checkoutdog';
        return this.http.post(`http://localhost:8082/checkoutdog/${id}/${groompet}`, { observe: 'response', responseType: 'text'});
    }

    updateDog(data: Dog): Observable<HttpResponse<string>>{
        const endPoint = '/updatedog';
       return this.http.put(this.baseUrl + endPoint, data, { observe: 'response', responseType: 'text'});
    }

    deleteDog(id: string): Observable<any>{
        const endPoint = '/deletedog';
        return this.http.delete(`http://localhost:8082/deletedog/${id}`, { responseType: 'text'});
    }
}