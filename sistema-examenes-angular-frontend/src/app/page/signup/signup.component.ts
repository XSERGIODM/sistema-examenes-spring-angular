import {Component, OnInit} from '@angular/core';
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  public user = {
    nombre: '',
    apellido: '',
    username: '',
    password: '',
    telefono: '',
    email: '',
    perfil: ''
  }

  constructor(private usuarioService: UserService) {
  }

  ngOnInit(): void {
  }

  formSubmit() {
    console.log(this.user)
    if (this.user.username == '' || this.user.username == null) {
      alert('El nombre de usuario es requerido')
      return
    }
    this.usuarioService.aniadirUsuario(this.user).subscribe(
      (data)=>{
        console.log(data);
        alert('usuario guardado con exito')
      },error => {
        console.log(error)
      }
    )
  }
}
