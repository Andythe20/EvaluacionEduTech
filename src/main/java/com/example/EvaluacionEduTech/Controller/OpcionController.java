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

import com.example.EvaluacionEduTech.Model.Opcion;
import com.example.EvaluacionEduTech.Service.OpcionService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/opciones")
public class OpcionController {
    
    @Autowired
    private OpcionService opcionService;

    @GetMapping("/")
    public ResponseEntity<List<Opcion>> listarOpciones(){

        List<Opcion> opciones = opcionService.listarOpciones();

        if (opciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(opciones);
    }

    @GetMapping("/{idOpcion}")
    public ResponseEntity<Opcion> obtenerOpcionId(@PathVariable Long idOpcion){
        
        if (!opcionService.existsById(idOpcion)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(opcionService.findById(idOpcion));
    }

    @PostMapping("/")
    public ResponseEntity<Opcion> guardarOpcion(@RequestBody Opcion opcion){

        if (opcion == null){
            return ResponseEntity.badRequest().build();
        }

        opcionService.guardarOpcion(opcion);
        return ResponseEntity.ok(opcionService.findById(opcion.getOpcionId()));
    }    

    @PutMapping("/")
    public Opcion actualizarOpcion(@RequestBody Opcion nuevaOpcion){
        
        if (nuevaOpcion == null) {
            return null;
        }

        if (!opcionService.existsById(nuevaOpcion.getOpcionId())) {
            return null;
        }

        return opcionService.actualizarOpcion(nuevaOpcion);
            
        
    }


    @DeleteMapping("/{idOpcion}")
    public ResponseEntity<Opcion> eliminarOpcionId(@PathVariable Long idOpcion){
        
        if (!opcionService.existsById(idOpcion)) {
            return ResponseEntity.notFound().build();
        }

        opcionService.eliminarOpcionId(idOpcion);
        return ResponseEntity.ok().build();
            
        
    }

}
