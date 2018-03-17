import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {AutentificationService} from "../authentication/authenticationServise/autentification.service";
import {AuthenticationGuard} from "../authentication/guardians/authentication.guard";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {


  constructor(private autService: AutentificationService,
              private http: HttpClient,
              private router: Router,
              private guard: AuthenticationGuard) {

  }

  ngOnInit() {
  }


  OnSubmit(userName, password) {


    this.http.post('http://localhost:9096/login',
      {
        username: userName,
        password: password
      })
      .subscribe(
        data => console.log(data)
      );
    this.router.navigate(['users']);
  }
}
