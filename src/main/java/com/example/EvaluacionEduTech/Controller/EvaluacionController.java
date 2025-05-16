package com.example.EvaluacionEduTech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EvaluacionEduTech.Model.Evaluacion;
import com.example.EvaluacionEduTech.Service.EvaluacionService;

@RestController
@RequestMapping("/api/v1/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService service;

    @GetMapping("/")
    public List<Evaluacion> listarEvaluaciones(){
        return service.listarEvaluaciones();
    }

    @PostMapping("/")
    public Evaluacion guardarEvaluacion(@RequestBody Evaluacion evaluacion){
        return service.guardarEvaluacion(evaluacion);
    }

}
