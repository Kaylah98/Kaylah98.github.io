import { HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { Cat } from "../model/Cat";

@Injectable({
    providedIn: 'root'
})
export class CatService{
    
    // url for Spring Boot
    private baseUrl = `http://localhost:8082`;

    constructor(private http: HttpClient){}

    checkCatIn(data: Cat): Observable<any>{
            const endPoint = '/checkincat';
            return this.http.post(this.baseUrl + endPoint, data, { observe: 'response', responseType: 'text'});
        }
    
    getAllCatDocuments(): Observable<Cat[]> {
                const endPoint = '/cats';
                return this.http.get<Cat[]>(this.baseUrl + endPoint);
        }

    checkoutCat(id: string, groompet: boolean): Observable<any> {
        
        return this.http.post(`http://localhost:8082/checkoutcat/${id}/${groompet}`, { observe: 'response', responseType: 'text'});
       
    }

    updateCat(data: Cat): Observable<HttpResponse<string>>{
            const endPoint = '/updatecat';
           return this.http.put(this.baseUrl + endPoint, data, { observe: 'response', responseType: 'text'});
        }

    deleteCat(id: string): Observable<any>{
        
        return this.http.delete(`http://localhost:8082/deletecat/${id}`, { responseType: 'text'});
    }
}