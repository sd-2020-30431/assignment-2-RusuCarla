import { Component, OnInit } from '@angular/core';
import {GroceriesModel} from '../addgroceries/addgroceries.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {ConsumptionModel} from './consumption.model';
import {LoginModel} from '../login/login.model';
import {StringObjModel} from './stringObj.model';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  groceries: GroceriesModel[];
  consumptionModel: ConsumptionModel = new ConsumptionModel();
  field1;
  username: string;
  goal: number;
  loginModel: LoginModel = new LoginModel();
  rates: number[];
  sum: number;
  stringObj: StringObjModel = new StringObjModel();

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.getGroceries();
    this.getGoal();

  }

  computeSum(){
    this.sum = 0;
    for (const g of this.groceries){
      if (g.consumptionDate === null){
        this.sum += g.rate;
      }
    }
    console.log(this.sum);
  }

  getGroceries(){
    this.username = window.localStorage.getItem('username');
    const httpOptions = {
      headers: new HttpHeaders({
        userId: window.localStorage.getItem('userId')
      })
    };

    this.http.get<GroceriesModel[]>('http://localhost:8080/groceries/getGroceries',
      httpOptions).subscribe(result => {
        this.groceries = result;
        console.table(this.groceries);
      },
      error => console.log(error));
    setTimeout(() => {  this.computeSum(); }, 2000);
  }

  viewWeeklyReports(){
    const httpOptions = {
      headers: new HttpHeaders({
        userId: window.localStorage.getItem('userId')
      })
    };

    this.http.post<StringObjModel>('http://localhost:8080/users/weeklyReport', this.goal, httpOptions).subscribe(
      result => {
        this.stringObj = result;
        console.log(result);
      },
      error => {
        alert('ERROR: Could not generate report.');
        console.log(error);
      });
  }
  viewMonthlyReports(){
    const httpOptions = {
      headers: new HttpHeaders({
        userId: window.localStorage.getItem('userId')
      })
    };

    this.http.post<StringObjModel>('http://localhost:8080/users/monthlyReport', this.goal, httpOptions).subscribe(
      result => {
        this.stringObj = result;
        console.log(result);
      },
      error => {
        alert('ERROR: Could not generate report.');
        console.log(error);
      });
  }

  addConsumptionDate(){
    const httpOptions = {
      headers: new HttpHeaders({
        userId: window.localStorage.getItem('userId')
      })
    };

    this.field1 = (document.getElementById('field1')) as HTMLSelectElement;
    console.log(this.field1);
    this.consumptionModel.name = this.field1.options[this.field1.selectedIndex].text.toString();
    console.log(this.consumptionModel);
    this.http.post('http://localhost:8080/groceries/addConsumptionDate', this.consumptionModel, httpOptions).subscribe(
      result => {
        console.log(result);
        alert('Successfully added consumption date.');
      },
      error => {
        console.log(error);
        alert('ERROR: Wrong input.');
      });
    setTimeout(() => {  this.getGroceries(); }, 2000);
    setTimeout(() => {  this.computeSum(); }, 2000);
  }

  addGroceryItem(){
    this.router.navigateByUrl('/addgroceries');
  }

  logout(){
    this.router.navigateByUrl('/login');
  }

  getGoal(){
    const httpOptions = {
      headers: new HttpHeaders({
        userId: window.localStorage.getItem('userId')
      })
    };

    this.http.get<LoginModel>('http://localhost:8080/users/getGoal', httpOptions).subscribe(
      result => {
        this.loginModel = result;
        console.log(result);
      },
      error => {
        console.log(error);
      });
  }

  setGoal(){
    const httpOptions = {
      headers: new HttpHeaders({
        userId: window.localStorage.getItem('userId')
      })
    };

    this.http.post('http://localhost:8080/users/setGoal', this.goal, httpOptions).subscribe(
      result => {
        console.log(result);
        alert('Successfully updated goal.');
      },
      error => {
        console.log(error);
        alert('ERROR: Wrong input.');
      });
    setTimeout(() => {  this.getGoal(); }, 2000);

    console.log(this.loginModel.goal);
  }

}
