import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {Currency} from "../model/currency";

@Injectable()
export class CurrencyService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  public getCurrencies(): Observable<Currency[]> {
    return this.http.get<Currency[]>('api/currencies')
      .pipe(
        map((objArray: any[]) => objArray.map(obj => Currency.fromJSON(obj)))
      );
  }

}
