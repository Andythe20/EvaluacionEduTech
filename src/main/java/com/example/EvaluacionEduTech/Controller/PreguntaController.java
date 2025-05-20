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

import com.example.EvaluacionEduTech.Model.Pregunta;
import com.example.EvaluacionEduTech.Service.PreguntaService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/preguntas")
public class PreguntaController {
    
    @Autowired
    private PreguntaService preguntaService;

    @GetMapping("/")
    public ResponseEntity<List<Pregunta>> listarPreguntas(){

        //cargamos las preguntas
        List<Pregunta> preguntas =  preguntaService.listarPreguntas();

        if (preguntas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/{idPregunta}")
    public ResponseEntity<Pregunta> buscarPreguntaId(@PathVariable Long idPregunta){
        try {
            Pregunta pregunta = preguntaService.buscarPreguntaId(idPregunta);
            return new ResponseEntity<>(pregunta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Pregunta> guardarPregunta(@RequestBody Pregunta pregunta){

        if (pregunta == null) {
            return ResponseEntity.badRequest().build();
        }

        preguntaService.guardarPregunta(pregunta);
        Pregunta preg = preguntaService.buscarPreguntaId(pregunta.getPreguntaId());
        return ResponseEntity.ok(preg);
    }
    
    @PutMapping("/")
    public ResponseEntity<Pregunta> actualizarPregunta(@RequestBody Pregunta pregunta){

        //verificar que no venga nulo
        if (pregunta == null) {
            return ResponseEntity.badRequest().build();
        }
        
        //verificasr si existe
        if (!preguntaService.existsById(pregunta.getPreguntaId())) {
            return ResponseEntity.notFound().build();
        }

        preguntaService.actualizarPregunta(pregunta);
        return ResponseEntity.ok(preguntaService.buscarPreguntaId(pregunta.getPreguntaId()));

    }


    @DeleteMapping("/{idPregunta}")
    public ResponseEntity<Pregunta> eliminarPreguntaId(@PathVariable Long idPregunta){
        try {

            preguntaService.eliminarPregunta(idPregunta);
            return ResponseEntity.ok().build();

        } catch (Exception e) {

            return ResponseEntity.notFound().build();
        }
    }
}
