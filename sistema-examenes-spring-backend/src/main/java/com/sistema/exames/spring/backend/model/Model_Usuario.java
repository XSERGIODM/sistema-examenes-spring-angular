package com.sistema.exames.spring.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
@Entity(name = "usuarios")
public class Model_Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Boolean enabled;
    private String perfil;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Model_UsuarioRol> usuariosRoles = new LinkedHashSet<>();

    public Model_Usuario() {
    }
}
