package com.udea.Fabrica_g6_v2.models;

import javax.persistence.*;

@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @Column(name = "id_docente")
    private Long id;

    @Column(name = "tipo_contrato")
    private String tipoContrato;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email", unique = true)
    private String email;

    public Docente() {
    }

    public Docente(Long id, String tipoContrato, String nombre, String email) {
        this.id = id;
        this.tipoContrato = tipoContrato;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
