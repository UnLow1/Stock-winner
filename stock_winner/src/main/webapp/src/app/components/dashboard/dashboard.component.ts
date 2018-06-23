import {Component, OnInit, Pipe, PipeTransform} from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss', './../../app.component.scss']
})

export class DashboardComponent implements OnInit {

  constructor(private _service: AuthenticationService) {
  }

  ngOnInit() {
  }


  logout() {
    this._service.logout();
  }

}
