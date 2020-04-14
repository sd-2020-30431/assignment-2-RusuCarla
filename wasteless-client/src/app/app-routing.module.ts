import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {MenuComponent} from './menu/menu.component';
import {AddgroceriesComponent} from './addgroceries/addgroceries.component';


const routes: Routes = [{path: '', component: LoginComponent}, {path: 'login', component: LoginComponent},
  {path: 'menu', component: MenuComponent}, {path: 'addgroceries', component: AddgroceriesComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes), HttpClientModule, BrowserModule, FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
