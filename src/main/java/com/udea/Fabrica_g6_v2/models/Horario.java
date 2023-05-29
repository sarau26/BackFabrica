package com.udea.Fabrica_g6_v2.models;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="horario")
public class Horario {
    @Column(name = "id", nullable=false )
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name="id_aula", referencedColumnName = "id_aula",insertable = false, updatable = false)
    private Aula id_aula;
    @ManyToOne
    @JoinColumn(name="id_grupo", referencedColumnName = "id_grupo",insertable = false, updatable = false)
    private Grupo id_grupo;
    @Column(name="dia")
    private String dia;
    @Column(name="hora_inicio")
    private Time hora_inicio;
    @Column(name="hora_fin")
    private Time hora_fin;

    public Horario() {
    }

    public Horario( Aula id_aula, Grupo id_grupo, String dia, Time hora_inicio, Time hora_fin) {
        this.id = (id_aula.getId()+"-"+dia+"-"+hora_inicio);
        this.id_aula = id_aula;
        this.id_grupo = id_grupo;
        this.dia = dia;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public String getId() {
        return (id_aula.getId()+"-"+dia+"-"+hora_inicio);
    }

    public void setId() {
        this.id = (id_aula.getId()+"-"+dia+"-"+hora_inicio);
    }

    public Aula getId_aula() {
        return id_aula;
    }

    public void setId_aula(Aula id_aula) {
        this.id_aula = id_aula;
        setId();
    }

    public Grupo getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(Grupo id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
        setId();
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
        setId();
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }
}
