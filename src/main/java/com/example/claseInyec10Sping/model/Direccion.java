package com.example.claseInyec10Sping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_direccion;

    private String ciudad;
    private String calle;
    private String codigoPostal;

    @OneToOne
    @JoinColumn(name = "persona_id", unique = true)
    //@JsonBackReference
    private Persona persona;

    public Direccion() {}

    public Direccion(String ciudad, String calle, String codigoPostal) {
        this.ciudad = ciudad;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
    }

    // getters y setters
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Long id_direccion) {
        this.id_direccion = id_direccion;
    }
}
