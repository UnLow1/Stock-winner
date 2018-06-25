import {Component, OnInit} from '@angular/core';
import {Currency} from "../../model/currency";
import {CurrencyService} from "../../services/currency.service";
import {Observable} from "rxjs/Observable";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-currencies-form',
  templateUrl: './list-currencies.component.html',
  styleUrls: ['./list-currencies.component.scss']
})
export class ListCurrenciesComponent implements OnInit {
  private currencies: Observable<Currency[]>;

  constructor(private currencyService: CurrencyService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.currencies = this.currencyService.getCurrencies();
  }

  delete(currency: Currency) {
    this.currencyService.deleteCurrency(currency).subscribe(() =>
      this.currencies = this.currencyService.getCurrencies());
  }

  update(currency: Currency) {
    this.currencyService.updateCurrency(currency).subscribe(() =>
      this.currencies = this.currencyService.getCurrencies());
  }

  getAllCurrencies() {
    this.currencies = this.currencyService.getAllCurrencies()
  }

  addToWallet(currency: Currency, amount: string) {
    this.currencyService.addToWallet(currency, amount).subscribe(() =>
      this.router.navigate(['/my_shares']))
  }

}
