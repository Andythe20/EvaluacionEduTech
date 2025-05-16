package com.example.EvaluacionEduTech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EvaluacionEduTech.Model.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long>{


}
