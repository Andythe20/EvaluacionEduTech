package com.example.EvaluacionEduTech.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "opcion")
public class Opcion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opcion_id")
    private Long opcionId;

    @Column(nullable = false)
    private String textoOpcion;

    @ManyToOne
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;
}
