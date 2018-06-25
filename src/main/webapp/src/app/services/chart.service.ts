import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import {IChart} from "../model/chart";

const PROXY_URL = 'https://cors-anywhere.herokuapp.com/';

@Injectable()
export class ChartService {
  constructor(private http: HttpClient) {
  }

  private companyUrl = 'https://api.iextrading.com/1.0/stock/';

  getCompanyChart(companySymbol: string, description: string): Observable<IChart[]> {
    return this.http.get(PROXY_URL + this.companyUrl + `${companySymbol}/chart/${this.descriptionToRange(description)}`);
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

