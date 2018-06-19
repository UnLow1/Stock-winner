import { NgModule} from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginFormComponent} from "./components/login-form/login-form.component";
import {StartPageComponent} from "./components/start-page/start-page.component";
import {RegistrationFormComponent} from "./components/registration-form-component/registration-form.component";
import {ListCurrenciesComponent} from "./components/list-currencies/list-currencies.component";
import {AddCurrencyComponent} from "./components/add-currency/add-currency.component";

const routes: Routes = [
  { path: '', redirectTo: '/start', pathMatch: 'full' },
  { path: 'start', component: StartPageComponent},
  { path: 'login', component: LoginFormComponent},
  { path: 'registration', component: RegistrationFormComponent},
  { path: 'list-currencies', component: ListCurrenciesComponent},
  { path: 'add-currency', component: AddCurrencyComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
