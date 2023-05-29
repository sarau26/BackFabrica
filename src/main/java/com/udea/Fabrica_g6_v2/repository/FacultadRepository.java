package com.udea.Fabrica_g6_v2.repository;

import com.udea.Fabrica_g6_v2.models.Facultad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultadRepository extends JpaRepository<Facultad,Long> {
}
