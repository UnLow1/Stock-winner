import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ICompany} from '../model/company';
import {Observable} from "rxjs/Observable";
import {ILogo} from "../model/logo";

const PROXY_URL = 'https://cors-anywhere.herokuapp.com/';

@Injectable()
export class CompanyService {
  constructor(private http: HttpClient) {
  }

  private companyUrl = 'https://api.iextrading.com/1.0/stock/';

  getCompany(companySymbol: string): Observable<ICompany[]> {
    return this.http.get(PROXY_URL + this.companyUrl + `${companySymbol}/company`);
  }

  getCompanyLogo(companySymbol:string) : Observable<ILogo>{
    return this.http.get(PROXY_URL + this.companyUrl + `${companySymbol}/logo`)
  }
}

