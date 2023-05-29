package com.udea.Fabrica_g6_v2.controllers;

import com.udea.Fabrica_g6_v2.controllers.DecanoController;
import com.udea.Fabrica_g6_v2.models.Decano;
import com.udea.Fabrica_g6_v2.services.DecanoService;
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

public class DecanoControllerTest {

    @InjectMocks
    private DecanoController decanoController;

    @Mock
    private DecanoService decanoService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Decano> decanos = new ArrayList<>();
        decanos.add(new Decano(1L, "Andrés David", "johndoe@example.com", "Office 1", "Facultad 1"));
        decanos.add(new Decano(2L, "Victor Restrepo", "janedoe@example.com", "Office 2", "Facultad 2"));

        when(decanoService.findAll()).thenReturn(decanos);

        List<Decano> result = decanoController.findAll();
        assertEquals(2, result.size());
        assertEquals("Andrés David", result.get(0).getNombre());
        assertEquals("Victor Restrepo", result.get(1).getNombre());
        verify(decanoService, times(1)).findAll();
    }

    @Test
    public void testSave() {
        Decano decano = new Decano(1L, "John Doe", "johndoe@example.com", "Office 1", "Facultad 1");
        when(decanoService.save(decano)).thenReturn(new ResponseEntity<>(decano, HttpStatus.CREATED));

        ResponseEntity<Decano> result = decanoController.save(decano);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        verify(decanoService, times(1)).save(decano);
    }

    @Test
    public void testFindById() {
        Decano decano = new Decano(1L, "John Doe", "johndoe@example.com", "Office 1", "Facultad 1");
        when(decanoService.findById(1L)).thenReturn(new ResponseEntity<>(decano, HttpStatus.OK));

        ResponseEntity<Decano> result = decanoController.findById(1L);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(decanoService, times(1)).findById(1L);
    }

    @Test
    public void testDelete() {
        when(decanoService.delete(1L)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        ResponseEntity<Decano> result = decanoController.delete(1L);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(decanoService, times(1)).delete(1L);
    }

    @Test
    public void testUpdate() {
        Decano decano = new Decano(1L, "John Doe", "johndoe@example.com", "Office 1", "Facultad 1");
        when(decanoService.update(decano)).thenReturn(new ResponseEntity<>(decano, HttpStatus.OK));

        ResponseEntity<Decano> result = decanoController.update(decano);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(decanoService, times(1)).update(decano);
    }
}
