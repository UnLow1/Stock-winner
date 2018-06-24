import {Component, OnInit} from '@angular/core';
import {Currency} from "../../model/currency";
import {CurrencyService} from "../../services/currency.service";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-list-currencies-form',
  templateUrl: './list-currencies.component.html',
  styleUrls: ['./list-currencies.component.scss']
})
export class ListCurrenciesComponent implements OnInit {
  private currencies: Observable<Currency[]>;

  constructor(private currencyService: CurrencyService) {
  }

  ngOnInit(): void {
    this.currencies = this.currencyService.getCurrencies();
  }

  delete(currency: Currency) {
    this.currencyService.deleteCurrency(currency).subscribe(() =>
      // TODO refresh page after currency deletion
      this.currencies = this.currencyService.getCurrencies());
  }

  update(currency: Currency) {
    this.currencyService.updateCurrency(currency).subscribe(() =>
      // TODO refresh page after currency deletion
      this.currencies = this.currencyService.getCurrencies());
  }

  getAllCurrencies() {
    this.currencies = this.currencyService.getAllCurrencies()
  }

  addToWallet(currency: Currency, amount: string) {
    console.log(`list-currencies-component.ts    currency = ${currency.name}, amount = ${amount}`);
    this.currencyService.addToWallet(currency, amount).subscribe()
  }

}
