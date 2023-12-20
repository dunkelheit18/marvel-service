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
  private urlCharactersId = 'http://localhost:8080/marvel/api/characters/findId';
  private httpHeaders = new HttpHeaders().set('Content-Type', 'application/json');

  constructor(private http: HttpClient) { }

 public getCharacters(name : string, id : number) : Observable<any>{

    const params = new HttpParams()
        .set( name != null && name != undefined && name != '' ? 'name' : 'idCharacters',
              name != null && name != undefined && name != '' ? name : id);

    const httpOptions = {
      headers : this.httpHeaders,
      params: params,

    };
    return this.http.get<any>(this.validateCharactersService(name, id), httpOptions );
  }

  public getBitacora(): Observable<any> {
   const httpOptions = {
      headers : this.httpHeaders
    };
    //this.headers.append('Content-Type', 'application/json');
    return this.http.get<any>(this.urlBitacora, httpOptions );
  }

  private validateCharactersService(name : string, id : number) : string {

    return name != null && name != undefined && name != '' ? this.urlCharactersName : 
      (id != null && id != undefined ? this.urlCharactersId : '');
  }

  public getImageElemnt(url: string): Observable<any> {

    return this.http.get<any>(`${url}?ts=1&apikey=5365d50e0ed423f38197671843b5d60a&hash=9a5059a3bae61e6b564ff7b1e467b56c`);
  }
}
