import {Component, OnInit, Pipe, PipeTransform} from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";
import {CurrencyService} from "../../services/currency.service";
import {CurrencyPersonal} from "../../model/currency_personal";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss', './../../app.component.scss']
})

export class DashboardComponent implements OnInit {
  private currencies: CurrencyPersonal[];

  constructor(private _service: AuthenticationService,
              private currencyService: CurrencyService) {
  }

  ngOnInit() {
    this.getCurrenciesForUser();
  }


  logout() {
    this._service.logout();
  }


  getCurrenciesForUser() {
    this.currencyService.getCurrenciesForUser().subscribe(currencies => this.currencies = currencies);
  }
}
