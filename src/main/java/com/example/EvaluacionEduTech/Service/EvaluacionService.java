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

    //Service para obtener todo
    public List<Evaluacion> listarEvaluaciones(){
        return repository.findAll();
    }

    //Service para guardar
    public Evaluacion guardarEvaluacion(Evaluacion evaluacion){
        return repository.save(evaluacion);
    }

    //Service para obtener por id
    public Evaluacion getEvaluacionId(Long evaluacionID){
        return repository.findById(evaluacionID).get();
    }

    //Service para actualizar
    public Evaluacion saveEvaluacion(Evaluacion evaluacion){
        return repository.save(evaluacion);
    }

    //Service para eliminar
    public void deleteEvaluacion(Long evaluacionId){
        repository.deleteById(evaluacionId);
    }
}
