package com.example.claseInyec10Sping.service;

import com.example.claseInyec10Sping.model.Proyecto;

import java.util.List;

public interface IproyectoService {
    Proyecto guardarProyecto(Proyecto proyecto);

    List<Proyecto> obtenerTodos();
}
