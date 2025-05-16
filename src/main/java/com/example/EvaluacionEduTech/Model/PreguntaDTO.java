package com.example.EvaluacionEduTech.Model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pregunta")
public class PreguntaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pregunta")
    private Long preguntaId;

    @Column(nullable = false, name = "texto_pregunta")
    private String textoPregunta;

    @Column(nullable = false, name = "puntaje")
    private int puntaje;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OpcionDTO> opciones = new ArrayList<OpcionDTO>();

    @Column(nullable = false, name = "respuesta_correcta")
    private String respuestaCorrecta;

    @ManyToOne
    @JoinColumn(name = "evaluacion_id")
    private EvaluacionDTO evaluacion;
}
