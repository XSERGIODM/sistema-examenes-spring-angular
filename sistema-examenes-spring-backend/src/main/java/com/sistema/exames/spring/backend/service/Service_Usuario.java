package com.sistema.exames.spring.backend.service;

import com.sistema.exames.spring.backend.model.Model_Usuario;
import com.sistema.exames.spring.backend.model.Model_UsuarioRol;

import java.util.Set;

public interface Service_Usuario {

    Model_Usuario guardarUsuario(Model_Usuario usuarioGuardar, Set<Model_UsuarioRol> usuarioRoles) throws Exception;
    Model_Usuario obtenerUsuario (String username);
    void eliminarUsuario(Long usuarioIde);
}
