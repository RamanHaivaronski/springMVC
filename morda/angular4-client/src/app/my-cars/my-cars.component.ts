import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-my-cars',
  templateUrl: './my-cars.component.html',
  styleUrls: ['./my-cars.component.css']
})
export class MyCarsComponent implements OnInit {

  private cars: Car[];

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit() {
    this.getMyCars();
  }

  getMyCars() {
    this.httpClient.get<Car[]>("http://localhost:9096/api/carsView")
      .subscribe(data=>{
        this.cars=data;
      })
  }

}

export class Car {
  car_id: number;
  brand: string;
  path: string
}
