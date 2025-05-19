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

    @GetMapping()
    public List<Pregunta> listarPreguntas(){
        return preguntaService.listarPreguntas();
    }

    @PostMapping()
    public Pregunta guardarPregunta(@RequestBody Pregunta pregunta){
        return preguntaService.guardarPregunta(pregunta);
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
    
    @PutMapping("/{idPregunta}")
    public Pregunta actualizarPregunta(@PathVariable Long idPregunta, @RequestBody Pregunta pregunta){

            return preguntaService.actualizarPregunta(pregunta);

    }


    @DeleteMapping("/{idPregunta}")
    public void eliminarPreguntaId(@PathVariable Long idPregunta){
        try {
            preguntaService.eliminarPregunta(idPregunta);
        } catch (Exception e) {
        }
    }
}
