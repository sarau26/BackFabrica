package com.udea.Fabrica_g6_v2.models;

//import jakarta.persistence.*;
import lombok.Builder;

import javax.persistence.*;
@Entity
@Builder
@Table(name = "facultad")
public class Facultad {

    @Id
    private Long id;


    private String nombre;

    @OneToOne
    @JoinColumn(name = "id_decano", referencedColumnName = "id_decano",insertable = false, updatable = false)
    private Decano decano;


    @OneToOne
    @JoinColumn(name = "id_vicedecano", referencedColumnName = "id_vicedecano", insertable = false, updatable = false)
    private ViceDecano viceDecano;

    public Facultad() {
    }

    public Facultad(Long id, String nombre, Decano decano, ViceDecano viceDecano) {
        this.id = id;
        this.nombre = nombre;
        this.decano = decano;
        this.viceDecano = viceDecano;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Decano getDecano() {
        return decano;
    }

    public void setDecano(Decano decano) {
        this.decano = decano;
    }

    public ViceDecano getViceDecano() {
        return viceDecano;
    }

    public void setViceDecano(ViceDecano viceDecano) {
        this.viceDecano = viceDecano;
    }
}