package com.sistema.exames.spring.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
@Entity(name = "roles")
public class Model_Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.LAZY)
    private Set<Model_UsuarioRol> usuariosRoles = new LinkedHashSet<>();

    public Model_Rol() {
    }
}
