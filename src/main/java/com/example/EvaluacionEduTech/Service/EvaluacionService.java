package com.example.EvaluacionEduTech.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvaluacionEduTech.Model.Evaluacion;
import com.example.EvaluacionEduTech.Repository.EvaluacionRepository;

@Service
public class EvaluacionService {
    @Autowired
    private EvaluacionRepository repository;

    //Obtener todo
    public List<Evaluacion> listarEvaluaciones(){
        return repository.findAll();
    }

    //Obtener por id
    public Evaluacion getEvaluacionId(Long evaluacionID){
        return repository.findById(evaluacionID).get();
    }

    //Guardar
    public Evaluacion guardarEvaluacion(Evaluacion evaluacion){

        if (repository.existsByTitulo(evaluacion.getTitulo())) {
            return null;
        }

        repository.save(evaluacion);
        return evaluacion;
    }

    //Actualizar
    public Evaluacion actualizarEvaluacion(Evaluacion evaluacion){
        if (!repository.existsById(evaluacion.getEvaluacionId())) {
            return null;
        }
        repository.save(evaluacion);
        return evaluacion;
    }

    //Eliminar
    public void deleteEvaluacion(Long evaluacionId){
        if (!repository.existsById(evaluacionId)) {
            throw new NoSuchElementException("No existe una evaluacion con id: " + evaluacionId);
        }
        repository.deleteById(evaluacionId);
    }

}
