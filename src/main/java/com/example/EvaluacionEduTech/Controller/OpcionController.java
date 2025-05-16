package com.example.EvaluacionEduTech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EvaluacionEduTech.Model.Opcion;
import com.example.EvaluacionEduTech.Service.OpcionService;

@RestController
@RequestMapping("/api/v1/opciones")
public class OpcionController {
    
    @Autowired
    private OpcionService servicio;

    @GetMapping("/")
    public List<Opcion> listarOpciones(){
        return servicio.listarOpciones();
    }

    @PostMapping("/")
    public Opcion guardarOpcion(@RequestBody Opcion opcion){
        return servicio.guardarOpcion(opcion);
    }
}
