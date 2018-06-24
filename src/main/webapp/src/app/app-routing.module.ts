import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginFormComponent} from "./components/login-form/login-form.component";
import {StartPageComponent} from "./components/start-page/start-page.component";
import {ListCurrenciesComponent} from "./components/list-currencies/list-currencies.component";
import {AddCurrencyComponent} from "./components/add-currency/add-currency.component";
import {RegistrationFormComponent} from "./components/registration-form/registration-form.component";
import {DashboardComponent} from "./components/dashboard/dashboard.component";
import {AddSharesFormComponent} from "./components/add-shares-form/add-shares-form.component";

const routes: Routes = [
  {path: '', redirectTo: '/start', pathMatch: 'full'},
  {path: 'start', component: StartPageComponent},
  {path: 'login', component: LoginFormComponent},
  {path: 'registration', component: RegistrationFormComponent},
  {path: 'my_shares', component: DashboardComponent},
  {path: 'add_shares', component: AddSharesFormComponent},
  {path: 'currencies', component: ListCurrenciesComponent},
  {path: 'add-currency', component: AddCurrencyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
