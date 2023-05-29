package com.udea.Fabrica_g6_v2.models;

import com.udea.Fabrica_g6_v2.dto.CursoDto;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "curso")
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_curso")
    private Integer codigoCurso;

    @OneToOne
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia")
    private Materia materia;

    @Column(name = "programa_academico", updatable = false)
    private String programaAcademico;

    @Column(name = "version_pensum", updatable = false)
    private Integer versionPensum;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "nivel_academico")
    private Integer nivelAcademico;

    @Column(name = "intensidad_horaria")
    private Integer intensidadHoraria;

    @Column(name = "sede")
    private String sede;

    @Column(name = "grupos_espejo")
    private Boolean gruposEspejo;

    @Column(name = "validable")
    private Boolean validable;

    @Column(name = "obligatorio")
    private Boolean obligatorio;

    @Column(name = "habilitable")
    private Boolean habilitable;

    public void fillFromDto(CursoDto dto){
        programaAcademico = dto.getProgramaAcademico();
        versionPensum = dto.getVersionPensum();
        creditos = dto.getCreditos();
        nivelAcademico = dto.getNivelAcademico();
        intensidadHoraria = dto.getIntensidadHoraria();
        sede = dto.getSede();
        gruposEspejo = dto.getGruposEspejo();
        validable = dto.getValidable();
        obligatorio = dto.getObligatorio();
        habilitable = dto.getHabilitable();
    }
}
