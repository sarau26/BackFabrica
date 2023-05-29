package com.udea.Fabrica_g6_v2.repositories;


import com.udea.Fabrica_g6_v2.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,String> {
}
