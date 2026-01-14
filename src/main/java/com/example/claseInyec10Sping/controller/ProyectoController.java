package com.example.claseInyec10Sping.controller;

import com.example.claseInyec10Sping.model.Proyecto;
import com.example.claseInyec10Sping.service.IproyectoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    private final IproyectoService proyectoService;

    public ProyectoController(IproyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @PostMapping
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.guardarProyecto(proyecto);
    }

    @GetMapping
    public List<Proyecto> listarProyectos() {
        return proyectoService.obtenerTodos();
    }
}
