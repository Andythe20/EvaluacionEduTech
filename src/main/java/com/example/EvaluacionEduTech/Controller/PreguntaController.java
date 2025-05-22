package com.example.EvaluacionEduTech.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EvaluacionEduTech.Model.Pregunta;
import com.example.EvaluacionEduTech.Service.PreguntaService;


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
        
        if (!preguntaService.existsById(idPregunta)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(preguntaService.buscarPreguntaId(idPregunta));
    }

    @PostMapping("/")
    public ResponseEntity<Pregunta> guardarPregunta(@RequestBody Pregunta pregunta){

        if (pregunta == null) {
            return ResponseEntity.badRequest().build();
        }
;
        return ResponseEntity.ok(preguntaService.guardarPregunta(pregunta));
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
        
        if (!preguntaService.existsById(idPregunta)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(preguntaService.eliminarPregunta(idPregunta));
    }
}
