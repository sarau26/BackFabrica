package com.udea.Fabrica_g6_v2.models;

//import jakarta.persistence.*;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@Table(name = "calendario")
public class Calendario {


    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_facultad", referencedColumnName = "id")
    private Facultad facultad;



    private String semestre;
    @JoinColumn(name = "publicacion_oferta")
    private LocalDate publicacionOferta;

    @JoinColumn(name = "inicio_matriculas")
    private LocalDate inicioMatriculas;

    @JoinColumn(name = "fin_matriculas")
    private LocalDate finMatriculas;

    @JoinColumn(name = "inicio_ajustes")
    private LocalDate inicioAjustes;

    @JoinColumn(name = "fin_ajustes")
    private LocalDate finAjustes;

    @JoinColumn(name = "inicio_clases")
    private LocalDate inicioClases;

    @JoinColumn(name = "fin_clases")
    private LocalDate finClases;

    @JoinColumn(name = "inicio_examenes_finales")
    private LocalDate inicioExamenesFinales;

    @JoinColumn(name = "fin_examenes_finales")
    private LocalDate finExamenesFinales;

    @JoinColumn(name = "inicio_validaciones")
    private LocalDate inicioValidaciones;

    @JoinColumn(name = "fin_validaciones")
    private LocalDate finValidaciones;

    @JoinColumn(name = "inicio_habilitaciones")
    private LocalDate inicioHabilitaciones;

    @JoinColumn(name = "fin_habilitaciones")
    private LocalDate finHabilitaciones;

    @JoinColumn(name = "terminacion_oficial")
    private LocalDate terminacionOficinal;

    // Constructor, getters y setters

    public Calendario() {
    }

    public Calendario( Facultad facultad, String semestre, LocalDate publicacionOferta, LocalDate inicioMatriculas, LocalDate finMatriculas, LocalDate inicioAjustes, LocalDate finAjustes, LocalDate inicioClases, LocalDate finClases, LocalDate inicioExamenesFinales, LocalDate finExamenesFinales, LocalDate inicioValidaciones, LocalDate finValidaciones, LocalDate inicioHabilitaciones, LocalDate finHabilitaciones, LocalDate terminacionOficinal) {
        this.id = (facultad.getId()+"-"+semestre);
        this.facultad = facultad;
        this.semestre = semestre;
        this.publicacionOferta = publicacionOferta;
        this.inicioMatriculas = inicioMatriculas;
        this.finMatriculas = finMatriculas;
        this.inicioAjustes = inicioAjustes;
        this.finAjustes = finAjustes;
        this.inicioClases = inicioClases;
        this.finClases = finClases;
        this.inicioExamenesFinales = inicioExamenesFinales;
        this.finExamenesFinales = finExamenesFinales;
        this.inicioValidaciones = inicioValidaciones;
        this.finValidaciones = finValidaciones;
        this.inicioHabilitaciones = inicioHabilitaciones;
        this.finHabilitaciones = finHabilitaciones;
        this.terminacionOficinal = terminacionOficinal;
    }

    public String getId() {
        return (facultad.getId()+"-"+semestre);
    }
    private void generarId() {
        // Lógica para generar el ID a partir de columna1 y columna2
        this.id = facultad.getId()+"-"+semestre;}



    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
        generarId();
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
        generarId();
    }



    public LocalDate getPublicacionOferta() {
        return publicacionOferta;
    }

    public void setPublicacionOferta(LocalDate publicacionOferta) {
        this.publicacionOferta = publicacionOferta;
    }

    public LocalDate getInicioMatriculas() {
        return inicioMatriculas;
    }

    public void setInicioMatriculas(LocalDate inicioMatriculas) {
        this.inicioMatriculas = inicioMatriculas;
    }

    public LocalDate getFinMatriculas() {
        return finMatriculas;
    }

    public void setFinMatriculas(LocalDate finMatriculas) {
        this.finMatriculas = finMatriculas;
    }

    public LocalDate getInicioAjustes() {
        return inicioAjustes;
    }

    public void setInicioAjustes(LocalDate inicioAjustes) {
        this.inicioAjustes = inicioAjustes;
    }

    public LocalDate getFinAjustes() {
        return finAjustes;
    }

    public void setFinAjustes(LocalDate finAjustes) {
        this.finAjustes = finAjustes;
    }

    public LocalDate getInicioClases() {
        return inicioClases;
    }

    public void setInicioClases(LocalDate inicioClases) {
        this.inicioClases = inicioClases;
    }

    public LocalDate getFinClases() {
        return finClases;
    }

    public void setFinClases(LocalDate finClases) {
        this.finClases = finClases;
    }

    public LocalDate getInicioExamenesFinales() {
        return inicioExamenesFinales;
    }

    public void setInicioExamenesFinales(LocalDate inicioExamenesFinales) {
        this.inicioExamenesFinales = inicioExamenesFinales;
    }

    public LocalDate getFinExamenesFinales() {
        return finExamenesFinales;
    }

    public void setFinExamenesFinales(LocalDate finExamenesFinales) {
        this.finExamenesFinales = finExamenesFinales;
    }

    public LocalDate getInicioValidaciones() {
        return inicioValidaciones;
    }

    public void setInicioValidaciones(LocalDate inicioValidaciones) {
        this.inicioValidaciones = inicioValidaciones;
    }

    public LocalDate getFinValidaciones() {
        return finValidaciones;
    }

    public void setFinValidaciones(LocalDate finValidaciones) {
        this.finValidaciones = finValidaciones;
    }

    public LocalDate getInicioHabilitaciones() {
        return inicioHabilitaciones;
    }

    public void setInicioHabilitaciones(LocalDate inicioHabilitaciones) {
        this.inicioHabilitaciones = inicioHabilitaciones;
    }

    public LocalDate getFinHabilitaciones() {
        return finHabilitaciones;
    }

    public void setFinHabilitaciones(LocalDate finHabilitaciones) {
        this.finHabilitaciones = finHabilitaciones;
    }

    public LocalDate getTerminacionOficinal() {
        return terminacionOficinal;
    }

    public void setTerminacionOficinal(LocalDate terminacionOficinal) {
        this.terminacionOficinal = terminacionOficinal;
    }
}