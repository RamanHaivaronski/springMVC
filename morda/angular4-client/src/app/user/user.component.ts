import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  private users: User[];

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers(): void {
    this.httpClient
      .get<User[]>('/usersAll')
      .subscribe(data => {
        this.users = data;
      });
  }
}

export class User {
  user_id: number;
  name: string;
  surname: string;
  login: string
}
