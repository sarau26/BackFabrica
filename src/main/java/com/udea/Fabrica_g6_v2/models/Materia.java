package com.udea.Fabrica_g6_v2.models;


import com.udea.Fabrica_g6_v2.repositories.MateriaRepository;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "materia")
@Data
public class Materia {

    @Id
    @Column(name = "id_materia")
    private Integer idMateria;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "linea_enfasis")
    private String lineaEnfasis;

    public Materia() {
    }

    public Materia(Integer idMateria) {
        this.idMateria = idMateria;
    }
}

