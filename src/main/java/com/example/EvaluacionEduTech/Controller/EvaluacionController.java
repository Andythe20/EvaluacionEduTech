package com.example.EvaluacionEduTech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping()
    public List<Evaluacion> listarEvaluaciones(){
        return service.listarEvaluaciones();
    }

    //Agregar Evaluaciones
    @PostMapping()
    public Evaluacion guardarEvaluacion(@RequestBody Evaluacion evaluacion){
        return service.guardarEvaluacion(evaluacion);
    }

    //Obtener Evaluacion por id
    @GetMapping("/{evaluacionId}")
    public Evaluacion BuscarPorId(@PathVariable Long evaluacionId) {
        return service.getEvaluacionId(evaluacionId);
    }

    //Actualizar Evaluacion
    @PutMapping("/{evaluacionId}")
    public Evaluacion ActualizaEvaluacion(@RequestBody Evaluacion evaluacion,@PathVariable Long evaluacionId) {        
        return service.actualizarEvaluacion(evaluacion);
    }
    
    //Eliminar Evaluacion
    @DeleteMapping("/{evaluacionId}")
    public void EliminarEvaluacion(@PathVariable Long evaluacionId){
        service.deleteEvaluacion(evaluacionId);
    }
}
