package com.example.EvaluacionEduTech.Model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "evaluacion")
public class Evaluacion {

    

    public Evaluacion(Long evaluacionId, String titulo, String descripcion, int cursoId, LocalDate fechaCreacion,
            TipoEvaluacion tipoEvaluacion, int puntajeMaximo, int duracionMinutos) {
        this.evaluacionId = evaluacionId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.cursoId = cursoId;
        this.fechaCreacion = fechaCreacion;
        this.tipoEvaluacion = tipoEvaluacion;
        this.puntajeMaximo = puntajeMaximo;
        this.duracionMinutos = duracionMinutos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluacion_id")
    private Long evaluacionId;

    @Column(nullable = false, name = "titulo")
    private String titulo;

    @Column(nullable = false, name = "descripcion")
    private String descripcion;

    @Column(nullable = false, name = "curso_id")
    private int cursoId; // Relación con Curso

    @Column(nullable = false, name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(nullable = false, name = "tipo_evaluacion")
    private TipoEvaluacion tipoEvaluacion; // Enum

    @Column(nullable = false, name = "puntaje_maximo")
    private int puntajeMaximo;

    @OneToMany(mappedBy = "evaluacion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Pregunta> preguntas;

    @Column(nullable = false, name = "duracion_minutos")
    private int duracionMinutos;

}
