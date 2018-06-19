import {Component, OnInit} from '@angular/core';
import {Currency} from "../../model/currency";
import {CurrencyService} from "../../services/currency.service";

@Component({
  selector: 'app-list-currencies-form',
  templateUrl: './list-currencies.component.html',
  styleUrls: ['./list-currencies.component.scss']
})
export class ListCurrenciesComponent implements OnInit {
  private currencies: Currency[];

  constructor(private currencyService: CurrencyService) {
  }

  ngOnInit(): void {
    this.currencyService.getCurrencies().subscribe((currencies: Currency[]) => {
      this.currencies = currencies;
    })
  }

}
