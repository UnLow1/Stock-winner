import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../services/authentication.service";
import {SharesService} from "../../services/shares.service";
import {IShare} from "../../model/share";

@Component({
  selector: 'app-shares-form',
  templateUrl: './shares-form.component.html',
  styleUrls: ['./shares-form.component.scss']
})
export class SharesFormComponent implements OnInit {

  shares: IShare[];

  constructor(private _service: AuthenticationService, private sharesService: SharesService) {
  }


  ngOnInit(): void {
    this._service.checkCredentials();
    this.getShares();
  }

  getShares() {
    this.sharesService.getShares().subscribe(shares => {
      this.shares = shares;
    });
  }
}
