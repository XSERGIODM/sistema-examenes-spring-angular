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
@Entity(name = "preguntas")
public class Model_Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenido;
    private String imagen;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcion4;
    private String respuesta;


    public Model_Pregunta() {
    }
}
