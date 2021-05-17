import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpResponse } from "@angular/common/http";
import { Login } from "../models/login";
import { Observable } from "rxjs";
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: "root"
})
export class LoginService {

  url: string = "http://localhost:8080/login";

  constructor(private http: HttpClient) { }

  doLogin(login: Login): Observable<HttpResponse<Login>>{

    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json'})
    };
    console.log("about to send post request");
    console.log(login.username);
    return this.http.post<Login>(this.url, login,{ observe: 'response'});
  }

}
