package com.udea.Fabrica_g6_v2.controllers;

import com.udea.Fabrica_g6_v2.models.Calendario;
import com.udea.Fabrica_g6_v2.models.Decano;
import com.udea.Fabrica_g6_v2.models.Facultad;
import com.udea.Fabrica_g6_v2.models.ViceDecano;
import com.udea.Fabrica_g6_v2.services.CalendarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalendarioController.class)
public class CalendarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalendarioService calendarioService;

    @Test
    public void testFindAll() throws Exception {
        // Crear objetos necesarios para el test
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
                "2022-1",
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

        // Crear lista de calendarios y agregar el objeto calendario creado anteriormente
        List<Calendario> calendarios = new ArrayList<>();
        calendarios.add(calendario);

        // Simular el comportamiento del método findAll() del servicio CalendarioService
        when(calendarioService.findAll()).thenReturn(calendarios);

        // Realizar solicitud GET a /api/calendarios y verificar la respuesta
        mockMvc.perform(get("/api/calendarios"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].facultad.nombre", is("Ingeniería")))
                //.andExpect(jsonPath("$[0].semestre", is("2022-1")))
                .andExpect(jsonPath("$[0].publicacionOferta", is("2022-01-01")))
                .andExpect(jsonPath("$[0].inicioMatriculas", is("2022-01-15")))
                .andExpect(jsonPath("$[0].finMatriculas", is("2022-01-31")))
                .andExpect(jsonPath("$[0].inicioAjustes", is("2022-02-01")))
                .andExpect(jsonPath("$[0].finAjustes", is("2022-02-15")))
                .andExpect(jsonPath("$[0].inicioClases", is("2022-02-16")))
                .andExpect(jsonPath("$[0].finClases", is("2022-06-15")))
                .andExpect(jsonPath("$[0].inicioExamenesFinales", is("2022-06-16")))
                .andExpect(jsonPath("$[0].finExamenesFinales", is("2022-06-30")))
                .andExpect(jsonPath("$[0].inicioValidaciones", is("2022-07-01")))
                .andExpect(jsonPath("$[0].finValidaciones", is("2022-07-15")))
                .andExpect(jsonPath("$[0].inicioHabilitaciones", is("2022-07-16")))
                .andExpect(jsonPath("$[0].finHabilitaciones", is("2022-07-31")))
                .andExpect(jsonPath("$[0].terminacionOficinal", is("2022-08-01")));




        verify(calendarioService, times(1)).findAll();
    }
}

