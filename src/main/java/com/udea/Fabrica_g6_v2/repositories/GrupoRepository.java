package com.udea.Fabrica_g6_v2.repositories;


import com.udea.Fabrica_g6_v2.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo,String> {
}
