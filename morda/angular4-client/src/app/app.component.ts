import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import 'rxjs/add/operator/finally';
import {AutentificationService} from "./login-page/autentification.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [,AutentificationService]

})
export class AppComponent {
  constructor(private http: HttpClient, private router: Router) {
  }


}
