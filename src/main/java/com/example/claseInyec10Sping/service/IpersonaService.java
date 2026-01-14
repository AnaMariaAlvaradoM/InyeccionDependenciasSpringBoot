
package com.example.claseInyec10Sping.service;

import com.example.claseInyec10Sping.model.Direccion;
import com.example.claseInyec10Sping.model.Mascota;
import com.example.claseInyec10Sping.model.Persona;
import com.example.claseInyec10Sping.model.Proyecto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IpersonaService {

    List<Persona> obtenerTodos();

    Optional<Persona> obtenerPorId(Long id);

    Persona guardarPersona(Persona persona);

    Persona agregarMascota(Long personaId, Mascota mascota);

    Persona asignarDireccion(Long personaId, Direccion direccion);

    Persona asignarProyecto(Long personaId, Long proyectoId);
    Set<Proyecto> obtenerProyectosDePersona(Long personaId);

}
