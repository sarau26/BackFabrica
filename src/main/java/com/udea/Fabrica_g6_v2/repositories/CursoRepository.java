package com.udea.Fabrica_g6_v2.repositories;

import com.udea.Fabrica_g6_v2.models.Curso;
import com.udea.Fabrica_g6_v2.models.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    Optional<Curso> findByMateriaAndProgramaAcademicoAndVersionPensum
            (Materia idMateria, String programa, Integer version);
}
