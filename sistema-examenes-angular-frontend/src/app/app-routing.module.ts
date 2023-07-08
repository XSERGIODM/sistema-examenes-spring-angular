import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SignupComponent} from "./page/signup/signup.component";
import {HomeComponent} from "./page/home/home.component";
import {LoginComponent} from "./page/login/login.component";


const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: "full"
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: "full"
  },
  {
    path: 'singup',
    component: SignupComponent,
    pathMatch: "full"
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: "full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
