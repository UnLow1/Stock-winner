import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {IDividend} from '../model/dividend';
import {Observable} from "rxjs/Observable";

const PROXY_URL = 'https://cors-anywhere.herokuapp.com/';

@Injectable()
export class DividendsService {
  constructor(private http: HttpClient) {
  }

  private stockUrl = 'https://api.iextrading.com/1.0/stock/';

  getDividends(companySymbol: string, description: string): Observable<IDividend[]> {
    return this.http.get(PROXY_URL + this.stockUrl + `${companySymbol}/dividends/${this.descriptionToRange(description)}`);
  }

  descriptionToRange(description: string) {
    if (description == 'Five years') {
      return '5y';
    } else if (description == 'Two years') {
      return '2y';
    } else if (description == 'One year') {
      return '1y';
    } else if (description == 'Year-to-date') {
      return '1yd';
    } else if (description == 'Six months') {
      return '6m';
    } else if (description == 'Three months') {
      return '3m';
    } else {
      return '1m';
    }
  }
}

