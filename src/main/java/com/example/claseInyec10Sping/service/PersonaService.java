package com.example.claseInyec10Sping.service;

import com.example.claseInyec10Sping.model.Direccion;
import com.example.claseInyec10Sping.model.Mascota;
import com.example.claseInyec10Sping.model.Persona;
import com.example.claseInyec10Sping.model.Proyecto;
import com.example.claseInyec10Sping.repository.IpersonaRepository;
import com.example.claseInyec10Sping.repository.ProyectoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonaService implements IpersonaService {

    private final IpersonaRepository personaRepository;
    private final ProyectoRepository proyectoRepository;

    public PersonaService(IpersonaRepository personaRepository,
                          ProyectoRepository proyectoRepository) {
        this.personaRepository = personaRepository;
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public List<Persona> obtenerTodos() {
        return personaRepository.findAll();
    }


//    public Optional<Persona> obtenerPorId(Long id) {
//        return personaRepository.findById(id);
//    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Persona> obtenerPorId(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow();

        persona.getProyectos().size();

        return Optional.of(persona);
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona agregarMascota(Long personaId, Mascota mascota) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        mascota.setDueno(persona);
        persona.getMascotas().add(mascota);

        return personaRepository.save(persona);
    }

    @Override
    public Persona asignarDireccion(Long personaId, Direccion direccion) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        direccion.setPersona(persona);
        persona.setDireccion(direccion);

        return personaRepository.save(persona);
    }

    @Override
    public Persona asignarProyecto(Long personaId, Long proyectoId) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        persona.getProyectos().add(proyecto);

        return personaRepository.save(persona);
    }

    @Transactional(readOnly = true)
    @Override
    public Set<Proyecto> obtenerProyectosDePersona(Long personaId) {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        //! FORZAMOS la inicialización dentro de la transacción
        persona.getProyectos().size();

        return persona.getProyectos();
    }

}
