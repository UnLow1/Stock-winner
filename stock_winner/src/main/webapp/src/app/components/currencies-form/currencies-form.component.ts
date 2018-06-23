import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './currencies-form.component.html',
  styleUrls: ['./currencies-form.component.scss', './../../app.component.scss']
})

export class CurrenciesFormComponent implements OnInit {

  constructor(private _service: AuthenticationService) {
  }

  ngOnInit() {
  }


  logout() {
    this._service.logout();
  }

}
