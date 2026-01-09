package com.example.claseInyec10Sping.service;

import com.example.claseInyec10Sping.model.Persona;
import com.example.claseInyec10Sping.repository.IpersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Persona> obtenerPorId(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void guardarPersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public void editarPersona(Long id, Persona personaActualizada) {
        //Saber si exsite
        Persona personaExistente = personaRepository.findById(id).orElse(null);

        if (personaExistente != null){
            //Actualizar los campos de persona existente
            personaExistente.setNombre(personaActualizada.getNombre());
            personaExistente.setCargo(personaActualizada.getCargo());

            // Guardo a la persona actualziada
            personaRepository.save(personaExistente);
        } else {
            throw new RuntimeException("Persona no encontrada con el id: " + id);
        }
    }
}
