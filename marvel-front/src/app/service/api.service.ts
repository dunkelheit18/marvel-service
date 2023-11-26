import { HttpClient } from '@angular/common/http';
import { Injectable, NgModule } from '@angular/core';
import { response } from 'express';
import { Observable } from 'rxjs';
import { json } from 'stream/consumers';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private url = 'http://localhost:8080/marvel/api/bitacora/loadAccess';
  public resultData: any;


  constructor(private http: HttpClient) { }

  getData() {
    fetch(this.url)
    .then((response) => response.json())
    .then((json)=> console.log(json))
    .then((rData) => rData = this.resultData)
  }

  public getBitacora(): Observable<any> {
    return this.http.get<any>(this.url);
  }
}
