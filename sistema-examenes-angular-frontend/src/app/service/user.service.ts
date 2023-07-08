import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import baserUrl from "./helper";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient : HttpClient) { }

  public aniadirUsuario(user:any){
    return this.httpClient.post(`${baserUrl}/usuarios/`,user);
    alert('Ha ocurrido un error en el sistema');
  }
}
