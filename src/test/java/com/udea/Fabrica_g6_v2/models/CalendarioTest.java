package com.udea.Fabrica_g6_v2.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalendarioTest {
    private Calendario calendario;

    @Test
    public void testCalendario(){

        Decano decano = new Decano(1L, "Juan Perez", "juan.perez@udea.edu.co", "21-411", "Ingeniería");

        ViceDecano viceDecano = new ViceDecano();
        viceDecano.setIdPersona(1L);
        viceDecano.setNombre("Maria Rodriguez");
        viceDecano.setEmail("maria.rodriguez@udea.edu.co");
        viceDecano.setOficina("21-412");
        viceDecano.setNameFacultad("Ingeniería");

        Facultad facultad = new Facultad(1L, "Ingeniería", decano, viceDecano);

        String semestre = "2022-1";
        LocalDate publicacionOferta = LocalDate.of(2022, 1, 1);
        LocalDate inicioMatriculas = LocalDate.of(2022, 1, 15);
        LocalDate finMatriculas = LocalDate.of(2022, 1, 31);
        LocalDate inicioAjustes = LocalDate.of(2022, 2, 1);
        LocalDate finAjustes = LocalDate.of(2022, 2, 15);
        LocalDate inicioClases = LocalDate.of(2022, 2, 16);
        LocalDate finClases = LocalDate.of(2022, 6, 15);
        LocalDate inicioExamenesFinales = LocalDate.of(2022, 6, 16);
        LocalDate finExamenesFinales = LocalDate.of(2022, 6, 30);
        LocalDate inicioValidaciones = LocalDate.of(2022, 7, 1);
        LocalDate finValidaciones = LocalDate.of(2022, 7, 15);
        LocalDate inicioHabilitaciones = LocalDate.of(2022, 7, 16);
        LocalDate finHabilitaciones = LocalDate.of(2022, 7, 31);
        LocalDate terminacionOficinal = LocalDate.of(2022, 8, 1);

        Calendario calendario = new Calendario(facultad,
                semestre,
                publicacionOferta,
                inicioMatriculas,
                finMatriculas,
                inicioAjustes,
                finAjustes,
                inicioClases,
                finClases,
                inicioExamenesFinales,
                finExamenesFinales,
                inicioValidaciones,
                finValidaciones,
                inicioHabilitaciones,
                finHabilitaciones,
                terminacionOficinal);


        //assertEquals(facultad.getId() + "-" + semestre, calendario.getId());
        //assertEquals(facultad.getId(), calendario.getFacultad().getId());
        assertEquals(semestre, calendario.getSemestre());
        assertEquals(publicacionOferta, calendario.getPublicacionOferta());
        assertEquals(inicioMatriculas, calendario.getInicioMatriculas());
        assertEquals(finMatriculas, calendario.getFinMatriculas());
        assertEquals(inicioAjustes, calendario.getInicioAjustes());
        assertEquals(finAjustes, calendario.getFinAjustes());
        assertEquals(inicioClases, calendario.getInicioClases());
        assertEquals(finClases, calendario.getFinClases());
        assertEquals(inicioExamenesFinales, calendario.getInicioExamenesFinales());
        assertEquals(finExamenesFinales, calendario.getFinExamenesFinales());
        assertEquals(inicioValidaciones, calendario.getInicioValidaciones());
        assertEquals(finValidaciones, calendario.getFinValidaciones());
        assertEquals(inicioHabilitaciones, calendario.getInicioHabilitaciones());
        assertEquals(finHabilitaciones, calendario.getFinHabilitaciones());
        assertEquals(terminacionOficinal, calendario.getTerminacionOficinal());


    }





}