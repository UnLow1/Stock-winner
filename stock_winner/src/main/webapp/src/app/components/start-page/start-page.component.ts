import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../../services/authentication.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-start-page',
  templateUrl: './start-page.component.html',
  styleUrls: ['./start-page.component.scss']
})
export class StartPageComponent implements OnInit {
  private hello: string = '';

  constructor(private _router: Router,
              private authService: AuthenticationService,
              private http: HttpClient) { }

  ngOnInit() {
  }

  public toLoginPage() {
    this._router.navigate(['/login']);
  }

  public toRegistrationPage() {
    this._router.navigate(['/registration']);
  }

  helloWorldRequest(): void {
    this.http.get('api/hello-world').subscribe(
      (response: any) => {
        this.hello=response.text;
      }
    )
  }

  logout(): void {
    this.authService.logout();
  }
}
