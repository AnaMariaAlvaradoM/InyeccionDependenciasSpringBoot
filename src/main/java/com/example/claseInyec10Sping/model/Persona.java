package com.example.claseInyec10Sping.model;

public class Persona {
    private Long id_Persona;
    private String nombre;
    private String cargo;

    public Persona() {
    }

    public Persona(Long id_Persona, String nombre, String cargo) {
        this.id_Persona = id_Persona;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public Long getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Long id_Persona) {
        this.id_Persona = id_Persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
