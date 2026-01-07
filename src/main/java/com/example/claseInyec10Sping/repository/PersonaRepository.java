package com.example.claseInyec10Sping.repository;

import com.example.claseInyec10Sping.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepository implements IpersonaRepository{
    private final List<Persona> personas = new ArrayList<>();

    public PersonaRepository(){
        personas.add(new Persona(1L, "Angie", "Desarrolladora"));
        personas.add(new Persona(2L, "Luis", "Desarrollador"));
    }

    @Override
    public List<Persona> findAll() {
        return personas;
    }

    @Override
    public Persona findById(Long id) {
        for(Persona persona : personas) {
            if (persona.getId_Persona().equals(id)) {
                return persona;
            }
        }
        return null;
    }

    @Override
    public void save(Persona persona) {
        personas.add(persona);
    }
}
