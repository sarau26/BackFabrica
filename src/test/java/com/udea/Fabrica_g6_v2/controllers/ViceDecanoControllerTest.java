package com.udea.Fabrica_g6_v2.controllers;

import com.udea.Fabrica_g6_v2.controllers.ViceDecanoController;
import com.udea.Fabrica_g6_v2.models.ViceDecano;
import com.udea.Fabrica_g6_v2.services.ViceDecanoService;
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

public class ViceDecanoControllerTest {

    @InjectMocks
    private ViceDecanoController viceDecanoController;

    @Mock
    private ViceDecanoService viceDecanoService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<ViceDecano> viceDecanos = new ArrayList<>();
        viceDecanos.add(new ViceDecano(1L, "Andrés David", "andres.david@udea.edu.co", "21-412", "Ingeniería"));
        viceDecanos.add(new ViceDecano(2L, "Victor Restrepo", "victor.restrepo@udea.edu.co", "21-413", "Ciencias"));

        when(viceDecanoService.findAll()).thenReturn(viceDecanos);

        List<ViceDecano> result = viceDecanoController.findAll();
        assertEquals(2, result.size());
        assertEquals("Andrés David", result.get(0).getNombre());
        assertEquals("Victor Restrepo", result.get(1).getNombre());
        verify(viceDecanoService, times(1)).findAll();
    }

    @Test
    public void testSave() {
        ViceDecano viceDecano = new ViceDecano(1L, "Maria Rodriguez", "Andrés.rodriguez@udea.edu.co", "21-412", "Ingeniería");
        when(viceDecanoService.save(viceDecano)).thenReturn(new ResponseEntity<>(viceDecano, HttpStatus.CREATED));

        ResponseEntity<ViceDecano> result = viceDecanoController.save(viceDecano);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        verify(viceDecanoService, times(1)).save(viceDecano);
    }

    @Test
    public void testFindById() {
        ViceDecano viceDecano = new ViceDecano(1L, "Maria Rodriguez", "Andrés.rodriguez@udea.edu.co", "21-412", "Ingeniería");
        when(viceDecanoService.findById(1L)).thenReturn(new ResponseEntity<>(viceDecano, HttpStatus.OK));

        ResponseEntity<ViceDecano> result = viceDecanoController.findById(1L);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(viceDecanoService, times(1)).findById(1L);
    }

    @Test
    public void testDelete() {
        when(viceDecanoService.delete(1L)).thenReturn(new ResponseEntity<>(HttpStatus.NO_CONTENT));

        ResponseEntity<ViceDecano> result = viceDecanoController.delete(1L);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(viceDecanoService, times(1)).delete(1L);
    }

    @Test
    public void testUpdate() {
        ViceDecano viceDecano = new ViceDecano(1L, "Maria Rodriguez", "Andrés.rodriguez@udea.edu.co", "21-412", "Ingeniería");
        when(viceDecanoService.update(viceDecano)).thenReturn(new ResponseEntity<>(viceDecano, HttpStatus.OK));

        ResponseEntity<ViceDecano> result = viceDecanoController.update(viceDecano);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(viceDecanoService, times(1)).update(viceDecano);
    }


}