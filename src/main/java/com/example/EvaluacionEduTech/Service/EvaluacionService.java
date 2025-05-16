package com.example.EvaluacionEduTech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvaluacionEduTech.Model.Evaluacion;
import com.example.EvaluacionEduTech.Repository.EvaluacionRepository;

@Service
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository repository;

    //listar todo
    public List<Evaluacion> listarEvaluaciones(){
        return repository.findAll();
    }

    //guardar
    public Evaluacion guardarEvaluacion(Evaluacion evaluacion){
        return repository.save(evaluacion);
    }
}
