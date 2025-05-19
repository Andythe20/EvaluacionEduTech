package com.example.EvaluacionEduTech.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvaluacionEduTech.Model.Evaluacion;
import com.example.EvaluacionEduTech.Model.Pregunta;
import com.example.EvaluacionEduTech.Repository.EvaluacionRepository;
import com.example.EvaluacionEduTech.Repository.PreguntaRepository;

@Service
public class PreguntaService {
    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired 
    private EvaluacionRepository evaluacionRepository;

    // listar todo
    public List<Pregunta> listarPreguntas() {
        return preguntaRepository.findAll();
    }

    // Buscar pregunta por id
    public Pregunta buscarPreguntaId(Long idPregunta) {
        if (preguntaRepository.existsById(idPregunta)) {
            return preguntaRepository.findById(idPregunta).get();
        } else {
            return null;
        }
    }

    public Pregunta buscarPreguntaPorTexto(String textoPregunta) {
        if (preguntaRepository.existsByTextoPregunta(textoPregunta)) {
            return preguntaRepository.findByTextoPregunta(textoPregunta);
        } else {
            return null;
        }
    }

    // guardar
    public Pregunta guardarPregunta(Pregunta pregunta) {

        if (preguntaRepository.existsByTextoPregunta(pregunta.getTextoPregunta())) {
            return null;
        }

        preguntaRepository.save(pregunta);

        Evaluacion evaluacionCargada = evaluacionRepository.findById(pregunta.getEvaluacion().getEvaluacionId()).get();
        Pregunta preguntaCargada = preguntaRepository.findByTextoPregunta(pregunta.getTextoPregunta());
        preguntaCargada.setEvaluacion(evaluacionCargada);

        return preguntaCargada;
    }

    // Actualizar Pregunta
    public Pregunta actualizarPregunta(Pregunta pregunta) {
        if (!preguntaRepository.existsById(pregunta.getPreguntaId())) {
            return null;
        }

        return preguntaRepository.save(pregunta);
    }

    // Eliminar Pregunta
    public void eliminarPregunta(Long idPregunta) {
        if (preguntaRepository.existsById(idPregunta)) {
            preguntaRepository.deleteById(idPregunta);
        } else {
            throw new NoSuchElementException("No se encuentra la pregunta con id: " + idPregunta);
        }
    }
}
