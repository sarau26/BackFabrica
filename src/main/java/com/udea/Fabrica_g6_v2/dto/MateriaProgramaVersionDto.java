package com.udea.Fabrica_g6_v2.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class MateriaProgramaVersionDto {
    private Integer idMateria;
    private String programaAcademico;
    private Integer versionPensum;

    public MateriaProgramaVersionDto(){} //Necesario para serializar el Json
    public MateriaProgramaVersionDto(Integer idMateria, String programaAcademico, Integer versionPensum) {
        this.idMateria = idMateria;
        this.programaAcademico = programaAcademico;
        this.versionPensum = versionPensum;
    }


    public boolean hasNull() {
        return idMateria == null || programaAcademico == null || versionPensum == null;
    }
}
