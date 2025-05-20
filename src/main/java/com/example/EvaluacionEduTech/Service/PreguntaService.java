package com.example.EvaluacionEduTech.Service;

import java.util.List;

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

    // Buscar pregunta por id
    public Pregunta buscarPreguntaId(Long idPregunta) {

        if (preguntaRepository.existsById(idPregunta)) {
            return preguntaRepository.findById(idPregunta).get();
        }
        
        return null;
        
    }

    //buscar pregunta por su texto
    public Pregunta buscarPreguntaPorTexto(String textoPregunta) {

        if (preguntaRepository.existsByTextoPregunta(textoPregunta)) {
            return preguntaRepository.findByTextoPregunta(textoPregunta);
        }
        
        return null;
        
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

        return preguntaRepository.save(pregunta);

    }

    // Actualizar Pregunta
    public Pregunta actualizarPregunta(Pregunta pregunta) {

        //verificamos si existe
        if (!preguntaRepository.existsById(pregunta.getPreguntaId())) {
            return null;
        }
        

        return preguntaRepository.save(pregunta);
    }

    // Eliminar Pregunta
    public Pregunta eliminarPregunta(Long idPregunta) {
        
        preguntaRepository.deleteById(idPregunta);
        return null;
    }
}
