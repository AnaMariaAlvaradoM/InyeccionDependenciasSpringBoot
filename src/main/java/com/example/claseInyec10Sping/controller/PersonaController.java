package com.example.claseInyec10Sping.controller;

import com.example.claseInyec10Sping.model.Persona;
import com.example.claseInyec10Sping.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private  final PersonaService personaService;
    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> listaPersonas(){
        return personaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Persona obtenerPorId(@PathVariable Long id){
        return personaService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarPersona(@RequestBody Persona persona){
        personaService.guardarPersona(persona);
        return ResponseEntity.ok("Persona agregada con éxito");
    }

}
