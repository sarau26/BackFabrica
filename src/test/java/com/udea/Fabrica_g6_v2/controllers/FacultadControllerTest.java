package com.udea.Fabrica_g6_v2.controllers;

import com.udea.Fabrica_g6_v2.controllers.FacultadController;
import com.udea.Fabrica_g6_v2.models.Decano;
import com.udea.Fabrica_g6_v2.models.Facultad;
import com.udea.Fabrica_g6_v2.models.ViceDecano;
import com.udea.Fabrica_g6_v2.services.FacultadService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FacultadControllerTest {

    @InjectMocks
    private FacultadController facultadController;

    @Mock
    private FacultadService facultadService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Decano decano = new Decano(1L, "Andrés David", "juan.perez@udea.edu.co", "21-411", "Ingeniería");

        ViceDecano viceDecano = new ViceDecano();
        viceDecano.setIdPersona(1L);
        viceDecano.setNombre("Victor Restrepo");
        viceDecano.setEmail("Andrés.rodriguez@udea.edu.co");
        viceDecano.setOficina("21-412");
        viceDecano.setNameFacultad("Ingeniería");

        List<Facultad> facultades = new ArrayList<>();
        facultades.add(new Facultad(1L, "Facultad 1", decano, viceDecano));
        facultades.add(new Facultad(2L, "Facultad 2", decano, viceDecano));

        when(facultadService.findAll()).thenReturn(facultades);

        List<Facultad> result = facultadController.findAll();
        assertEquals(2, result.size());
        assertEquals("Andrés David", result.get(0).getDecano().getNombre());
        assertEquals("Victor Restrepo", result.get(0).getViceDecano().getNombre());
        assertEquals("Andrés David", result.get(1).getDecano().getNombre());
        assertEquals("Victor Restrepo", result.get(1).getViceDecano().getNombre());
        verify(facultadService, times(1)).findAll();
    }

    @Test
    public void testSave() {
        Facultad facultad = new Facultad(1L, "Facultad 1", null, null);
        when(facultadService.save(facultad)).thenReturn(new ResponseEntity<>(facultad, HttpStatus.CREATED));

        ResponseEntity<Facultad> result = facultadController.save(facultad);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        verify(facultadService, times(1)).save(facultad);
    }

    @Test
    public void testFindById() {
        Facultad facultad = new Facultad(1L, "Facultad 1", null, null);
        when(facultadService.findById(1L)).thenReturn(new ResponseEntity<>(facultad, HttpStatus.OK));

        ResponseEntity<Facultad> result = facultadController.findById(1L);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(facultadService, times(1)).findById(1L);
    }

    @Test
    public void testDelete() {
        when(facultadService.delete(1L)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        ResponseEntity<Facultad> result = facultadController.delete(1L);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(facultadService, times(1)).delete(1L);
    }

    @Test
    public void testUpdate() {
        Facultad facultad = new Facultad(1L, "Facultad 1", null, null);
        when(facultadService.update(facultad)).thenReturn(new ResponseEntity<>(facultad, HttpStatus.OK));

        ResponseEntity<Facultad> result = facultadController.update(facultad);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(facultadService, times(1)).update(facultad);
    }
}
