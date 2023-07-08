import {Component, OnInit} from '@angular/core';
import {UserService} from "../../service/user.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import Swal from "sweetalert2";


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

  constructor(private usuarioService: UserService, private snack: MatSnackBar) {
  }

  ngOnInit(): void {
  }

  formSubmit() {
    console.log(this.user)
    if (this.user.username == '' || this.user.username == null) {
      this.snack.open("El usuario es requerido!!", 'Aceptar',{
        duration:3000,
        verticalPosition:"top",
        horizontalPosition:"right"
      })
      return
    }
    this.usuarioService.aniadirUsuario(this.user).subscribe(
      (data)=>{
        console.log(data);
        Swal.fire(
          'Usuario guardado',
          'Usuario guardado con exito en el sistema',
          'success')
      },error => {
        console.log(error)
        this.snack.open("Ha ocurrido un error en el sistema!!", 'Aceptar',{
          duration:3000
        })
      }
    )
  }
}
