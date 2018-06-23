import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {RegistrationFormComponent} from "./components/registration-form/registration-form.component";

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {LoginFormComponent} from './components/login-form/login-form.component';
import {AuthenticationService} from './services/authentication.service';
import {StartPageComponent} from './components/start-page/start-page.component';
import {TokenInterceptor} from "./services/token-interceptor";
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {NavbarComponent} from "./components/navbar/navbar.component";
import {SharesFormComponent} from "./components/shares-form/shares-form.component";
import {AddSharesFormComponent} from "./components/add-shares-form/add-shares-form.component";
import {CurrenciesFormComponent} from "./components/currencies-form/currencies-form.component";
import {CompanyService} from "./services/company.service"
import {DividendsService} from "./services/dividends.service"
import {PriceService} from "./services/price.service"
import {SharesService} from "./services/shares.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    StartPageComponent,
    RegistrationFormComponent,
    DashboardComponent,
    NavbarComponent,
    SharesFormComponent,
    AddSharesFormComponent,
    CurrenciesFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    AuthenticationService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    CompanyService,
    DividendsService,
    PriceService,
    SharesService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
