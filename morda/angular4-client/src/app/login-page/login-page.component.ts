import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {AutentificationService} from "./autentification.service";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  credentials;

  constructor( private autService: AutentificationService, private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
    this.credentials = {username: '', password: ''};
  }

  login() {
    this.autService.Login(this.credentials);

  }
}
