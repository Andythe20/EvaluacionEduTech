package com.example.EvaluacionEduTech.Service;

import java.util.List;

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

    public boolean existsByTextoOpcion(String opcion){
        return opcionRepository.existsByTextoOpcion(opcion);
    }

    public boolean existsById(Long idOpcion){
        return opcionRepository.existsById(idOpcion);
    }

    public Opcion findByTextoOpcion(String opcion){
        return opcionRepository.findByTextoOpcion(opcion);
    }

    //Obtener opcion por id
    public Opcion findById(Long opcionId){
        return opcionRepository.findById(opcionId).get();
    }

    //validar opcion
    public boolean validarOpcion(Opcion opcion){

        if (opcion.getTextoOpcion().isEmpty() || opcion.getTextoOpcion() == null
            || opcion.getPregunta() == null) {
            return false;
        }
        return true;
    }

    //guardar opcion
    public Opcion guardarOpcion(Opcion opcion){

        if (!validarOpcion(opcion)) {
            return null;
        }

        if (existsByTextoOpcion(opcion.getTextoOpcion())) {
            return null;
        }

        return opcionRepository.save(opcion);
        
    }

    //Actualizar Opcion
    public Opcion actualizarOpcion(Opcion nuevaOpcion){
        
        if (!validarOpcion(nuevaOpcion)) {
            throw new RuntimeException("El texto de la opción no es valida");
        }

        Opcion opcionEncontrada = opcionRepository.findById(nuevaOpcion.getOpcionId()).get();

        opcionEncontrada.setPregunta(nuevaOpcion.getPregunta());
        return opcionRepository.save(opcionEncontrada);
    }

    //Eliminar opcion
    public Opcion eliminarOpcionId(Long idOpcion){
        
        opcionRepository.deleteById(idOpcion);
        return null;
    }


}
