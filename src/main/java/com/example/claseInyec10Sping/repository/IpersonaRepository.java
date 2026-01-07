package com.example.claseInyec10Sping.repository;

import com.example.claseInyec10Sping.model.Persona;

import java.util.List;

public interface IpersonaRepository {
    List<Persona> findAll();
    Persona findById(Long id);
    void save (Persona persona);
}
