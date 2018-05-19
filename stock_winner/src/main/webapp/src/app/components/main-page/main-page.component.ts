import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.scss']
})
export class MainPageComponent implements OnInit {

  constructor(
    private _service:AuthenticationService){}

  ngOnInit(){
    this._service.checkCredentials();
  }

  logout() {
    this._service.logout();
  }

}
