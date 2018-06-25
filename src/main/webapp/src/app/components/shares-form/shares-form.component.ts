import {Component, Input, OnInit} from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";
import {SharesService} from "../../services/shares.service";
import {IShare} from "../../model/share";
import {PriceService} from "../../services/price.service";

@Component({
  selector: 'app-shares-form',
  templateUrl: './shares-form.component.html',
  styleUrls: ['./shares-form.component.scss']
})
export class SharesFormComponent implements OnInit {

  @Input() data: IShare;

  shares: IShare[];
  currentShares: Map<string, number>;
  currentPrices: Map<string, number>;
  totalBaseValue: number;
  totalCurrentValue: number;

  constructor(private _service: AuthenticationService,
              private sharesService: SharesService,
              private priceService: PriceService) {
  }


  ngOnInit(): void {
    this._service.checkCredentials();
    this.getShares();
  }


  removeShares(share) {
    this.sharesService.removeShare(share.id)
      .subscribe(arg => {
        this.getShares();
      });
  }

  getShares() {
    this.sharesService.getShares().subscribe(shares => {
      this.shares = shares;
      this.currentShares = new Map<string, number>();
      this.currentPrices = new Map<string, number>();
      this.totalBaseValue = 0;
      this.totalCurrentValue = 0;

      this.shares.forEach(sh => {
        this.totalBaseValue += sh.volume * sh.price;
      });

      shares.forEach(sh => {
        this.currentShares.set(sh.ticker, 0);
        this.currentPrices.set(sh.ticker, 0)
      });

      this.currentShares.forEach((value: number, key: string) => {
        this.priceService.getPrice(key).subscribe(arg => {
          this.currentPrices.set(key, arg);
          this.totalCurrentValue += arg * this.getTotalVolume(key);
        });
      });
    });
  }

  getTotalVolume(value) {
    return this.shares
      .filter(sh => sh.ticker == value)
      .map(sh => sh.volume)
      .reduce((x, y) => x + y);
  }


}
