package com.udea.Fabrica_g6_v2.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="aula")
@Data
public class Aula {

    @Column(name = "id_aula", nullable=false )
    @Id
    private String id;

    private Integer bloque;
    private Integer salon;
    private Integer capacidad;

    public Aula() {
    }

    public Aula(Integer bloque, Integer salon, Integer capacidad) {
        this.id = (bloque+"-"+salon);
        this.bloque = bloque;
        this.salon = salon;
        this.capacidad = capacidad;
    }

    public String getId() {
        return (bloque+"-"+salon);
    }

    public void setIdAula() {
        this.id = (bloque+"-"+salon);
    }

    public Integer getBloque() {
        return bloque;
    }

    public void setBloque(Integer bloque) {
        this.bloque = bloque;
        setIdAula();
    }

    public Integer getSalon() {
        return salon;
    }

    public void setSalon(Integer salon) {
        this.salon = salon;
        setIdAula();
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
