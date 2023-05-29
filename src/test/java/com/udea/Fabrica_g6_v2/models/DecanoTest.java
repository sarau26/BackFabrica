package com.udea.Fabrica_g6_v2.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecanoTest {

    @Test
    public void testDecano() {

        Decano decano = Decano.builder()
                .nombre("Juan Perez")
                .oficina("21-411")
                .email("juan.perez@udea.edu.co")
                .idPersona(1L)
                .nameFacultad("Ingeniería")
                .build();

        assertEquals(1L, decano.getIdPersona().longValue());
        assertEquals("Juan Perez", decano.getNombre());
        assertEquals("juan.perez@udea.edu.co", decano.getEmail());
        assertEquals("21-411", decano.getOficina());
        assertEquals("Ingeniería", decano.getNameFacultad());
    }
}