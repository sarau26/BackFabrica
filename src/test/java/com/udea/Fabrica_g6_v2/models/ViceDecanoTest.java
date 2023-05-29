package com.udea.Fabrica_g6_v2.models;

import com.udea.Fabrica_g6_v2.repository.ViceDecanoRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ViceDecanoTest {

    @Test
    public void testViceDecano() {

        ViceDecano viceDecano = ViceDecano.builder()
                .nombre("Juan Perez")
                .oficina("21-411")
                .email("juan.perez@udea.edu.co")
                .idPersona(1L)
                .nameFacultad("Ingeniería")
                .build();

        assertEquals(1L, viceDecano.getIdPersona().longValue());
        assertEquals("Juan Perez", viceDecano.getNombre());
        assertEquals("juan.perez@udea.edu.co", viceDecano.getEmail());
        assertEquals("21-411", viceDecano.getOficina());
        assertEquals("Ingeniería", viceDecano.getNameFacultad());
    }
}