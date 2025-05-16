package com.example.EvaluacionEduTech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<Opcion> listarOpciones(){
        return opcionService.listarOpciones();
    }

    @PostMapping()
    public Opcion guardarOpcion(@RequestBody Opcion opcion){
        return opcionService.guardarOpcion(opcion);
    }

    @GetMapping("/{idOpcion}")
    public ResponseEntity<Opcion> obtenerOpcionId(@PathVariable Long idOpcion){
        try {
            Opcion opcion = opcionService.obtenerOpcionId(idOpcion);
            return new ResponseEntity<>(opcion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

    @PutMapping()
    public Opcion actualizarOpcion(@RequestBody Opcion nuevaOpcion){
        try {
            return opcionService.actualizarOpcion(nuevaOpcion);
        } catch (Exception e) {
            return null;
        }
    }


    @DeleteMapping("/{idOpcion}")
    public ResponseEntity<Opcion> eliminarOpcionId(@PathVariable Long idOpcion){
        try {
            opcionService.eliminarOpcionId(idOpcion);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
