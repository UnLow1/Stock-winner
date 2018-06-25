import {Component, OnInit, Output, ViewChild} from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";
import {CompanyService} from "../../services/company.service";
import {DividendsService} from "../../services/dividends.service";
import {PriceService} from "../../services/price.service"

import {NgForm} from "@angular/forms";
import {IDividend} from "../../model/dividend";
import {SharesService} from "../../services/shares.service";
import {ChartService} from "../../services/chart.service";
import {IChart} from "../../model/chart";

@Component({
  selector: 'app-add-shares-form',
  templateUrl: './add-shares-form.component.html',
  styleUrls: ['./add-shares-form.component.scss', './../../app.component.scss']
})

export class AddSharesFormComponent implements OnInit {
  @ViewChild('chartChild') child;

  exchange: string = '';
  companyName: string = '';
  industry: string = '';
  website: string = '';
  description: string = '';
  CEO: string = '';
  sector: string = '';
  dividends: IDividend[];
  dividentsDefined: boolean = false;
  volume: number = 0;
  price: number = 0;
  urlLogo: string = '';

  charts: IChart[] = [];

  constructor(private _service: AuthenticationService, private companyService: CompanyService,
              private dividendsService: DividendsService, private priceService: PriceService,
              private sharesService: SharesService,
              private chartService: ChartService) {
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

    this.companyService.getCompanyLogo(f.value.ticker).subscribe(logo => {
      this.urlLogo = logo.url;
    });

    this.dividendsService.getDividends(f.value.ticker, f.controls['dividentRange'].value).subscribe((arg) => {
      this.dividentsDefined = true;
      this.dividends = arg;
    });

    this.priceService.getPrice(f.value.ticker).subscribe((arg) => {
      this.price = arg;
    });

    this.chartService.getCompanyChart(f.value.ticker, f.controls['chartRange'].value).subscribe((arg) => {
      this.charts = arg;
      this.child.rebuild();
    });
  }

  addShares(f: NgForm) {
    this.sharesService.addShare({
      ticker: f.value.ticker,
      volume: f.value.volume,
      price: this.price,
      date: "23.06.2018" //todo change to proper date
    }).subscribe(arg => {
      //empty subscribe
    });
  }

  update(f: NgForm) {
    this.price = f.value.price;
  }
}

