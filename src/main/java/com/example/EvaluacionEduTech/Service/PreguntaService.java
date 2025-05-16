package com.example.EvaluacionEduTech.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvaluacionEduTech.Model.Pregunta;
import com.example.EvaluacionEduTech.Repository.PreguntaRepository;

@Service
public class PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;

    // listar todo
    public List<Pregunta> listarPreguntas() {
        return preguntaRepository.findAll();
    }

    // guardar
    public Pregunta guardarPregunta(Pregunta pregunta) {
        try {
            return preguntaRepository.save(pregunta);
        } catch (Exception e) {
            return null;
        }
    }

    // Buscar pregunta por id
    public Pregunta buscarPreguntaId(Long idPregunta) {
        if (preguntaRepository.existsById(idPregunta)) {
            return preguntaRepository.findById(idPregunta).get();
        } else {
            return null;
        }
    }

    //Actualizar Pregunta
    public Pregunta actualizarPregunta(Pregunta nuevaPregunta){
        if (preguntaRepository.existsById(nuevaPregunta.getPreguntaId())) {
            return preguntaRepository.save(nuevaPregunta);
        } else {
            return null;
        }
    }

    //Eliminar Pregunta
    public void eliminarPregunta(Long idPregunta){
        if (preguntaRepository.existsById(idPregunta)) {
            preguntaRepository.deleteById(idPregunta);
        } else {
            throw new NoSuchElementException("No se encuentra la pregunta con id: " + idPregunta);
        }
    }
}
