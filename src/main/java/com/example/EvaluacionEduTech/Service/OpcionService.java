package com.example.EvaluacionEduTech.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EvaluacionEduTech.Model.Opcion;
import com.example.EvaluacionEduTech.Repository.OpcionRepository;

@Service
public class OpcionService {

    @Autowired
    private OpcionRepository opcionRepository;

    //listar todo
    public List<Opcion> listarOpciones(){
        return opcionRepository.findAll();
    }

    //guardar opcion
    public Opcion guardarOpcion(Opcion opcion){
        try {
            return opcionRepository.save(opcion);
        } catch (Exception e) {
            return null;
        }
        
    }

    //Obtener opcion por id
    public Opcion obtenerOpcionId(Long opcionId){
        try {
            return opcionRepository.findById(opcionId).get();
        } catch (Exception e) {
            return null;
        }
    }

    //Actualizar Opcion
    public Opcion actualizarOpcion(Opcion nuevaOpcion){
        if (opcionRepository.existsById(nuevaOpcion.getOpcionId())) {
            return opcionRepository.save(nuevaOpcion);
        } else {
            return null;
        }
    }

    //Eliminar opcion
    public void eliminarOpcionId(Long idOpcion){
        if (opcionRepository.existsById(idOpcion)) {
            opcionRepository.deleteById(idOpcion);
        } else {
            throw new NoSuchElementException("No existe la opcion con id: " + idOpcion);
        }
    }


}
