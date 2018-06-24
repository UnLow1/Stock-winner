import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Currency} from "../model/currency";

@Injectable()
export class CurrencyService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) {
  }

  public getCurrencies(): Observable<Currency[]> {
    return this.http.get('api/currencies');
  }

  public addCurrency(currencyName: String): Observable<any> {
    return this.http.post(`api/currencies?currencyName=${currencyName}`, null);
  }

  public deleteCurrency(currency: Currency): Observable<any> {
    return this.http.delete(`api/currencies?currencyName=${currency.name}`);
  }

  public getAllCurrencies(): Observable<any> {
    return this.http.get("api/currencies/all")
  }

  public updateCurrency(currency: Currency): Observable<any>{
   return this.http.put(`api/currencies`, currency.name)
  }
}
