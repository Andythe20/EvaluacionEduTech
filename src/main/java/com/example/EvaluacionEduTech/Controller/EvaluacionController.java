package com.example.EvaluacionEduTech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EvaluacionEduTech.Model.Evaluacion;
import com.example.EvaluacionEduTech.Service.EvaluacionService;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService service;

    //Obtener Evaluaciones
    @GetMapping("/")
    public ResponseEntity<List<Evaluacion>> listarEvaluaciones(){

        //cargar las evaluaciones
        List<Evaluacion> evaluaciones = service.listarEvaluaciones();

        if (evaluaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(evaluaciones);
    }

    //Obtener Evaluacion por id
    @GetMapping("/{evaluacionId}")
    public ResponseEntity<Evaluacion> BuscarPorId(@PathVariable Long evaluacionId) {

        if (service.getEvaluacionId(evaluacionId) == null) {
            ResponseEntity.noContent().build();
        }

        //encontrar evaluacion
        Evaluacion ev = service.getEvaluacionId(evaluacionId);

        return ResponseEntity.ok(ev);
    }

    //Agregar Evaluaciones
    @PostMapping("/")
    public ResponseEntity<Evaluacion> guardarEvaluacion(@RequestBody Evaluacion evaluacion){
        
        if (evaluacion == null){
            return ResponseEntity.badRequest().build();
        }

        service.guardarEvaluacion(evaluacion);
        return ResponseEntity.ok(service.getEvaluacionId(evaluacion.getEvaluacionId()));
    }

    //Actualizar Evaluacion
    @PutMapping("/")
    public ResponseEntity<Evaluacion> ActualizaEvaluacion(@RequestBody Evaluacion evaluacion) {        
        
        //verificar si esta nulo
        if (evaluacion == null) {
            return ResponseEntity.badRequest().build();
        }

        //verificar si existe
        if (!service.existsById(evaluacion.getEvaluacionId())) {
            return ResponseEntity.notFound().build();
        }
        
        service.actualizarEvaluacion(evaluacion);
        return ResponseEntity.ok(service.getEvaluacionId(evaluacion.getEvaluacionId()));
    }
    
    //Eliminar Evaluacion
    @DeleteMapping("/{evaluacionId}")
    public ResponseEntity<Evaluacion> EliminarEvaluacion(@PathVariable Long evaluacionId){

        //verificar si esta nulo
        if (evaluacionId == null) {
            return ResponseEntity.badRequest().build();
        }

        /*
        //verificar si existe
        if (!service.existsById(evaluacionId)) {
            return ResponseEntity.notFound().build();
        }
        */

        service.deleteEvaluacion(evaluacionId);
        return ResponseEntity.ok().build();
    }
}
