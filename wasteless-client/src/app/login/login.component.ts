import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {LoginModel} from './login.model';
import {ok} from 'assert';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginModel: LoginModel = new LoginModel();
  constructor(private http: HttpClient, private router: Router) { }

  login() {
  this.http.post<number>('http://localhost:8080/users/login', this.loginModel).subscribe(
    result => {
    console.log(result);
    alert('Successfully logged in.');
    window.localStorage.setItem('userId', String(result));
    window.localStorage.setItem('username', String(this.loginModel.username));
    this.router.navigateByUrl('/menu');
  },
    error => {
    console.log(error);
    alert('ERROR: Wrong input.');
    });
  }

  register() {
    this.http.post<string>('http://localhost:8080/users/register', this.loginModel).subscribe(
      result => {
        console.log(result);
        alert('Successfully registered.');
      },
      error => {
        console.log(error);
        alert('ERROR: Wrong input.');
      });
  }
  ngOnInit(): void {
  }

}
