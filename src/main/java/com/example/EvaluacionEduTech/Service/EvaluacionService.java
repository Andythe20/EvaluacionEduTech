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

    //Obtener todo
    public List<Evaluacion> listarEvaluaciones(){
        return repository.findAll();
    }

    //Obtener por id
    public Evaluacion findById(Long evaluacionID){
        return repository.findById(evaluacionID).get();
    }

    public boolean existsById(Long evaluacionId){
        return repository.existsById(evaluacionId);
    }

    //validar la evaluacion
    public boolean validarEvaluacion(Evaluacion ev){
        if (ev.getTitulo() == null || ev.getTitulo().isEmpty() ||
            ev.getDescripcion() == null|| ev.getDescripcion().isEmpty() ||
            ev.getCursoId() == null || ev.getFechaCreacion() == null ||
            ev.getTipoEvaluacion() == null || 
            ev.getPuntajeMaximo() <= 0 || ev.getPuntajeMaximo() == null || 
            ev.getDuracionMinutos() == null || ev.getDuracionMinutos() <= 0) {
            return true;
        }
        return false;
    }

    //Guardar
    public Evaluacion guardarEvaluacion(Evaluacion evaluacion){

        if (repository.existsByTitulo(evaluacion.getTitulo())) {
            throw new RuntimeException("El titulo de la evaluacion ya existe");
        }

        if (validarEvaluacion(evaluacion)) {
            throw new RuntimeException("La evaluacion no es valida");
        }

        return repository.save(evaluacion);
         
    }

    //Actualizar
    public Evaluacion actualizarEvaluacion(Evaluacion evaluacion){

        if (validarEvaluacion(evaluacion)) {
            throw new RuntimeException("La evaluacion no es valida");
        }

        Evaluacion evaluacionExistente = repository.findById(evaluacion.getEvaluacionId()).get();

        //actualizar
        evaluacionExistente.setTitulo(evaluacion.getTitulo());
        evaluacionExistente.setDescripcion(evaluacion.getDescripcion());
        evaluacionExistente.setCursoId(evaluacion.getCursoId());
        evaluacionExistente.setFechaCreacion(evaluacion.getFechaCreacion());
        evaluacionExistente.setTipoEvaluacion(evaluacion.getTipoEvaluacion());
        evaluacionExistente.setPuntajeMaximo(evaluacion.getPuntajeMaximo());
        evaluacionExistente.setDuracionMinutos(evaluacion.getDuracionMinutos());
        
        return repository.save(evaluacionExistente);

    }

    //Eliminar
    public Evaluacion deleteEvaluacion(Long evaluacionId){
        
        repository.deleteById(evaluacionId);
        return null;
    }

}
