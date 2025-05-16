package com.example.EvaluacionEduTech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvaluacionEduTech.Model.Opcion;
import com.example.EvaluacionEduTech.Repository.OpcionRepository;

@Service
public class OpcionService {

    @Autowired
    private OpcionRepository repository;

    //listar todo
    public List<Opcion> listarOpciones(){
        return repository.findAll();
    }

    //guardar opcion
    public Opcion guardarOpcion(Opcion opcion){
        return repository.save(opcion);
    }
}
