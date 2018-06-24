import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";
import {CompanyService} from "../../services/company.service";
import {DividendsService} from "../../services/dividends.service";
import {PriceService} from "../../services/price.service"

import {NgForm} from "@angular/forms";
import {IDividend} from "../../model/dividend";
import {SharesService} from "../../services/shares.service";
import {IPrice} from "../../model/price";
import {isNull} from "util";

@Component({
  selector: 'app-add-shares-form',
  templateUrl: './add-shares-form.component.html',
  styleUrls: ['./add-shares-form.component.scss', './../../app.component.scss'],
})

export class AddSharesFormComponent implements OnInit {
  exchange: string = '';
  companyName: string = '';
  industry: string = '';
  website: string = '';
  description: string = '';
  CEO: string = '';
  sector: string = '';
  dividends: IDividend[];
  volume: number = 0;
  // price: IPrice = {price: 0};
  price: number = 0;

  constructor(private _service: AuthenticationService, private companyService: CompanyService,
              private dividendsService: DividendsService, private priceService: PriceService,
              private sharesService: SharesService) {
  }

  ngOnInit() {
  }

  downloadData(f: NgForm) {
    this.companyService.getCompany(f.value.ticker)
      .subscribe((arg) => {
          this.exchange = arg['exchange'];
          this.companyName = arg['companyName'];
          this.industry = arg['industry'];
          this.website = arg['website'];
          this.description = arg['description'];
          this.CEO = arg['CEO'];
          this.sector = arg['sector'];
        }
      );

    this.dividendsService.getDividends(f.value.ticker, f.controls['country'].value).subscribe((arg) => {
      this.dividends = arg;
    });

    this.priceService.getPrice(f.value.ticker).subscribe((arg) => {
      console.log(arg);
      this.price = arg;
      console.log(f.value.price);
    });
  }

  addShares(f: NgForm) {
    console.log(f.value.price);
    console.log(this.price);

    this.sharesService.addShare({
      ticker: f.value.ticker,
      volume: f.value.volume,
      price: this.price == 0 ? f.value.price : this.price,
      date: "23.06.2018"
    }).subscribe((arg) => {
      // console.log(f.value.price);
    });
  }
}

