import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import {IShare} from "../model/share";

@Injectable()
export class SharesService {
  constructor(private http: HttpClient) {
  }

  getShares(): Observable<IShare[]> {
    return this.http.get('/api/shares');
  }

  addShare(share): Observable<IShare> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {
      headers: headers,
    };

    return this.http.post('/api/shares', share, options);
  }

  removeShare(id): Observable<IShare> {
    return this.http.delete(`/api/shares/${id}`);
  }
}

