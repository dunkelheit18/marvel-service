import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, NgModule } from '@angular/core';
import { response } from 'express';
import { Observable } from 'rxjs';
import { json } from 'stream/consumers';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  public resultData: any;
  private url     = 'http://localhost:8080/marvel/api/bitacora/loadAccess';
  private httpOptions = {
    headers : new HttpHeaders({
      'Content-Type' : 'application/json'
    })
  };


  constructor(private http: HttpClient) { }

  getData() {
    fetch(this.url)
    .then((response) => response.json())
    .then((json)=> console.log(json))
    .then((rData) => rData = this.resultData)
  }

  public getBitacora(): Observable<any> {
    //this.headers.append('Content-Type', 'application/json');
    return this.http.get<any>(this.url, this.httpOptions );
  }
}
