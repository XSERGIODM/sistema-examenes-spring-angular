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
public class Modle_Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.EAGER)
    private Set<Model_UsuarioRol> usuariosRoles = new LinkedHashSet<>();

    public Modle_Rol() {
    }
}
