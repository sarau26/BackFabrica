package com.udea.Fabrica_g6_v2.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FacultadTest {
    private ViceDecano viceDecano;
    private Decano decano;

    @Test
    public void TestFacultad(){
        Facultad facultad = Facultad.builder()
                .id(1L)
                .nombre("Facultad de ingenieria")
                .decano(decano)
                .viceDecano(viceDecano)
                .build();
        assertEquals("Facultad de ingenieria", facultad.getNombre());
        assertEquals(1L, facultad.getId());
        assertEquals(decano, facultad.getDecano());
        assertEquals(viceDecano, facultad.getViceDecano());
    }

}