import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ApiService {
  public resultData: any;
  private urlBitacora     = 'http://localhost:8080/marvel/api/bitacora/loadAccess';
  private urlCharactersName = 'http://localhost:8080/marvel/api/characters/findName';
  private httpHeaders = new HttpHeaders().set('Content-Type', 'application/json');

  constructor(private http: HttpClient) { }

 public getCharacters(name : string) : Observable<any>{

    const params = new HttpParams()
        .set('name', name);

    const httpOptions = {
      headers : this.httpHeaders,
      params: params,

    };
    return this.http.get<any>(this.urlCharactersName, httpOptions );
  }

  public getBitacora(): Observable<any> {
   const httpOptions = {
      headers : this.httpHeaders
    };
    //this.headers.append('Content-Type', 'application/json');
    return this.http.get<any>(this.urlBitacora, httpOptions );
  }
}
