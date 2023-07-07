package com.sistema.exames.spring.backend.service.implemetation;

import com.sistema.exames.spring.backend.model.Model_Usuario;
import com.sistema.exames.spring.backend.model.Model_UsuarioRol;
import com.sistema.exames.spring.backend.repository.Repository_Rol;
import com.sistema.exames.spring.backend.repository.Repository_Usuario;
import com.sistema.exames.spring.backend.service.Service_Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class Implementation_Usuario implements Service_Usuario {

    private final Repository_Usuario repositoryUsuario;
    private final Repository_Rol repositoryRol;

    @Override
    public Model_Usuario guardarUsuario(Model_Usuario usuarioGuardar, Set<Model_UsuarioRol> usuarioRoles) throws Exception {

        Model_Usuario usuario = repositoryUsuario.findByUserName(usuarioGuardar.getUserName());

        if (usuario != null) {
            System.out.println("El username ya exite");
            throw new Exception("El username ya existe");
        }else {
            for (Model_UsuarioRol usuarioRol: usuarioRoles){
                repositoryRol.save(usuarioRol.getRol());
            }
            usuarioGuardar.getUsuariosRoles().addAll(usuarioRoles);
            return repositoryUsuario.save(usuarioGuardar);
        }
    }

}
