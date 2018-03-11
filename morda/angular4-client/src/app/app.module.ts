import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { MyCarsComponent } from './my-cars/my-cars.component';
import { AllCarsComponent } from './all-cars/all-cars.component';
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";



const routs =[
  {path:'users', component: UserComponent},
  {path:'allCars', component: AllCarsComponent},
  {path:'allCars', component: AllCarsComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginPageComponent,
    MyCarsComponent,
    AllCarsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routs),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
