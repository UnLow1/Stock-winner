import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {User} from "../model/user";
import {Observable} from "rxjs/Rx";
import 'rxjs/add/operator/map';

@Injectable()
export class AuthenticationService {

  baseUrl: string = 'http://stock-winner.herokuapp.com:8080';

  constructor(private _router: Router,
              private http: HttpClient) {
  }

  logout() {
    localStorage.removeItem("jwt");
    this._router.navigate(['/login']);
  }

  login(mail: string, password: string): Observable<Response> {
    const body = new User(mail, password).toJSON();

    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {
      headers: headers,
    };

    return this.http.post<Response>(`api/auth/`, body, options)
      .map((response: any) => {
        if (response.status === 403) {
          Observable.throw(response);
        }
        const token = response.token;
        localStorage.setItem("jwt", `Bearer ${token}`);

        this._router.navigate(['/']);

        return response;
      });
  }

  register(user: User): Observable<Response> {
    const body = user.toJSON();
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    const options = {
      headers: headers
    };

    return this.http.post(`api/auth/register`, body, options)
      .do(() => {
        this._router.navigate(['/'])
      });
  }

  checkCredentials() {
    if (localStorage.getItem("jwt") === null) {
      this._router.navigate(['/login']);
    }
  }

  isSignedIn(): boolean {
    return localStorage.getItem('jwt') !== null;
  }

}
