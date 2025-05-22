package com.example.EvaluacionEduTech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvaluacionEduTech.Model.Evaluacion;
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

    // Buscar pregunta por id
    public Pregunta buscarPreguntaId(Long idPregunta) {
        return preguntaRepository.findById(idPregunta).get(); 
    }

    //buscar pregunta por su texto
    public Pregunta buscarPreguntaPorTexto(String textoPregunta) {

        if (preguntaRepository.existsByTextoPregunta(textoPregunta)) {
            return preguntaRepository.findByTextoPregunta(textoPregunta);
        }
        
        return null;
        
    }

    public boolean validarPregunta(Pregunta pregunta){
        if (pregunta.getTextoPregunta() == null || pregunta.getTextoPregunta().isEmpty() ||
            pregunta.getPuntaje() == null || pregunta.getPuntaje() <= 0 ||
            pregunta.getRespuestaCorrecta() == null || pregunta.getRespuestaCorrecta().isEmpty()){
            return true;
            
        }

        return false;
    }

    //verificar si existe
    public boolean existsById(Long idPregunta){
        return preguntaRepository.existsById(idPregunta);
    }

    // guardar
    public Pregunta guardarPregunta(Pregunta pregunta) {

        //verificamos si se repite
        if (preguntaRepository.existsByTextoPregunta(pregunta.getTextoPregunta())) {
            return null;
        }

        //verificamos si es valida
        if (validarPregunta(pregunta)) {
            return null;
        }

        return preguntaRepository.save(pregunta);

    }

    // Actualizar Pregunta
    public Pregunta actualizarPregunta(Pregunta pregunta) {

        //verificamos si es valida
        if (validarPregunta(pregunta)) {
            return null;
        }

        Pregunta preguntaEncontrada = preguntaRepository.findById(pregunta.getPreguntaId()).get();

        //validar que el texto de la pregunta existente sea igual a la pregunta que se va a actualizar
        if (!preguntaEncontrada.getTextoPregunta().equals(pregunta.getTextoPregunta())) {
            return null;
        }

        Evaluacion evaluacion = pregunta.getEvaluacion();

        //actualizar
        preguntaEncontrada.setTextoPregunta(pregunta.getTextoPregunta());
        preguntaEncontrada.setPuntaje(pregunta.getPuntaje());
        preguntaEncontrada.setRespuestaCorrecta(pregunta.getRespuestaCorrecta());
        preguntaEncontrada.setEvaluacion(evaluacion);
        

        return preguntaRepository.save(pregunta);
    }

    // Eliminar Pregunta
    public Pregunta eliminarPregunta(Long idPregunta) {
        
        preguntaRepository.deleteById(idPregunta);
        return null;
    }
}
