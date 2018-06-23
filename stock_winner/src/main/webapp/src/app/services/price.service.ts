import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import {IPrice} from "../model/price";

const PROXY_URL = 'https://cors-anywhere.herokuapp.com/';

@Injectable()
export class PriceService {
  constructor(private http: HttpClient) {
  }

  private stockUrl = 'https://api.iextrading.com/1.0/stock/';

  getPrice(companySymbol: string): Observable<number> {
    return this.http.get(PROXY_URL + this.stockUrl + `${companySymbol}/price`);
  }
}

