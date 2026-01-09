package com.example.claseInyec10Sping.controller;

import com.example.claseInyec10Sping.model.Persona;
import com.example.claseInyec10Sping.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Persona> obtenerPorId(@PathVariable Long id){
        return personaService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarPersona(@RequestBody Persona persona){
        personaService.guardarPersona(persona);
        return ResponseEntity.ok("Persona agregada con éxito");
    }

    @DeleteMapping ("/borrar/{id}")

    public ResponseEntity<String> deletePersona(@PathVariable Long id) {
        personaService.deletePersona(id);
        return ResponseEntity.ok("Persona elimina con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPersonas(@PathVariable Long id, @RequestBody Persona personaActualizada){
        personaService.editarPersona(id, personaActualizada);
        return  ResponseEntity.ok("Persona actualizada con exito");
    }

}
