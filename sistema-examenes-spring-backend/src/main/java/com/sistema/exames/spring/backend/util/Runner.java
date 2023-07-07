package com.sistema.exames.spring.backend.util;

import com.sistema.exames.spring.backend.model.Model_Rol;
import com.sistema.exames.spring.backend.model.Model_Usuario;
import com.sistema.exames.spring.backend.model.Model_UsuarioRol;
import com.sistema.exames.spring.backend.service.Service_Usuario;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
//@Component para hacer pruebas en cosola
public class Runner implements CommandLineRunner {

    private final Service_Usuario serviceUsuario;

    @Override
    public void run(String... args) throws Exception {

        Model_Usuario usuario = new Model_Usuario();
        usuario.setNombre("sergio");
        usuario.setApellido("mosquera");
        usuario.setUsername("xsergiodm");
        usuario.setPassword("123");
        usuario.setEmail("ser@gmail.com");
        usuario.setTelefono("321");
        usuario.setPerfil("foto.png");
        usuario.setEnabled(true);

        Model_Rol rol = new Model_Rol();
        rol.setNombre("ADMIN");

        Model_UsuarioRol usuarioRol = new Model_UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        Set<Model_UsuarioRol> usuarioRols = new LinkedHashSet<>();
        usuarioRols.add(usuarioRol);



        System.out.println(serviceUsuario.guardarUsuario(usuario,usuarioRols).getUsername());
    }
}
