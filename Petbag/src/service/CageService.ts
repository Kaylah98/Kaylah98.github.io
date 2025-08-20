import { HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { Cage } from "../model/Cage";

@Injectable({
    providedIn: 'root'
})
export class CageService{
    
    // url for Spring Boot
    private baseUrl = "http://localhost:8082";

    constructor(private http: HttpClient){}

    cleanCage(cage: Cage): Observable<HttpResponse<any>>{
        const endPoint = '/clean';
        return this.http.put<any>(this.baseUrl + endPoint, cage);
    }

    updateCageStatus(data: boolean): Observable<HttpResponse<any>>{
        const endPoint = '/available';
        return this.http.put<any>(this.baseUrl + endPoint, data);
    }
}