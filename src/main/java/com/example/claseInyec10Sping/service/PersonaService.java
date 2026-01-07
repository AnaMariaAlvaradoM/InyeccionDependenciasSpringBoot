package com.example.claseInyec10Sping.service;

import com.example.claseInyec10Sping.model.Persona;
import com.example.claseInyec10Sping.repository.IpersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IpersonaService{

    private final IpersonaRepository personaRepository;

    @Autowired
    public PersonaService(IpersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> obtenerTodos() {
        return personaRepository.findAll();
    }

    @Override
    public Persona obtenerPorId(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void guardarPersona(Persona persona) {
        personaRepository.save(persona);
    }
}
