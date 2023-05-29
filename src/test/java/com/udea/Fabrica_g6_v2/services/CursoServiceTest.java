package com.udea.Fabrica_g6_v2.services;

import com.udea.Fabrica_g6_v2.dto.MateriaProgramaVersionDto;
import com.udea.Fabrica_g6_v2.models.Curso;
import com.udea.Fabrica_g6_v2.models.Materia;
import com.udea.Fabrica_g6_v2.repositories.CursoRepository;
import com.udea.Fabrica_g6_v2.repositories.MateriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.when;

class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @Mock
    private MateriaRepository materiaRepository;

    @InjectMocks
    private CursoService cursoService;

    private Curso curso;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        curso = new Curso();
        curso.setMateria(new Materia(495));
        curso.setCodigoCurso(1);
    }

    @Test
    void findAll() {
        when(cursoRepository.findAll()).thenReturn(Arrays.asList(curso));
        assertNotNull(cursoService.findAll());
    }

    @Test
    void save(){
        when(cursoRepository.save(any(Curso.class)))
                .thenReturn(curso);
        assertNotNull(cursoService.save(curso));
    }

    @Test
    void findById(){
        when(cursoRepository.findById(any(Integer.class)))
                .thenReturn(Optional.ofNullable(curso));
        assertNotNull(cursoService.findById(curso.getCodigoCurso()));
    }

    @Test
    void getId(){
        when(cursoRepository.findByMateriaAndProgramaAcademicoAndVersionPensum(
                any(Materia.class), any(String.class), any(Integer.class)))
                .thenReturn(Optional.ofNullable(curso));
        assertNotNull(cursoService.
                getId(new MateriaProgramaVersionDto(0, "IS", 2)));
    }
}