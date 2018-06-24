import {Component, OnInit} from '@angular/core';
import {User} from "../../model/user";
import {AuthenticationService} from "../../services/authentication.service";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.scss']
})
export class LoginFormComponent implements OnInit {

  public user = new User('','');
  public errorMsg = '';

  constructor(private _service: AuthenticationService) {}

  login() {
    this._service.login(this.user.userMail, this.user.password)
      .catch((err: any, caught: Observable<Response>) => {
        this.errorMsg = 'Failed to login';

        return Observable.throw(err);
      })
      .subscribe();
  }

  ngOnInit(): void {
  }

}
