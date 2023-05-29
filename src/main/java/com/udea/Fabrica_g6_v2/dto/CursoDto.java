package com.udea.Fabrica_g6_v2.dto;

import com.udea.Fabrica_g6_v2.models.Materia;
import lombok.Data;

@Data
public class CursoDto {
    private Materia materia;
    private String programaAcademico;
    private Integer versionPensum;
    private Integer creditos;
    private Integer nivelAcademico;
    private Integer intensidadHoraria;
    private String sede;
    private Boolean gruposEspejo;
    private Boolean validable;
    private Boolean obligatorio;
    private Boolean habilitable;
}
