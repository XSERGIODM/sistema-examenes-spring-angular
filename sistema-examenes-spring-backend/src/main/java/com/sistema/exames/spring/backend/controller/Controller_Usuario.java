package com.sistema.exames.spring.backend.controller;

import com.sistema.exames.spring.backend.model.Model_Rol;
import com.sistema.exames.spring.backend.model.Model_Usuario;
import com.sistema.exames.spring.backend.model.Model_UsuarioRol;
import com.sistema.exames.spring.backend.service.Service_Usuario;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = {"http://localhost:4200"})
public class Controller_Usuario {

    private final Service_Usuario serviceUsuario;

    @PostMapping("/")
    public Model_Usuario crearUsuario(@RequestBody Model_Usuario usuarioBody) throws Exception {
        usuarioBody.setPerfil("default.png");
        Set<Model_UsuarioRol> usuarioRols = new LinkedHashSet<>();

        Model_Rol rol = new Model_Rol();
        rol.setId(2L);
        rol.setNombre("NORMAL");

        Model_UsuarioRol usuarioRol = new Model_UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuario(usuarioBody);

        usuarioRols.add(usuarioRol);

        return serviceUsuario.guardarUsuario(usuarioBody, usuarioRols);
    }

    @GetMapping("/{username}")
    public ResponseEntity<Model_Usuario> obtenerUsuario(@PathVariable(value = "username") String username) {
        System.out.println(username);
        Model_Usuario usuario = serviceUsuario.obtenerUsuario(username);
        System.out.println(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{ideUsuario}")
    public void eliminarUsuario(@PathVariable(value = "ideUsuario") Long ideUsuario) {
        serviceUsuario.eliminarUsuario(ideUsuario);
    }
}
