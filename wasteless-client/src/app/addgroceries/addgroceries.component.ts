import { Component, OnInit } from '@angular/core';
import {GroceriesModel} from './addgroceries.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-addgroceries',
  templateUrl: './addgroceries.component.html',
  styleUrls: ['./addgroceries.component.css']
})
export class AddgroceriesComponent implements OnInit {
  groceriesModel: GroceriesModel = new GroceriesModel();
  username: string;
  constructor(private http: HttpClient, private router: Router) {
  }

  add() {
    const httpOptions = {
      headers: new HttpHeaders({
        userId: window.localStorage.getItem('userId')
      })
    };

    this.http.post<string>('http://localhost:8080/groceries/addGrocery', this.groceriesModel, httpOptions).subscribe(
      result => {
        console.log(result);
        alert('Successfully added grocery item.');
      },
      error => {
        console.log(error);
        alert('ERROR: Wrong input.');
      });
  }

  view(){
    this.router.navigateByUrl('/menu');
  }

  ngOnInit(): void {
    this.username = window.localStorage.getItem('username');
  }

}
