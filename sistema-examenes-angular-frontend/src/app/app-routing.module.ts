import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignupComponent} from "./page/signup/signup.component";


const routes: Routes = [
  //{ path: 'empleados', component: ListaEmpleadosComponent }
  //{path: 'registrarUsuario', component: SignupComponent},
  //{path: '', redirectTo:'registrarUsuario', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
