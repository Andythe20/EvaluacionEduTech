package com.example.EvaluacionEduTech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EvaluacionEduTech.Model.Pregunta;
import com.example.EvaluacionEduTech.Service.PreguntaService;

@RestController
@RequestMapping("/api/v1/preguntas")
public class PreguntaController {
    
    @Autowired
    private PreguntaService servicio;

    @GetMapping("/")
    public List<Pregunta> listarPreguntas(){
        return servicio.listarPreguntas();
    }

    @PostMapping("/")
    public Pregunta guardarPregunta(@RequestBody Pregunta pregunta){
        return servicio.guardarPregunta(pregunta);
    }
}
