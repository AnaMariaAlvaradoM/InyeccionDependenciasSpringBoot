package com.example.claseInyec10Sping.service;

import com.example.claseInyec10Sping.model.Persona;

import java.util.List;
import java.util.Optional;

public interface IpersonaService {
    List<Persona> obtenerTodos();
    Optional<Persona> obtenerPorId(Long id);
    void guardarPersona(Persona persona);

    //Metodo para eliminar persona
    void deletePersona(Long id);

    //Metodo para editar una persona
    void editarPersona(Long id, Persona personaActualizada);
}
