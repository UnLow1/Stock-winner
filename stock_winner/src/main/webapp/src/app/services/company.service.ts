import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ICompany} from '../model/company';
import {Observable} from "rxjs/Observable";

const PROXY_URL = 'https://cors-anywhere.herokuapp.com/';

@Injectable()
export class CompanyService {
  constructor(private http: HttpClient) {
  }

  private companyUrl = 'https://api.iextrading.com/1.0/stock/';

  getCompany(companySymbol: string): Observable<ICompany[]> {
    return this.http.get(PROXY_URL + this.companyUrl + `${companySymbol}/company`);
  }
}

