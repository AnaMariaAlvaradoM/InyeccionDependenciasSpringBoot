package com.example.claseInyec10Sping.service;

import com.example.claseInyec10Sping.model.Persona;

import java.util.List;

public interface IpersonaService {
    List<Persona> obtenerTodos();
    Persona obtenerPorId(Long id);
    void guardarPersona(Persona persona);
}
