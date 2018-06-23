import {Component, OnInit} from '@angular/core';
import {CurrencyService} from "../../services/currency.service";

@Component({
  selector: 'app-add-currency-form',
  templateUrl: './add-currency.component.html',
  styleUrls: ['./add-currency.component.scss']
})
export class AddCurrencyComponent implements OnInit {
  private currencyName: string;

  constructor(private currencyService: CurrencyService) {
  }

  ngOnInit(): void {
  }

  addCurrency() {
    this.currencyService.addCurrency(this.currencyName).subscribe();
  }

}
