package com.sistema.exames.spring.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@Setter
@Getter
@Entity(name = "examenes")
public class Model_Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean activo;
    private String descripcion;
    private String numeroPregustas;
    private String puntosMaximos;
    private String titulo;


    public Model_Examen() {
    }
}
