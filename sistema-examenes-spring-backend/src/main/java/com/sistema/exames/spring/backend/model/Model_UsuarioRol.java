package com.sistema.exames.spring.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@Setter
@Getter
@Entity(name = "usuarios_roles")
public class Model_UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Model_Usuario usuario;

    @ManyToOne
    private Model_Rol rol;

    public Model_UsuarioRol() {
    }
}
