
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { LoginInfo } from "../model/LoginInfo";

@Injectable({
    providedIn: 'root'
})
export class LoginService{
    
// url for Spring Boot
private baseUrl = "http://localhost:8082";

constructor(private http: HttpClient){}

// sends login request to endpoint and returns response
    login(data: LoginInfo): Observable<any>{
        const endPoint = '/login';
        return this.http.post<any>(this.baseUrl + endPoint, data);
    }

    
    logout(data: LoginInfo): Observable<any>{
        const endPoint = '/logout';
        return this.http.post<any>(this.baseUrl + endPoint, data);
    }
}