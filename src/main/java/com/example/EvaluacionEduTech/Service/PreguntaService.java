package com.example.EvaluacionEduTech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvaluacionEduTech.Model.Pregunta;
import com.example.EvaluacionEduTech.Repository.PreguntaRepository;

@Service
public class PreguntaService {
    @Autowired
    private PreguntaRepository repository;

    //listar todo
    public List<Pregunta> listarPreguntas(){
        return repository.findAll();
    }

    //guardar
    public Pregunta guardarPregunta(Pregunta pregunta){
        return repository.save(pregunta);
    }
}
