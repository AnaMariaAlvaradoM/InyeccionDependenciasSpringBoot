package com.example.claseInyec10Sping.controller;

import com.example.claseInyec10Sping.model.Direccion;
import com.example.claseInyec10Sping.model.Mascota;
import com.example.claseInyec10Sping.model.Persona;
import com.example.claseInyec10Sping.model.Proyecto;
import com.example.claseInyec10Sping.service.IpersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final IpersonaService personaService;

    public PersonaController(IpersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> listaPersonas() {
        return personaService.obtenerTodos();
    }

    @PostMapping("/crear")
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.guardarPersona(persona);
    }

    @GetMapping("/{id}")
    public Persona obtenerPersona(@PathVariable Long id) {
        return personaService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @PostMapping("/{id}/mascotas")
    public Persona agregarMascota(
            @PathVariable Long id,
            @RequestBody Mascota mascota) {

        return personaService.agregarMascota(id, mascota);
    }

    @PutMapping("/{id}/direccion")
    public Persona asignarDireccion(
            @PathVariable Long id,
            @RequestBody Direccion direccion) {

        return personaService.asignarDireccion(id, direccion);
    }

    @PostMapping("/{personaId}/proyectos/{proyectoId}")
    public Persona asignarProyecto(
            @PathVariable Long personaId,
            @PathVariable Long proyectoId) {

        return personaService.asignarProyecto(personaId, proyectoId);
    }

    @GetMapping("/{id}/proyectos")
    public Set<Proyecto> obtenerProyectos(@PathVariable Long id) {
        return personaService.obtenerProyectosDePersona(id);
    }

}


//@RestController
//@RequestMapping("/personas")
//public class PersonaController {
//    private  final PersonaService personaService;
//    @Autowired
//    public PersonaController(PersonaService personaService) {
//        this.personaService = personaService;
//    }
//
//    @GetMapping
//    public List<Persona> listaPersonas(){
//        return personaService.obtenerTodos();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Persona> obtenerPorId(@PathVariable Long id){
//        return personaService.obtenerPorId(id);
//    }
//
//    @PostMapping("/crear")
//    public ResponseEntity<String> guardarPersona(@RequestBody Persona persona){
//        personaService.guardarPersona(persona);
//        return ResponseEntity.ok("Persona agregada con éxito");
//    }
//
//    @DeleteMapping ("/borrar/{id}")
//    public ResponseEntity<String> deletePersona(@PathVariable Long id) {
//        personaService.deletePersona(id);
//        return ResponseEntity.ok("Persona elimina con éxito");
//    }
//
//    @PutMapping("/editar/{id}")
//    public ResponseEntity<String> editarPersonas(@PathVariable Long id, @RequestBody Persona personaActualizada){
//        personaService.editarPersona(id, personaActualizada);
//        return  ResponseEntity.ok("Persona actualizada con exito");
//    }
//
//    @PostMapping("/{id}/mascotas")
//    public Persona agregarMascota(
//            @PathVariable Long id,
//            @RequestBody Mascota mascota) {
//
//        Persona persona = personaService.obtenerPorId(id)
//                .orElseThrow();
//
//        mascota.setDueno(persona);
//        persona.getMascotas().add(mascota);
//
//        return personaService.guardarPersona(persona);
//    }
//
//    @PutMapping("/{id}/direccion")
//    public ResponseEntity<Persona> asignarDireccion(
//            @PathVariable Long id,
//            @RequestBody Direccion direccion) {
//
//        Persona persona = personaService.obtenerPorId(id)
//                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
//
//        // relación bidireccional
//        direccion.setPersona(persona);
//        persona.setDireccion(direccion);
//
//        Persona personaGuardada = personaService.guardarPersona(persona);
//
//        return ResponseEntity.ok(personaGuardada);
//    }
//
//
//}
